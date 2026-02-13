package com.rashoj.StudnetManagementSystemAdmin.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class greet {
    private final RestTemplate restTemplate;
    private final String Student_url="http://localhost:8080/api/test";
    @GetMapping("/")
    public String greet(){

//header,pathVariable,pathParams,
return "hello";
    }
}
