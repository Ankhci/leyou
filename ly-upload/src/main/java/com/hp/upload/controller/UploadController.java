package com.hp.upload.controller;

import com.hp.upload.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName UploadController
 * @Description 控制层
 * @Author Ankhci
 * @Date 2020/1/3 23:23
 **/
@RestController
@RequestMapping("upload")
public class UploadController {
    //控制层注入服务层 Autowired自动注入
    @Autowired
    private UploadService uploadService;

    /**
     * @Description
     *  * @param ResponseEntity<String>
     * @Return
     * @Exception   上传图片的方法
     * @Author      Ankhci
     * @Date        2020/1/3 23:29
     */
    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("file")MultipartFile file){
        //调用service 上传图片，返回图片地址
        String url = uploadService.uploadImage(file);
        //判断传回来的图片路径是否为空
        if(url != null){
            return ResponseEntity.ok(url);
        }
        //为空返回没有内容 204
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
