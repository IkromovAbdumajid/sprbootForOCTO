package com.company.service;

import com.company.entity.CardEntity;
import com.company.entity.ProfileEntity;
import com.company.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.util.Optional;

@Service
@Transactional
public class CardService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private ProfileService profileService;

    public void create(String number, String excDate, Integer profileId) {
        // ProfileEntity profile = profileService.get(profileId);

        CardEntity cardEntity = new CardEntity();
        cardEntity.setNumber(number);
        cardEntity.setExcDate(excDate);
        cardEntity.setProfileId(profileId);
        //cardEntity.setProfile(profile);
        cardEntity.setBalance(0l);
        cardRepository.save(cardEntity);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void increaseBalance(String number, Long balance) {
        test();
        Optional<CardEntity> optional = cardRepository.findByNumber(number);
        if (optional.isPresent()) {
            CardEntity entity = optional.get();
            entity.setBalance(entity.getBalance() + balance);
            cardRepository.save(entity);
            System.out.println(entity);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update_balance(String number, Long balance) {
        cardRepository.updateBalance(number, balance);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void test() {
        // ....
    }


    public void get() {
        cardRepository.findByNumber("99121212121212").orElseThrow(() -> new RuntimeException("Car nor found"));

    }

    public CardEntity get(String number) {
        return cardRepository.findByNumber(number).orElseThrow(() -> new RuntimeException("Car nor found"));
    }
}

