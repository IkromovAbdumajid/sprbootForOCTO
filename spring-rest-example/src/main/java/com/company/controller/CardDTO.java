package com.company.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class CardDTO {

    private Long id;
    private LocalDateTime createdAt;
    private String number;
    private Long balance;
    private String expDate;
    private Long profileId;

}
