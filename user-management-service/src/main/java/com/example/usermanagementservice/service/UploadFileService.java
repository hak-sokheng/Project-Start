package com.example.usermanagementservice.service;

import com.example.usermanagementservice.dto.response.UploadFileResponse;
import com.example.usermanagementservice.entity.UploadEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by Hak Sokheng
 * Date     : 5/20/2022, 1:22 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
public interface UploadFileService {
    UploadFileResponse uploadFiles(MultipartFile file, Long userId) throws IOException;

    void deleteFile(Long uploadId);
}
