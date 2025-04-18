package com.example.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ApiResponseWrapper<T> {
    private String status;
    private T data;
    private String error;

    public ApiResponseWrapper(String status, T data, String error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static <T> ApiResponseWrapper<T> success(T data) {
        return new ApiResponseWrapper<>("success", data, null);
    }

    public static <T> ApiResponseWrapper<T> error(String error) {
        return new ApiResponseWrapper<>("error", null, error);
    }
}