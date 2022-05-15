package com.company.domi.dto.product;

import com.company.domi.enums.ProductType;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;


@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private Integer descriptionId;
    private MultipartFile image;
    private Integer creditPrice;
    private String typeOfProduct;
    private String creator;
    private String kamer;
    private Integer price;
    private Integer count;

    private LocalDateTime exp_date;

    private ProductType productType;
}
