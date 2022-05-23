package com.example.usermanagementservice.dto.response;

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
}
