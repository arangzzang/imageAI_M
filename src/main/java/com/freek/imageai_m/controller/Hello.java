package com.freek.imageai_m.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

//@RestController
@Slf4j
@RequestMapping("/image")

public class Hello {

    @RequestMapping("/test")
    public String test(){
        return "/index";
    }

//    @RequestMapping(value="/", method = {RequestMethod.POST})
    public Map<String,Object> multipartabc(MultipartHttpServletRequest req, MultipartFile file) {

        Map<String,Object> result = new HashMap<String, Object>();

        return result;
    }
}
