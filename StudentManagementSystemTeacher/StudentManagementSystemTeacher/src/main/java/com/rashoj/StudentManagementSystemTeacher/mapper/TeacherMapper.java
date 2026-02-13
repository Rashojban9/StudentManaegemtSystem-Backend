package com.rashoj.StudentManagementSystemTeacher.mapper;

import com.rashoj.StudentManagementSystemTeacher.dto.request.TeacherSaveReqDto;
import com.rashoj.StudentManagementSystemTeacher.dto.response.TeacherSaveDto;
import com.rashoj.StudentManagementSystemTeacher.model.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    Teacher toEntity(TeacherSaveReqDto teacherSaveReqDto);

    TeacherSaveDto toRes(Teacher teacher);
}
