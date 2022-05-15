package com.company.controller;

import com.company.config.CustomeUserDetail;
import com.company.dto.ProfileDTO;
import com.company.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping
    public ResponseEntity<ProfileDTO> registration(@RequestBody ProfileDTO dto) {

        dto = profileService.create(dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/info")
    public String getuserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        CustomeUserDetail customeUserDetail = (CustomeUserDetail) authentication.getPrincipal();

        return customeUserDetail.getProfileEntity().toString();
    }

    @GetMapping("/info")
    public String getuserInfo2(Principal principal) {
        String username = principal.getName();
        CustomeUserDetail customeUserDetail = (CustomeUserDetail) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        return "dsdsds";
    }

    @GetMapping("/info")
    public String getuserInfo3(Authentication authentication) {
        CustomeUserDetail customeUserDetail = (CustomeUserDetail) authentication.getPrincipal();
        return "dsdsds";
    }

    @GetMapping("/info")
    public String getuserInfo4(@AuthenticationPrincipal final UserDetails userDetails) {
        return ((CustomeUserDetail) userDetails).getProfileEntity().toString();
    }

}
