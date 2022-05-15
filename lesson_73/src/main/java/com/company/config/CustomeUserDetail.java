package com.company.config;

import com.company.entity.ProfileEntity;
import com.company.entity.enums.ProfileStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomeUserDetail implements UserDetails {
    private ProfileEntity profileEntity;

    public ProfileEntity getProfileEntity() {
        return profileEntity;
    }

    public void setProfileEntity(ProfileEntity profileEntity) {
        this.profileEntity = profileEntity;
    }

    public CustomeUserDetail(ProfileEntity profileEntity) {
        this.profileEntity = profileEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(profileEntity.getRole()));
    }

    @Override
    public String getPassword() {

        return profileEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return profileEntity.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        if (profileEntity.getStatus().equals(ProfileStatus.ACTIVE)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
