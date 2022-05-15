package com.company.domi.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "description")

public class DescriptionEntity extends BaseEntity{
    @Column
    private String rangi;

    @Column
    private String Diagonal;

    @Column(name = "Аудио")
    private String Аудио;

    private String protsessor;

    @Column
    private Integer Вес;

    @Column
    private String Стандарт;

    @Column
    private String Аккумулятор;

    @Column
    private Boolean Фонарик;


}
