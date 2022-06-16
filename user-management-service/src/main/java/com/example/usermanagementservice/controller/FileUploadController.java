package com.example.usermanagementservice.controller;

import com.example.usermanagementservice.dto.response.UploadFileResponse;
import com.example.usermanagementservice.service.UploadFileService;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
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
    public UploadFileResponse uploadFile(@RequestParam("file")MultipartFile file, @RequestParam Long userId) throws IOException {
        return uploadFileService.uploadFiles(file, userId);
    }

    @DeleteMapping("/{id}")
    public void deleteFiles(@RequestParam List<String> fileToDeletes,@PathVariable("id") Long uploadId) {
        uploadFileService.deleteFile(fileToDeletes, uploadId);
    }

    @GetMapping("/{uploadId}")
    public UploadFileResponse getFileById(@PathVariable("uploadId") Long uploadId){
        return uploadFileService.findById(uploadId);
    }
}
