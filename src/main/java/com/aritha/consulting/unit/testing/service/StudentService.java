package com.aritha.consulting.unit.testing.service;

import com.aritha.consulting.unit.testing.dto.StudentDTO;

import java.util.List;

/**
 * ? @projectName unit-testing
 * ? @author Rohit M Lakshmikanth
 * ? @createdOn  November 02,2022 at 08:18 PM
 */
public interface StudentService {

    List<StudentDTO> getAllStudent();

    List<StudentDTO> searchStudent(String search);
}
