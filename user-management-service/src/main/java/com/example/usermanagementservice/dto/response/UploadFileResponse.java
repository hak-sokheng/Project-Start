package com.example.usermanagementservice.dto.response;

import com.example.usermanagementservice.entity.UploadEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

/**
 * Created by Hak Sokheng
 * Date     : 5/20/2022, 1:21 PM
 * Email    : sokheng.hak@prasac.com.kh
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadFileResponse {
    private Long id;
    private Long userId;
    private String fileName;
    private String path;
    private Boolean status;

    public UploadFileResponse(UploadEntity uploadEntity) {
        this.id = uploadEntity.getId();
        this.userId = uploadEntity.getUserId();
        this.fileName = uploadEntity.getFileName();
        this.path = uploadEntity.getPath();
        this.status = uploadEntity.getStatus();
    }
}
