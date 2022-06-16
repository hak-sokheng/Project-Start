package com.example.usermanagementservice.service;

import com.example.usermanagementservice.dto.response.UploadFileResponse;
import com.example.usermanagementservice.entity.UploadEntity;
import com.example.usermanagementservice.entity.UserEntity;
import com.example.usermanagementservice.repository.UploadFileRepository;
import com.example.usermanagementservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

/**
 * Created by Hak Sokheng
 * Date     : 5/20/2022, 1:24 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
@Service
public class UploadFileServiceImpl implements UploadFileService{
    private final UploadFileRepository uploadFileRepository;
    private final UserRepository userRepository;
    private final Path path = Paths.get("D:\\SpringBoot\\user-management\\upload_files\\");

    @Autowired
    public UploadFileServiceImpl(UploadFileRepository uploadFileRepository, UserRepository userRepository) {
        this.uploadFileRepository = uploadFileRepository;
        this.userRepository = userRepository;
    }


    @Override
    public UploadFileResponse uploadFiles(MultipartFile file, Long userId) throws IOException {

        UploadEntity uploadEntity = new UploadEntity();
        uploadEntity.setFileName(file.getOriginalFilename());
        uploadEntity.setPath("D:\\SpringBoot\\user-management\\upload_files\\");
        uploadEntity.setStatus(true);
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        uploadEntity.setUserId(userId);
        if (!userEntity.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        file.transferTo(new File("D:\\SpringBoot\\user-management\\upload_files\\"+file.getOriginalFilename()));
        uploadFileRepository.save(uploadEntity);
        return new UploadFileResponse(uploadEntity);
    }

    @Override
    public UploadFileResponse findById(Long uploadId) {
        Optional<UploadEntity> uploadEntity = uploadFileRepository.findById(uploadId);
        return uploadEntity.map(UploadFileResponse::new).orElse(null);
    }

    @Override
    public void deleteFile(List<String> fileToDeletes, Long uploadId) {
        fileToDeletes.forEach(fn -> {
                    UploadEntity uploadEntity = uploadFileRepository.findByFileNameAndUploadId(fn, uploadId);
                    if (uploadEntity == null)
                        throw new IllegalArgumentException("Not found");

                });


        uploadFileRepository.deleteById(uploadId);
    }
}
