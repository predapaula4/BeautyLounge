package com.example.BeautyLounge.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="brand")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_brand;

    @Column(name = "brand_name")
    private String brand_name;

}
