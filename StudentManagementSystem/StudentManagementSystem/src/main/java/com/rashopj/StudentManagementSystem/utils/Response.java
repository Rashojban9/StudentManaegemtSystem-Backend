package com.rashopj.StudentManagementSystem.utils;

import org.springframework.http.ResponseEntity;


public class Response {
    public static <T> ResponseEntity<ApiResponse<T>> sucess(String message, T data) {
        return ApiResponse.success(message, data);
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(String message, T data) {
        return ApiResponse.created(message, data);
    }

}
