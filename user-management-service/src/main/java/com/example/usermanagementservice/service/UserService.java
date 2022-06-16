package com.example.usermanagementservice.service;

import com.example.usermanagementservice.dto.request.UserRequest;
import com.example.usermanagementservice.dto.response.PaginationResponse;
import com.example.usermanagementservice.dto.response.UserResponse;
import com.example.usermanagementservice.entity.UserEntity;

/**
 * Created by Hak Sokheng
 * Date     : 4/7/2022, 4:09 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
public interface UserService {
    UserResponse createOrUpdate(UserRequest userRequest, Long id);
    UserResponse findUserById(Long id);
    PaginationResponse findAllUserByPagination(String query, Integer page, Integer size);
    String deleteUser(Long id);
}
