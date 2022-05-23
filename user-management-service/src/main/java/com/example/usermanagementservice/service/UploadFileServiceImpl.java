package com.example.usermanagementservice.service;

import com.example.usermanagementservice.entity.UploadEntity;
import com.example.usermanagementservice.repository.UploadFileRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Hak Sokheng
 * Date     : 5/20/2022, 1:24 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
@Service
public class UploadFileServiceImpl implements UploadFileService{
    private final UploadFileRepository uploadFileRepository;

    public UploadFileServiceImpl(UploadFileRepository uploadFileRepository) {
        this.uploadFileRepository = uploadFileRepository;
    }

    @Override
    public void uploadFiles(MultipartFile file, Long userId) throws IOException {
        file.transferTo(new File("D:\\SpringBoot\\user-management\\upload_files\\"+file.getOriginalFilename()));
        UploadEntity uploadEntity = new UploadEntity();
        uploadEntity.setFileName(file.getOriginalFilename());
        uploadEntity.setPath("D:\\SpringBoot\\user-management\\upload_files\\");
        uploadEntity.setUserId(userId);
        uploadEntity.setStatus(true);

        uploadFileRepository.save(uploadEntity);
    }
}
