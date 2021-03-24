package com.example.securityService.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Animal {
    private String name;
//    @NotBlank
    private Integer age;
}
