package com.aritha.consulting.unit.testing.dto;

import lombok.*;

/**
 * ? @projectName unit-testing
 * ? @author Rohit M Lakshmikanth
 * ? @createdOn  November 02,2022 at 08:52 PM
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorDTO {
    private Integer code;
    private String name;
    private String result;

}
