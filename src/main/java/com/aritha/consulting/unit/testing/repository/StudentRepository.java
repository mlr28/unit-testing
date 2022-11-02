package com.aritha.consulting.unit.testing.repository;

import com.aritha.consulting.unit.testing.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ? @projectName unit-testing
 * ? @author Rohit M Lakshmikanth
 * ? @createdOn  November 02,2022 at 08:34 PM
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT student FROM Student student WHERE LOWER(student.name) LIKE LOWER(concat(?1, '%'))")
    List<Student> searchStudent(String search);
}
