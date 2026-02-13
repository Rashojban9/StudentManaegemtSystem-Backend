package com.rashopj.StudentManagementSystem.mapper;

import com.rashopj.StudentManagementSystem.dto.request.StudentSignupReqDto;
import com.rashopj.StudentManagementSystem.dto.response.StudentSignupResDto;
import com.rashopj.StudentManagementSystem.model.Student;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-12T15:59:23+0545",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student tomodel(StudentSignupReqDto studentSignupReqDto) {
        if ( studentSignupReqDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setFirstName( studentSignupReqDto.getFirstName() );
        student.setLastName( studentSignupReqDto.getLastName() );
        student.setEmail( studentSignupReqDto.getEmail() );
        student.setPassword( studentSignupReqDto.getPassword() );
        student.setDob( studentSignupReqDto.getDob() );

        return student;
    }

    @Override
    public StudentSignupResDto toResDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentSignupResDto studentSignupResDto = new StudentSignupResDto();

        studentSignupResDto.setEmail( student.getEmail() );

        return studentSignupResDto;
    }
}
