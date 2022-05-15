package com.company.domi.controller;


import com.company.domi.dto.CardDTO;
import com.company.domi.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping("/create")
    public ResponseEntity<CardDTO> create(@RequestBody CardDTO dto) {
            return ResponseEntity.ok(cardService.create(dto));
    }

    @GetMapping
    public ResponseEntity<Page<CardDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(cardService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.getById(id));
    }

    @GetMapping("/number/{number}")
    public ResponseEntity<CardDTO> getById(@PathVariable String number) {
        return ResponseEntity.ok(cardService.getByNumber(number));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.deleteById(id));
    }

}
