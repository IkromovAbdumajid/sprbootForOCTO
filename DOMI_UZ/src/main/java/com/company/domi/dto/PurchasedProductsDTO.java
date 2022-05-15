package com.company.domi.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PurchasedProductsDTO {
    private Integer id;

    private String name;

    private Integer price;

    private MultipartFile image;

    private Integer count;

    private Integer overall;

    private String phone;

    private String location;

}
