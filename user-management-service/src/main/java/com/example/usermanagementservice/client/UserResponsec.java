package com.example.usermanagementservice.client;

import lombok.Data;

import java.util.Date;

/**
 * Created by Hak Sokheng
 * Date     : 6/14/2022, 10:10 AM
 * Email    : sokheng.hak@prasac.com.kh
 */
@Data
public class UserResponsec {
    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private Date lastLoginAt;
    private Boolean status;

}
