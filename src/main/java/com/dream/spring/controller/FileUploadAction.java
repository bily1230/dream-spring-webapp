package com.dream.spring.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by ning on 2017/8/31.
 */
@Component
@RequestMapping("/fileUpload")
public class FileUploadAction {
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public void fileUpload(MultipartFile file) throws IOException {
        System.out.print(file.getName());
        file.transferTo(new File("D:/data/"+file.getOriginalFilename()));
    }
}
