package com.company.domi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "message")
@Setter
@Getter
@NoArgsConstructor
public class MessageEntity extends BaseEntity {
    @Column(name = "email")
    private String email;
    @Column(name = "subject")
    private String subject;
    
    @Column(name = "used")
    private Boolean used = false;
    @Column(name = "used_date")
    private LocalDateTime usedDate;

}
