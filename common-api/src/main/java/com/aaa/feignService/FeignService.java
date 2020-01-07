package com.aaa.feignService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "IMG-PROVIDER")
public interface FeignService {
    @RequestMapping(value = "/up",produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public boolean upload(@RequestPart("file") MultipartFile file);
    @RequestMapping("/all")
    public boolean all();
}
