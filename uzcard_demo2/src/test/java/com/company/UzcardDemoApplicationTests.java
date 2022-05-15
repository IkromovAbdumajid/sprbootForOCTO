package com.company;

import com.company.entity.ProfileEntity;
import com.company.service.CardService;
import com.company.service.ProfileService;
import com.company.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class UzcardDemoApplicationTests {
    @Autowired
    private CardService cardService;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private TransactionService transactionService;

    @Test
    void createProfile() {
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setName("Vali");
        profileEntity.setSurname("Valiyev");
        profileEntity.setMiddleName("Alihonovich");
        profileEntity.setBirthDate(LocalDate.of(2002, 1, 2));
        profileService.create(profileEntity);
    }


    @Test
    void createCard() {
//        cardService.create("1211","12/02",1);
//        cardService.create("1213","12/02",1);
//        cardService.create("1214","12/02",2);
    }

    @Test
    void updateCard() {
        cardService.increaseBalance("1213", 1000_00L);
    }

    @Test
    void makeTransaction() {
        transactionService.makeTransaction("1213", "1214", 500_00L);
    }

}
