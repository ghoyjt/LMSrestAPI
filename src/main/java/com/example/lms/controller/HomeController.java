package com.example.lms.controller;

import com.example.lms.dto.ApiResponseWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public ApiResponseWrapper<String> home() {
        return ApiResponseWrapper.success("Welcome to LMS API");
    }
}