package com.company.domi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "likes")
@Getter
@Setter
@NoArgsConstructor
public class LikeEntity extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

    @ManyToOne
    @JoinColumn(name = "product")
    private ProductEntity productEntity;

}
