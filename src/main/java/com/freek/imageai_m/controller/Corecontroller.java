package com.freek.imageai_m.controller;

import com.freek.imageai_m.serviece.Diffusionservice;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@Slf4j
@RequestMapping("/image")
@Component
public class Corecontroller {
//    private Logger logger

    @Autowired
//    Diffusionservice dfsService;

    @GetMapping("/home")
    @ResponseBody
    public String test(){
        return "index";
    }

//    @RequestMapping(value="/", method = {RequestMethod.POST})
    public ModelAndView multipartabc(@RequestParam String item, @RequestParam MultipartFile file, HttpServletRequest req) {

        ModelAndView mv = new ModelAndView();
        Map<String,Object> result = new HashMap<String, Object>();

//        result = dfsService;

        mv.addObject(result);
        mv.setViewName("");
        return mv;
    }
}
