package com.example.usermanagementservice.repository;

import com.example.usermanagementservice.entity.UploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.io.File;
import java.util.List;

/**
 * Created by Hak Sokheng
 * Date     : 5/20/2022, 1:28 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
public interface UploadFileRepository extends JpaRepository<UploadEntity, Long> {
    @Query("SELECT U FROM UploadEntity U WHERE U.fileName=?1 AND U.id=?2")
    UploadEntity findByFileNameAndUploadId(String fileName, Long uploadId);

    @Query("SELECT U FROM UploadEntity U WHERE U.fileName=?1 AND U.userId=?2")
    UploadEntity findByFileNameAndUserId(String fileName, Long userId);

    @Modifying
    @Query("DELETE from UploadEntity U WHERE U.userId=?1 and U.fileName in (?2) ")
    void deleteUploadFile(Long registerId, List<String> fileName);

}
