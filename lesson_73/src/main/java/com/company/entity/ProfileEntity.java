package com.company.entity;

import com.company.entity.enums.ProfileStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity(name = "profile")
@Setter
@Getter
@NoArgsConstructor
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt = LocalDateTime.now();
    private String name;

    private String surname;

    private String phone;

    private String login;
    private String role;

    private String password;

    @Enumerated(EnumType.STRING)
    private ProfileStatus status;

}
