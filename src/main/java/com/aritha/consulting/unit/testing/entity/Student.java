package com.aritha.consulting.unit.testing.entity;

import lombok.*;

import javax.persistence.*;

/**
 * ? @projectName unit-testing
 * ? @author Rohit M Lakshmikanth
 * ? @createdOn  November 02,2022 at 08:27 PM
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "class")
    private String className;
    @Column(name = "mark")
    private Long mark;
    @Column(name = "gender")
    private String gender;
}
