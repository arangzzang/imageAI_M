package com.freek.imageai_m.diffusion.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/image")
public class Hello {

    @GetMapping("/")
//    @ResponseBody 그냥 값만보낼때 사용하는 어노테이션
    public String test(){

        return "/index";
    }

//    @GetMapping("/home")
//    public String home(){
//        return "/index";
//    }


////    @RequestMapping(value="/", method = {RequestMethod.POST})
//    public Map<String,Object> multipartabc(MultipartHttpServletRequest req, MultipartFile file) {
//
//        Map<String,Object> result = new HashMap<String, Object>();
//
//        return result;
//    }
}
