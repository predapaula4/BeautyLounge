package com.example.BeautyLounge.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "brand")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Brand {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "brand_name")
    private String brand_name;

    @OneToMany(mappedBy = "brand")
    private List<Eyebrows> eyebrowsList;

    @OneToMany(mappedBy = "brand")
    private List<Lips> lipsList;

    @OneToMany(mappedBy = "brand")
    private List<Eye> eyeList;

    @OneToMany(mappedBy = "brand")
    private List<Skin> skinList;

    public String getBrandName() {
        return brand_name;
    }

    public int getBrandCode() {
        return id;
    }

}
