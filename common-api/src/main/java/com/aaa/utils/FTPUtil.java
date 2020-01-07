package com.aaa.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
@Component
public class FTPUtil {
    @Autowired
    private  FTPClient ftpClient;
    private static FTPClient client;
    @PostConstruct
    private void init(){
        System.out.println(1231+"----------------------");
        client = this.ftpClient;
    }
    public static boolean upload(String fileName, InputStream in){
        boolean boo =true;
        try {
            //建立连接
            client.connect("hhnan.cn",21);
           //登录
            client.login("ftpuser", "1234");
           //得到登录返回状态码
            int code = client.getReplyCode();
            //通过验证状态码是否登陆成功
            if(!FTPReply.isPositiveCompletion(code)){
                client.disconnect();
                boo = false;
            }else {
                //设置文件类型为二进制
                client.setFileType(FTPClient.BINARY_FILE_TYPE);
                client.storeFile(fileName,in);
                in.close();
                client.logout();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (client.isConnected()){
                try {
                    client.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return boo;
    }
}
