package com.xpxp.Controller.Common;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file UploadController
 * @author thexpxp233
 * @date 2025/11/13
 * My name is lixiaopei
 **/

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/common/upload")
@Tag(name = "图片上传")
@Slf4j
public class UploadController {
    @Autowired
    private FileStorageService fileStorageService;//注入实列

    @PostMapping
    @Operation(summary = "图片")
    public String upload2(MultipartFile file) {
        log.info("file:{}",file);
        String FileName = FileName(file);
        log.info("上传成功");
        return FileName;
    }


    /**
     * 获取到对应的名字
     * @param file
     * @return
     */
    private String FileName(MultipartFile file) {
        String objectFile = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")) + "";
        FileInfo fileInfo = fileStorageService.of(file)
                .setPath(objectFile+"/")
                .upload();  //将文件上传到对应地方
        return fileInfo == null ? "上传失败！" : fileInfo.getUrl();
    }

}