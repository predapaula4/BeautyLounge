package com.example.BeautyLounge.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="beauty_lounge")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BeautyLounge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final String name = "Beauty Lounge";
    private final String hqAddress = "525 Market Street First Market Tower 32nd Floor, San Francisco, California, United States";
    private final int yearOfEstablishment = 1990;

}
