package com.example.usermanagementservice.service;

import com.example.usermanagementservice.dto.request.TesterRequest;
import com.example.usermanagementservice.dto.response.PaginationResponse;
import com.example.usermanagementservice.dto.response.TesterResponse;
import com.example.usermanagementservice.util.response.BaseResponse;

import java.util.List;

/**
 * Created by Hak Sokheng
 * Date     : 07/Jun/2021, 8:35 AM
 * Email    : sokheng.hak@prasac.com.kh
 */
public interface TesterService {

    TesterResponse createOrUpdateTester(TesterRequest testerRequest, Long id);

    TesterResponse findTesterById(Long id);

    void deleteTester(Long id);

    PaginationResponse findAllTesterByPagination(String query, Integer page, Integer size);

}
