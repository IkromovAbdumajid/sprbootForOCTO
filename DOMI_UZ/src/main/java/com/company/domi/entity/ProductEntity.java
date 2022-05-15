package com.company.domi.entity;

import com.company.domi.enums.ProductType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",unique = true)
    private String name;

    private Integer description;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Attachment image;

    @Column(name = "price")
    private Integer price;

    @Column
    private Integer count;

    @Column(name = "created_date")
    private LocalDateTime createdDate=LocalDateTime.now();

    @Column(name = "exp_date")
    private LocalDateTime expDate;

    @Column(name = "Type")
    @Enumerated(value = EnumType.STRING)
    private ProductType productType;

    @Column
    private Integer creditPrice;

    private String creator;

    private String typeOfProduct;

    private String kamer;

    private String operSystem;
}
