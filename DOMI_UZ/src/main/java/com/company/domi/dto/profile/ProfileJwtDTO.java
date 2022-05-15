package com.company.domi.dto.profile;

import com.company.domi.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data

@NoArgsConstructor
public class ProfileJwtDTO {
    private Integer id;
    private Role role;

    public ProfileJwtDTO(Integer id, Role role) {
        this.id = id;
        this.role = role;
    }
}
