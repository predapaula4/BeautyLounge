package com.example.BeautyLounge.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ten")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Ten  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brand brand;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "texture")
    private String texture;

    @Column(name = "price")
    private int price;

}