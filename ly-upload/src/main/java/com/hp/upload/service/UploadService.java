package com.hp.upload.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import jdk.nashorn.internal.ir.CallNode;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName UploadService
 * @Description 服务层
 * @Author Ankhci
 * @Date 2020/1/3 23:25
 **/
@Service
public class UploadService {

    @Autowired
    private FastFileStorageClient client;

    public String uploadImage(MultipartFile file) {
            //单机上传
        /* //创建File对象
        File f = new File("D:\\Ankh\\Box\\JAVA_BLB\\JavaEE2\\java1901\\分布式微服务项目\\upload");
        if(!f.exists()){
            //如果路径地址不存在就创建
            f.mkdirs();
        }
        //保存图片
        try {
            file.transferTo(new File(f,file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "http://image.leyou.com/"+file.getOriginalFilename();*/

    /*    StorePath storePath = this.storageClient.uploadFile(
                new FileInputStream(file), file.length(), "png", null);*/
        String url = null;
        //获取浏览器穿过来的图片
        String originalFilename = file.getOriginalFilename();
        //获取传过来的图片后缀
        String ext = StringUtils.substringAfter(originalFilename,".");
        try {
        //上传
            StorePath storePath = client.uploadFile(file.getInputStream(),file.getSize(),ext,null);
            url =  "http://image.leyou.com/" + storePath.getFullPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }
}
