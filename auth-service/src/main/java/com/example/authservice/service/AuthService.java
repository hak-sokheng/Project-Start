package com.example.authservice.service;

import com.example.authservice.dto.request.LoginRequest;
import com.example.authservice.dto.response.LoginResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Hak Sokheng
 * Date     : 4/25/2022, 3:23 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
public interface AuthService {
    LoginResponse login(LoginRequest loginRequest, HttpServletRequest request);
}
