package com.example.usermanagementservice.controller;

import com.example.usermanagementservice.dto.response.UploadFileResponse;
import com.example.usermanagementservice.service.UploadFileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by Hak Sokheng
 * Date     : 5/20/2022, 1:16 PM
 * Email    : sokheng.hak@prasac.com.kh
 */

@RestController
@RequestMapping("/uploadFile")
public class FileUploadController {

    private final UploadFileService uploadFileService;

    public FileUploadController(UploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

    @PostMapping
    public void uploadFile(@RequestParam("file")MultipartFile file, @RequestParam Long userId) throws IOException {
        uploadFileService.uploadFiles(file, userId);
    }

    @DeleteMapping("/{id}")
    public void deleteFiles(@PathVariable("id") Long uploadId) {
        uploadFileService.deleteFile(uploadId);
    }
}
