package com.freek.imageai_m.diffusion.controller;

import com.freek.imageai_m.diffusion.service.impl.DiffusionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//@CrossOrigin("*")
//@RestController
@Controller
@Slf4j(topic = "rolling")
@RequestMapping("/Diffusion")
public class DiffusionController {
    
    private static final Logger Logger = LoggerFactory.getLogger(DiffusionController.class);
    private static PythonInterpreter interpreter;

    @RequestMapping("/test")
    public String imgtest(){
        return "/DiffusionTest";
    }

//    @RequestMapping(value="/diffusionCall", method = {RequestMethod.POST})
//    public String diffusionCall(@RequestParam List<Map<String,Object>> item, @RequestParam MultipartFile file) throws Exception{
//
//        ModelAndView mv = new ModelAndView();
//        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
//
//        DiffusionServiceImpl.diffusionCall(item,file);
//
//
//        return "/DiffusionTest1";
//    }
    @GetMapping("/py_connection_test")
    public String testpy (){

        System.setProperty("python.import.site","false");
        interpreter = new PythonInterpreter();
        interpreter.execfile("src/main/python/test.py");
        interpreter.exec("print(testFunc(5,10))");
//        try(PythonInterpreter pyInterp = new PythonInterpreter()) {
//            interpreter.exec("print('Hello Python!!!')");
//        }

        PyFunction pyFunction = interpreter.get("testFunc", PyFunction.class);

        int a = 10;
        int b = 20;

        PyObject pyobj = pyFunction.__call__(new PyInteger(a), new PyInteger(b));
        System.out.println(pyobj.toString());

        return pyobj.toString();
    }
    /*shellScript 실행시키기*/
    public static void main(String[] args) {

//        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println(":: START :: Use Runtime ");
        String homeDirectory = System.getProperty("user.dir");
        System.out.println(":: Working Directory is " + homeDirectory);
        if(os.contains("win")){

        } else if (os.contains("mac")) {

        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {

        } else if (os.contains("linux")) {

        } else if (os.contains("sunos")) {

        }
       /* ProcessBuilder processBuilder = new ProcessBuilder();

        // 서버용
//        processBuilder.command("/tmp/myscript.sh");
        // 로컬용
//        processBuilder.command("F:/PJT/imageAI_M/src/main/resources/templates/test.sh");
//        processBuilder.command("C:/Anaconda/Script/activate.bat");
        processBuilder.command("C:\\Anaconda\\Scripts\\activate.bat");

        try {
            // Run script
            Process process = processBuilder.start();

            // Read output
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            System.out.println(output.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*try {
//             Run script
//            Process process = Runtime.getRuntime().exec("/tmp/test.sh");
            Process process = Runtime.getRuntime().exec("F:/PJT/imageAI_M/src/main/resources/templates/test.sh");

            // Read output
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            System.out.println(output.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }
    @GetMapping("/showImage")
    public ResponseEntity<Resource> showImage(@RequestParam Map<String, String> param ) {
        System.out.println("\n");
        System.out.println("=======================================");
        System.out.println("[ModuleApiController] : [showImage] : [start]");
        System.out.println("[request name] : " + String.valueOf(param.get("paramT")));
        System.out.println("[request file] : " + String.valueOf(param.get("paramF")));
        System.out.println("=======================================");
        System.out.println("\n");


        System.out.println("param >>>>>>>>>>>>>> " + param);

        // 시스템 os 정보 확인 변수 선언
        String os = System.getProperty("os.name").toLowerCase();

        // 사진이 저장된 폴더 경로 변수 선언
        String imageRoot = "";



        // os 정보 확인 및 사진이 저장된 서버 로컬 경로 지정 실시
        // 로컬 : Home/Resource/assets 폴더는 이미지 파일을 공통적으로 저장 관리
        if(os.contains("win")) {
//            imageRoot = "F:/PJT/imageAI_M/src/webapp/resources/files"; //윈도우 경로 (디스크 필요)
            imageRoot = "F:/PJT/imageAI_M/resources/static/image/"; //윈도우 경로 (디스크 필요)
        }
        else if(os.contains("linux")) {
            imageRoot = "/Home/Resource/assets/"; //리눅스 경로
        }

        // 서버 로컬 경로 + 파일 명 저장 실시
        imageRoot = imageRoot + String.valueOf(param.get("paramT"));
        System.out.println("\n");
        System.out.println("=======================================");
        System.out.println("[ModuleApiController] : [showImage] : [imageRoot]");
        System.out.println("[경로] : " + imageRoot);
        System.out.println("=======================================");
        System.out.println("\n");

        // Resorce를 사용해서 로컬 서버에 저장된 이미지 경로 및 파일 명을 지정
        Resource resource = new FileSystemResource(imageRoot);

        // 로컬 서버에 저장된 이미지 파일이 없을 경우
        if(!resource.exists()){
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND); // 리턴 결과 반환 404
        }

        // 로컬 서버에 저장된 이미지가 있는 경우 로직 처리
        HttpHeaders header = new HttpHeaders();
        Path filePath = null;
        try {
            filePath = Paths.get(imageRoot);
            // 인풋으로 들어온 파일명 .png / .jpg 에 맞게 헤더 타입 설정
            header.add("Content-Type", Files.probeContentType(filePath));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // 이미지 리턴 실시 [브라우저에서 get 주소 확인 가능]
        return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);

    }

//    @ApiOperation(value = "feed image 조회 ", notes = "feed Image를 반환합니다. 못찾은경우 기본 image를 반환합니다.")
    @GetMapping(value = "/showImage2/{imagename}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> userSearch(@PathVariable("imagename") String imagename) throws IOException {
        System.out.println("showImage2 start");
        log.info("imagename >>> " + imagename);
        InputStream imageStream = new FileInputStream("F://PJT/imageAI_M/resources/static/image/" + imagename);
        byte[] imageByteArray = IOUtils.toByteArray(imageStream);
        imageStream.close();
        return new ResponseEntity<byte[]>(imageByteArray, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/images/{filename}")
    public Resource showImage(@PathVariable String filename) throws
            MalformedURLException {
        FilenameUtils file = null;//
        return new UrlResource("file:" + file.getFullPath(filename));
    }

}





