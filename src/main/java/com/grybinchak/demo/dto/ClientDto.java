package com.grybinchak.demo.dto;

import lombok.Data;

@Data
public class ClientDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}