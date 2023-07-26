package com.example.BeautyLounge.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class OchiFormDto {
    private int id;
    private String name;
    private String category;
    private int quantity;
    private String texture;
    private int price;
}
