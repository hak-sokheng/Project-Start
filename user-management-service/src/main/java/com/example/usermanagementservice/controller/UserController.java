package com.example.usermanagementservice.controller;

import com.example.usermanagementservice.client.UserRequestc;
import com.example.usermanagementservice.client.UserResponsec;
import com.example.usermanagementservice.dto.request.UserRequest;
import com.example.usermanagementservice.dto.response.PaginationResponse;
import com.example.usermanagementservice.dto.response.UserResponse;
import com.example.usermanagementservice.entity.UserEntity;
import com.example.usermanagementservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Hak Sokheng
 * Date     : 3/21/2022, 2:17 PM
 * Email    : sokheng.hak@prasac.com.kh
 */
@CrossOrigin
@RestController
@RequestMapping("/usermanagement")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest, UserRequestc userRequestc ){
        return userService.createUser(userRequest,userRequestc);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@RequestBody UserRequest userRequest,UserRequestc userRequestc, @PathVariable("id") long id){
        return userService.updateUser(userRequest,userRequestc,id);
//        return null;
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable("id") long id){
        return userService.findUserById(id);
    }

    @GetMapping("/pagination")
    public PaginationResponse findAllUserByPagination(@RequestParam(value = "query", required = false) String query,
                                                      @RequestParam(value = "active", required = false) Boolean active,
                                                      @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                      @RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {
        return userService.findAllUserByPagination(query, page, size);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id){
        return userService.deleteUser(id);
    }
}
