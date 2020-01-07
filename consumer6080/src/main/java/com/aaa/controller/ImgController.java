package com.aaa.controller;

import com.aaa.feignService.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImgController {
    @Autowired
    private FeignService service;
    @RequestMapping("/up")
    public boolean upload(@RequestParam("file") MultipartFile file){
        System.out.println("进入到consumer的controller");
        return service.upload(file);
    }
    @RequestMapping("/all")
    public boolean all(){
        return service.all();
    }

}
