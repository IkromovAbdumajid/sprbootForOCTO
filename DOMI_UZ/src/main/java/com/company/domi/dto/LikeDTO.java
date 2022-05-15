package com.company.domi.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LikeDTO {
    private Integer id;

    private Integer profileId;
    private Integer productId;

    private LocalDateTime createdDate=LocalDateTime.now();
}
