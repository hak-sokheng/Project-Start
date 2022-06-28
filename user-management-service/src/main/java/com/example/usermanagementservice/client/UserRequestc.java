package com.example.usermanagementservice.client;

import lombok.Data;


/**
 * Created by Hak Sokheng
 * Date     : 6/14/2022, 10:10 AM
 * Email    : sokheng.hak@prasac.com.kh
 */
@Data
public class UserRequestc {
    private String username;
    private String email;
    private String password;
    private Boolean status;

    public UserRequestc(String username, String email, String password, Boolean status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
    }

}
