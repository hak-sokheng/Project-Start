package com.example.usermanagementservice.client;

import lombok.Data;

import java.util.Date;

/**
 * Created by Hak Sokheng
 * Date     : 6/14/2022, 10:10 AM
 * Email    : sokheng.hak@prasac.com.kh
 */
@Data
public class UserRequestc {
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private Boolean status;

    public UserRequestc(String username, String email, String phoneNumber, String password, Boolean status) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.status = status;
    }
}
