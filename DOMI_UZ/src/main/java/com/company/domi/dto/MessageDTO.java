package com.company.domi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDTO {
    private Integer id;
    private String subject;
    private String email;
    private String text;
    private LocalDateTime usedDate;
    private String content;

    private Boolean used = false;
    private LocalDateTime date = LocalDateTime.now();

    public MessageDTO(String email, String subject, String text) {
        this.email = email;
        this.subject = subject;
        this.text = text;
    }
}
