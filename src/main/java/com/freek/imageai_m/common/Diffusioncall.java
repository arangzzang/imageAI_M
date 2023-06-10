package com.freek.imageai_m.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Slf4j
@RequestMapping("/image")
public class Diffusioncall {

    @GetMapping("/restcall")
    public List<Map<String,Object>> restcalltest(HttpServletRequest requst, HttpServletResponse response){

        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        try{

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Diffusion controller Logger >>>>> " + e);
        }





        return result;
    }
}




