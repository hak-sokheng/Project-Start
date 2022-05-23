package com.example.usermanagementservice.service;

import com.example.usermanagementservice.dto.response.UploadFileResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Hak Sokheng
 * Date     : 5/20/2022, 1:22 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
public interface UploadFileService {
    void uploadFiles(MultipartFile file, Long userId) throws IOException;
}
