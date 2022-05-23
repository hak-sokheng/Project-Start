package com.example.authservice.service;

import com.example.authservice.dto.request.LoginRequest;
import com.example.authservice.dto.response.LoginResponse;
import com.example.authservice.repository.UserLogActivityRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Hak Sokheng
 * Date     : 4/25/2022, 3:57 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
@Service
public class AuthServiceImpl implements AuthService{

    private final UserLogActivityRepository userLogActivityRepository;

    public AuthServiceImpl(UserLogActivityRepository userLogActivityRepository) {
        this.userLogActivityRepository = userLogActivityRepository;
    }
    @Value("${oauth_id}")
    private String oauthId;

    @Value("${oauth_secret}")
    private String oauthSecret;

    @Value("${user.management.base.url}")
    private String userTrackingUrl;

    @Override
    public LoginResponse login(LoginRequest loginRequest, HttpServletRequest request) {
        return null;
    }
}
