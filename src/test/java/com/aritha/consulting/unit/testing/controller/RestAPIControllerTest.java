package com.aritha.consulting.unit.testing.controller;

import com.aritha.consulting.unit.testing.dto.ErrorDTO;
import com.aritha.consulting.unit.testing.dto.ResponseDTO;
import com.aritha.consulting.unit.testing.dto.StudentDTO;
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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ? @projectName unit-testing
 * ? @author Rohit M Lakshmikanth
 * ? @createdOn  November 03,2022 at 12:34 AM
 */
@ExtendWith(MockitoExtension.class)
class RestAPIControllerTest {

    @InjectMocks
    RestAPIController restAPIController;
    @Mock
    StudentService studentService;
    List<StudentDTO> studentDTOList =null;

    @Mock
    ResponseDTO responseDTO;

    @Mock
    ErrorDTO errorDTO;

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
    }

    @AfterEach
    void tearDown() {
        studentDTOList =null;
    }

    @Test
    void getAllStudents() {
        Mockito.when(studentService.getAllStudent()).thenReturn(studentDTOList);
        List<StudentDTO> studentList = (List<StudentDTO>) ((ResponseDTO)restAPIController.getAllStudents().getBody()).getResult();
        assertNotNull(studentList);
        assertEquals(studentList.get(0).getId().getClass(),Long.class);
        assertNotEquals(studentList.get(1).getId(),"String value");

        Mockito.when(studentService.getAllStudent()).thenThrow(new JDBCException("Dummy Exception",new SQLException()));
        try {
            assertDoesNotThrow(() -> {
                System.out.println("Doesn't throw any exception");
            });
        }
        catch(Exception exception){
            assertThrows(Exception.class, () -> {
                System.out.println(exception.getMessage());
            });
        }
    }
}