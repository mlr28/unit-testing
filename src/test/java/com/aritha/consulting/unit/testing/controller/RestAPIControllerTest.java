package com.aritha.consulting.unit.testing.controller;

import com.aritha.consulting.unit.testing.dto.ResponseDTO;
import com.aritha.consulting.unit.testing.dto.StudentDTO;
import com.aritha.consulting.unit.testing.repository.StudentRepository;
import com.aritha.consulting.unit.testing.service.StudentService;
import org.hibernate.JDBCException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ? @projectName unit-testing
 * ? @author Rohit M Lakshmikanth
 * ? @createdOn  November 03,2022 at 12:34 AM
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class RestAPIControllerTest {

    @Autowired
    RestAPIController raController;

    @MockBean
    private StudentRepository studentRepository;
    List<StudentDTO> studentDTOList;

    @BeforeEach
    void setUp() {
        studentDTOList = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setName("guru");
        studentDTO.setClassName("5th");
        studentDTO.setMark(65L);
        studentDTO.setGender("male");
        studentDTOList.add(studentDTO);
        studentDTO = new StudentDTO();
        studentDTO.setId(2L);
        studentDTO.setName("pavan");
        studentDTO.setClassName("4th");
        studentDTO.setMark(85L);
        studentDTO.setGender("male");
        studentDTOList.add(studentDTO);

        //Injection to Controller
        StudentService studentService = (StudentService) ReflectionTestUtils.getField(raController,"studentService");

        // Injection to Service
        List<StudentDTO> studentList = (List<StudentDTO>) ReflectionTestUtils.getField(studentService,"globalStudentList");
        if(studentList==null || !studentList.isEmpty())
            studentList = new ArrayList<>();
        studentList.addAll(studentDTOList);
        ReflectionTestUtils.setField(studentService,"globalStudentList",studentList);
        ReflectionTestUtils.setField(studentService,"isActive", false);
            ReflectionTestUtils.setField(raController,"studentService",studentService);
    }

    @AfterEach
    void tearDown() {
        studentDTOList = null;
    }

    @Test
    void getAllStudents() {
        ResponseEntity<?> response = raController.getAllStudents();
        ResponseDTO resDTO = (ResponseDTO) response.getBody();
        assertEquals(200, response.getStatusCodeValue());
        assert resDTO != null;
        assertEquals(studentDTOList, (List<StudentDTO>) resDTO.getResult());
    }

    @Test
    void searchStudent() {
        ResponseEntity<?> response = raController.searchStudent("al");
        ResponseDTO resDTO = (ResponseDTO) response.getBody();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(studentDTOList, (List<StudentDTO>) resDTO.getResult());
    }
}