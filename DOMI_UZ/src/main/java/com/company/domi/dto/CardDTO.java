package com.company.domi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDTO {

    private Integer id;
    private LocalDateTime createdAt;
    private String number;
    private Long balance;
    private String expDate;
    private Long profileId;

}
