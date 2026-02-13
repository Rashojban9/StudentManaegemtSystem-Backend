package com.rashoj.StudnetManagementSystemAdmin.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;
    private LocalDate timestamp;
    public static <T> ResponseEntity<ApiResponse<T>>sucess(String message,T data){
        ApiResponse<T> response=new ApiResponse<>(
                200,message,data,LocalDate.now()
        );
        return ResponseEntity.status(200).body(response);
    }
}
