package com.example.BeautyLounge.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class EyeFormDto {
    private int id;
    private int brand_id;
    private String name;
    private String category;
    private int quantity;
    private String texture;
    private int price;
}
