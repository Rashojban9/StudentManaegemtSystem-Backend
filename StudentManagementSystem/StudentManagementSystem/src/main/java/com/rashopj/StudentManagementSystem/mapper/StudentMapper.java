package com.rashopj.StudentManagementSystem.mapper;

import com.rashopj.StudentManagementSystem.dto.request.StudentSignupReqDto;
import com.rashopj.StudentManagementSystem.dto.response.StudentSignupResDto;
import com.rashopj.StudentManagementSystem.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student tomodel(StudentSignupReqDto studentSignupReqDto);

    StudentSignupResDto toResDto(Student student);


}
