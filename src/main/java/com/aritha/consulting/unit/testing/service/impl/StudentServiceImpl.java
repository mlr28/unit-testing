package com.aritha.consulting.unit.testing.service.impl;

import com.aritha.consulting.unit.testing.dto.StudentDTO;
import com.aritha.consulting.unit.testing.entity.Student;
import com.aritha.consulting.unit.testing.repository.StudentRepository;
import com.aritha.consulting.unit.testing.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ? @projectName unit-testing
 * ? @author Rohit M Lakshmikanth
 * ? @createdOn  November 02,2022 at 08:33 PM
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getAllStudent() {
        try {
            List<Student> studentList = studentRepository.findAll();
            List<StudentDTO> studentDTOList = new ArrayList<>();
            StudentDTO studentDTO = null;

            for (Student student : studentList) {
                studentDTO = new StudentDTO();
                studentDTO.setId(student.getId());
                studentDTO.setName(student.getName());
                studentDTO.setClassName(student.getClassName());
                studentDTO.setMark(student.getMark());
                studentDTO.setGender(student.getGender());
                studentDTOList.add(studentDTO);
            }
            return studentDTOList;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<StudentDTO> searchStudent(String search) {
        try {
            List<Student> studentList = studentRepository.searchStudent(search);
            List<StudentDTO> studentDTOList = new ArrayList<>();
            StudentDTO studentDTO = null;

            for (Student student : studentList) {
                studentDTO = new StudentDTO();
                studentDTO.setId(student.getId());
                studentDTO.setName(student.getName());
                studentDTO.setClassName(student.getClassName());
                studentDTO.setMark(student.getMark());
                studentDTO.setGender(student.getGender());
                studentDTOList.add(studentDTO);
            }
            return studentDTOList;
        } catch (Exception e) {
            return null;
        }
    }
}
