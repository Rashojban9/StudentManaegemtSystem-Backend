package com.rashopj.StudentManagementSystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Test {


    List<String> greet = List.of("hello", "hi");

    @GetMapping("/test/{id}")
    public String send() {
        return "hello";

    }


}
