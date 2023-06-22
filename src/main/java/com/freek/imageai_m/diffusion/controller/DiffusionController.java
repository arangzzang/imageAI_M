package com.freek.imageai_m.diffusion.controller;

import com.freek.imageai_m.diffusion.service.impl.DiffusionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin("*")
@RestController
@Slf4j
@RequestMapping("/Diffusion")
public class DiffusionController {
    
//    private static final Logger Logger = LoggerFactory.getLogger(DiffusionController.class);




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

    @GetMapping("/showImage")
    public ResponseEntity<Resource> showImage(@RequestParam Map<String, String> param) {
//        Logger.info("\n");
//        Logger.info("=======================================");
//        Logger.info("[ModuleApiController] : [showImage] : [start]");
//        Logger.info("[request name] : " + String.valueOf(param.get("name")));
//        Logger.info("=======================================");
//        Logger.info("\n");

        // 시스템 os 정보 확인 변수 선언
        String os = System.getProperty("os.name").toLowerCase();



        // 사진이 저장된 폴더 경로 변수 선언
        String imageRoot = "";


        // os 정보 확인 및 사진이 저장된 서버 로컬 경로 지정 실시
        // 로컬 : Home/Resource/assets 폴더는 이미지 파일을 공통적으로 저장 관리
        if(os.contains("win")) {
            imageRoot = "F:/PJT/imageAI_M/src/webapp/resources/files"; //윈도우 경로 (디스크 필요)
        }
        else if(os.contains("linux")) {
            imageRoot = "/Home/Resource/assets/"; //리눅스 경로
        }


        // 서버 로컬 경로 + 파일 명 저장 실시
        imageRoot = imageRoot + String.valueOf(param.get("name"));
//        Logger.info("\n");
//        Logger.info("=======================================");
//        Logger.info("[ModuleApiController] : [showImage] : [imageRoot]");
//        Logger.info("[경로] : " + imageRoot);
//        Logger.info("=======================================");
//        Logger.info("\n");


        // Resorce를 사용해서 로컬 서버에 저장된 이미지 경로 및 파일 명을 지정
        Resource resource = new FileSystemResource(imageRoot);


        // 로컬 서버에 저장된 이미지 파일이 없을 경우
        if(!resource.exists()){
//            Logger.info("FILE : NOT_FOUND");
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

}





