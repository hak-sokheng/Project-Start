package com.example.usermanagementservice.controller;

import com.example.usermanagementservice.dto.request.TesterRequest;
import com.example.usermanagementservice.dto.response.PaginationResponse;
import com.example.usermanagementservice.dto.response.TesterResponse;
import com.example.usermanagementservice.service.TesterService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hak Sokheng
 * Date     : 5/17/2022, 11:37 AM
 * Email    : sokheng.hak@prasac.com.kh
 */

@RestController
@RequestMapping("/tester")
public class TesterController {

    private final TesterService testerService;

    public TesterController(TesterService testerService) {
        this.testerService = testerService;
    }

    @PostMapping
    public TesterResponse createTester(@RequestBody TesterRequest testerRequest){
        return testerService.createOrUpdateTester(testerRequest, 0L);
    }

    @PutMapping("/{id}")
    public TesterResponse updateTester(@RequestBody TesterRequest testerRequest, @PathVariable("id") Long id){
        return testerService.createOrUpdateTester(testerRequest, id);
    }

    @GetMapping("/{id}")
    public TesterResponse findTesterById(@PathVariable("id") Long id){
        return testerService.findTesterById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTester(@PathVariable("id") Long id){
        testerService.deleteTester(id);
    }

    @GetMapping("/pagination")
    public PaginationResponse findAllUserByPagination(@RequestParam(value = "query", required = false) String query,
                                                      @RequestParam(value = "active", required = false) Boolean active,
                                                      @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                      @RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {
        return testerService.findAllTesterByPagination(query, page, size);
    }
}
