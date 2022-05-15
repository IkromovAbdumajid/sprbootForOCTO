package com.company.dto;

import com.company.entity.enums.ProfileStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {

    private Long id;
    private LocalDateTime createdAt;

    private String name;

    private String surname;

    private String phone;

    private String login;

    private String role;

    private String password;

    private ProfileStatus status;

}
