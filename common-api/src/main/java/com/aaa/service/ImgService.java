package com.aaa.service;

import com.aaa.utils.FTPUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImgService {
    public boolean upload(MultipartFile file){
        boolean b =false;
        try {
           b =  FTPUtil.upload(file.getOriginalFilename(),file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
}
