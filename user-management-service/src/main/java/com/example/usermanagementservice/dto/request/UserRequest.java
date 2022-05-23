package com.example.usermanagementservice.dto.request;

import lombok.Data;

import java.util.Date;

/**
 * Created by Hak Sokheng
 * Date     : 3/21/2022, 2:10 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
@Data
public class UserRequest {
    private String nameEn;
    private String nameKh;
    private String password;
    private String email;
    private boolean status;
    private Date created_date;
}
