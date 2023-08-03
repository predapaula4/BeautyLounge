package com.example.BeautyLounge.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class LipsFormDto {
    private int id;
    private int brandId;
    private String name;
    private String category;
    private int quantity;
    private String texture;
    private int price;
}
