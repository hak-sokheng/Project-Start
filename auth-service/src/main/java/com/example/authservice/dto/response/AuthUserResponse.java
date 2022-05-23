package com.example.authservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserResponse implements Serializable {

    private static final long serialVersionUID = 5628098058409934174L;

    private Long id;
    private String username;
    private String fullName;
    private String emailAddress;
    private String phoneNumber;
    private String password;
    private Boolean status;
    private Boolean isArchive;


}
