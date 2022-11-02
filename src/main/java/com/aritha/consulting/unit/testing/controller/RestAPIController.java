package com.aritha.consulting.unit.testing.controller;

import com.aritha.consulting.unit.testing.dto.*;
import com.aritha.consulting.unit.testing.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ? @projectName unit-testing
 * ? @author Rohit M Lakshmikanth
 * ? @createdOn  November 02,2022 at 08:16 PM
 */
@RestController
@RequestMapping("/api/v1")
public class RestAPIController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<Object> getAllStudents() {
        try {
            List<StudentDTO> studentList = studentService.getAllStudent();
            if (studentList == null || studentList.isEmpty())
                return new ResponseEntity<>(new ErrorDTO(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.toString(), "No data found"), HttpStatus.NO_CONTENT);
            else return new ResponseEntity<>(new ResponseDTO(studentList, studentList.size()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/students/search")
    public ResponseEntity<Object> getAllClass(@RequestParam("search") String search) {
        try {
            List<StudentDTO> studentDTOList = studentService.searchStudent(search);
            if (studentDTOList == null || studentDTOList.isEmpty())
                return new ResponseEntity<>(new ErrorDTO(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.toString(), "No data found"), HttpStatus.NO_CONTENT);
            else return new ResponseEntity<>(new ResponseDTO(studentDTOList, studentDTOList.size()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@GetMapping("/subjects")
    public ResponseEntity<Object> getAllSubjects() {
        try {
            List<StudentDTO> studentDTOList = studentService.getAllStudent();
            if (studentDTOList == null || studentDTOList.isEmpty())
                return new ResponseEntity<>(new ErrorDTO(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.toString(), "No data found"), HttpStatus.NO_CONTENT);
            else return new ResponseEntity<>(new ResponseDTO(studentDTOList, studentDTOList.size()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
}
