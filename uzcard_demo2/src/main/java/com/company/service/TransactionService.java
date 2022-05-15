package com.company.service;

import com.company.entity.CardEntity;
import com.company.entity.TransactionEntity;
import com.company.repository.CardRepository;
import com.company.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    @Lazy
    private CardService cardService;
    @Autowired
    private CardRepository cardRepository;

    public Boolean makeTransaction(String fromCardNumber, String toCardNUmber, Long amount) {
        CardEntity fromCard = cardService.get(fromCardNumber); // 1213
        CardEntity toCard = cardService.get(toCardNUmber);
        return doTransaction(fromCard, toCard, amount);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    private Boolean doTransaction(CardEntity fromCard, CardEntity toCard, Long amount) {
        Long balance = cardRepository.getCardBalance(fromCard.getNumber());
        if (balance == null || balance < amount) {
            throw new RuntimeException("Not enough balance.");
        }

        cardService.update_balance(fromCard.getNumber(), amount * -1);
        cardService.update_balance(toCard.getNumber(), amount);

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setFromCard(fromCard);
        transactionEntity.setToCard(toCard);
        transactionEntity.setAmount(amount);
        transactionEntity.setCreatedDate(LocalDateTime.now());
        transactionRepository.save(transactionEntity);
        return null;
    }

    @Transactional(propagation = Propagation.NEVER)
    public boolean get() {
        transactionRepository.findAll();
        return true;
    }
}
