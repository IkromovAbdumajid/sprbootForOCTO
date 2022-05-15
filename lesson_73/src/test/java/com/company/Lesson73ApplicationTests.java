package com.company;

import com.company.dto.ProfileDTO;
import com.company.entity.enums.ProfileStatus;
import com.company.service.AuthService;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Lesson73ApplicationTests {
    @Autowired
    private AuthService authService;

    @Test
    void contextLoads() {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setLogin("alish");
        profileDTO.setPassword("123alish");
        profileDTO.setSurname("Aliev");
        profileDTO.setName("Ali");
        profileDTO.setPhone("9999999");
        profileDTO.setRole("USER_ROLE");
        authService.registration(profileDTO);
    }

}