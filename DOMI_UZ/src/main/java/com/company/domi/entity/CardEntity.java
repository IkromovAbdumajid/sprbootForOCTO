package com.company.domi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "card")
@Setter
@Getter
@NoArgsConstructor
public class CardEntity extends BaseEntity {

    @Column(nullable = false, unique = true, length = 16)
    private String number;

    private Long balance;

    private String expDate;

    @Column(name = "profile_id", nullable = false)
    private Long profileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", insertable = false, updatable = false)
    private ProfileEntity profile;

}
