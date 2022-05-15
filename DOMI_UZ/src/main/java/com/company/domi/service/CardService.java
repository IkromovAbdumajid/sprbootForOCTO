package com.company.domi.service;


import com.company.domi.dto.CardDTO;
import com.company.domi.entity.CardEntity;
import com.company.domi.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public CardEntity create(CardEntity entity) {
        cardRepository.save(entity);
        return entity;
    }

    public CardDTO create(CardDTO dto) {
        CardEntity entity = new CardEntity();
        String expDate = null;
        Long balance = null;
        try {
            expDate = dto.getExpDate();

        } catch (RuntimeException e) {
            log.error("Expected Date format expDate{} , error{}", expDate, e.getMessage());
        }
        try {
            balance = dto.getBalance() == null ? 0L : dto.getBalance();
        } catch (RuntimeException e) {
            log.error("Balance yetmaydi error{}", e.getMessage());
        }
        entity.setNumber(dto.getNumber());
        entity.setExpDate(expDate);
        entity.setBalance(balance);
        entity.setProfileId(dto.getProfileId());

        cardRepository.save(entity);

        dto.setId(entity.getId());
        dto.setCreatedAt(entity.getCreatedDate());
        return dto;
    }

    public Page<CardDTO> getAll(Pageable pageable) {
        return cardRepository.findAll(pageable)
                .map(this::toDto);
    }

    public CardEntity get(Long id) {
        if (id == null) {
            log.warn("Card Id is null cardId{}", id);
            return null;
        }

        return cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card Not Found"));
    }

    public CardEntity get(String number) {
        if (number == null) {
            log.warn("Card number is null cardNumber{}", number);
            return null;
        }

        return cardRepository.findByNumber(number)
                .orElseThrow(() -> new RuntimeException("Card Not Found"));
    }

    public CardDTO getById(Long id) {
        return toDto(get(id));
    }

    public List<CardEntity> getByProfileId(Long id) {
        if (id == null) {
            log.warn("Profile Id is null profileId{}", id);
            return null;
        }

        return cardRepository.findByProfileId(id);
    }

    public String deleteById(Long id) {
        try {
            cardRepository.deleteById(id);
        } catch (RuntimeException e) {
            log.warn("Wrong in deleted id id{}", id);
        }
        return "Successfully Deleted!!!";
    }

    public CardDTO getByNumber(String number) {
        try {
            return toDto(get(number));
        } catch (RuntimeException e) {
            log.error("Error in number number{}", number);
        }
        return null;
    }

    public CardEntity create(String number, String expDate, Long profileId) {
        if (expDate == null) {
            log.error("ExpDate is null expDate{}", expDate);
        }
        if (number == null) {
            log.error("Number is null number{}", number);
        }
        if (profileId == null) {
            log.error("ProfileId is null profileId{}", profileId);
        }
        CardEntity card = new CardEntity();
        card.setNumber(number);
        card.setExpDate(expDate);
        card.setBalance(0L);
        card.setProfileId(profileId);
        cardRepository.save(card);

        return card;
    }

    public Long getBalanceByNumber(String number) {
        try {
            return cardRepository.getBalanceByNumber(number);
        } catch (RuntimeException e) {
            log.error("Error in getBalance");
        }
        return null;
    }

    @Transactional
    public void updateBalance(String number, Long amount) {
        if (number == null) {
            log.error("Number is null number{}", number);
            return;
        }
        if (amount == null) {
            log.error("Amount is null amount{}", amount);
            return;
        }
        cardRepository.updateBalance(number, amount);
    }

    private CardDTO toDto(CardEntity entity) {
        if (entity == null) {
            log.error("CardEntity is null entity{}", entity);
            return null;
        }
        CardDTO dto = new CardDTO();
        dto.setExpDate(entity.getExpDate());

        dto.setNumber(entity.getNumber());
        dto.setBalance(entity.getBalance());
        dto.setProfileId(entity.getProfileId());
        dto.setId(entity.getId());
        dto.setCreatedAt(entity.getCreatedDate());

        return dto;
    }
}
