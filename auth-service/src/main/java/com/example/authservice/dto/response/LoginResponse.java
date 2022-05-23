package com.example.authservice.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Khin Mengchhiv
 * Date     : 12/10/20, 9:17 AM
 * Email    : mengchhiv.khin@prasac.com.kh
 */

@Data
@Builder
public class LoginResponse implements Serializable {

    private static final long serialVersionUID = 2294109017037816844L;

    private String tokenType;
    private String accessToken;
    private Date accessExpiresIn;
    private String refreshToken;
    private Date refreshExpiresIn;
}
