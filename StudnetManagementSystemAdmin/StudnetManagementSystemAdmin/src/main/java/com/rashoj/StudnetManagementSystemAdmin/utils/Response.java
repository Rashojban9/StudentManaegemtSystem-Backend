package com.rashoj.StudnetManagementSystemAdmin.utils;

import org.springframework.http.ResponseEntity;

public class Response {
    public static <T>ResponseEntity<ApiResponse<T>> sucess(String message,T data){
        return ApiResponse.sucess(message,data);
    }
}
