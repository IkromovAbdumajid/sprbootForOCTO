package com.company.config;

import com.company.entity.ProfileEntity;
import com.company.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDatailService implements UserDetailsService {
    private final ProfileRepository profileRepository;

    public CustomUserDatailService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Optional<ProfileEntity> optional =
                profileRepository.findByLogin(username);

        if (optional.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        ProfileEntity profileEntity = optional.get();
        System.out.println(profileEntity);
        return new CustomeUserDetail(profileEntity);
    }
}
