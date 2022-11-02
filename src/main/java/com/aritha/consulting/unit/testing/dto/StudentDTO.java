package com.aritha.consulting.unit.testing.dto;

import lombok.*;

/**
 * ? @projectName unit-testing
 * ? @author Rohit M Lakshmikanth
 * ? @createdOn  November 02,2022 at 08:21 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentDTO {
    private Long id;
    private String name;
    private String className;
    private Long mark;
    private String gender;

}
