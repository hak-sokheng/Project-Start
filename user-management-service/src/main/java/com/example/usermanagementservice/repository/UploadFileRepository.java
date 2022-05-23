package com.example.usermanagementservice.repository;

import com.example.usermanagementservice.entity.UploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Hak Sokheng
 * Date     : 5/20/2022, 1:28 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
public interface UploadFileRepository extends JpaRepository<UploadEntity, Long> {
}
