package com.example.usermanagementservice.service;

import com.example.usermanagementservice.client.UserRequestc;
import com.example.usermanagementservice.dto.request.UserRequest;
import com.example.usermanagementservice.dto.response.PaginationResponse;
import com.example.usermanagementservice.dto.response.UserResponse;

/**
 * Created by Hak Sokheng
 * Date     : 4/7/2022, 4:09 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
public interface UserService {
    UserResponse createUser(UserRequest userRequest, UserRequestc userRequestc);
    UserResponse updateUser(UserRequest userRequest, UserRequestc userRequestc, Long id);
    UserResponse findUserById(Long id);
    PaginationResponse findAllUserByPagination(String query, Integer page, Integer size);
    String deleteUser(Long id);
}
