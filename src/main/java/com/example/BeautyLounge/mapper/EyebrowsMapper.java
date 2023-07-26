package com.example.BeautyLounge.mapper;

import com.example.BeautyLounge.dto.EyebrowsFormDto;
import com.example.BeautyLounge.dto.EyebrowsOverviewDto;
import com.example.BeautyLounge.model.Eyebrows;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EyebrowsMapper {
    public List<EyebrowsOverviewDto> getEyebrowsDtoList(List<Eyebrows> eyebrowsList){
        return eyebrowsList.stream()
                .map(eyebrows->mapToEyebrowsDto(eyebrows))
                .collect(Collectors.toList());
    }
    private EyebrowsOverviewDto mapToEyebrowsDto(Eyebrows eyebrows) {
        return EyebrowsOverviewDto.builder()
                .id(eyebrows.getId())
                .name(eyebrows.getName())
                .quantity(eyebrows.getQuantity())
                .texture(eyebrows.getTexture())
                .price(eyebrows.getPrice())
                .category(eyebrows.getCategory())
                .build();
    }
    public Eyebrows mapToEyebrows(EyebrowsFormDto eyebrowsFormDto)
    {
        Eyebrows eyebrows=Eyebrows.builder()
                .id(eyebrowsFormDto.getId())
                .name(eyebrowsFormDto.getName())
                .quantity(eyebrowsFormDto.getQuantity())
                .texture(eyebrowsFormDto.getTexture())
                .price(eyebrowsFormDto.getPrice())
                .category(eyebrowsFormDto.getCategory())
                .build();
        return eyebrows;
    }

    public Eyebrows mapToEyebrowsEntity(EyebrowsFormDto eyebrowsFormDto) {
        return Eyebrows.builder()
                .name(eyebrowsFormDto.getName())
                .category(eyebrowsFormDto.getCategory())
                .quantity(eyebrowsFormDto.getQuantity())
                .texture(eyebrowsFormDto.getTexture())
                .price(eyebrowsFormDto.getPrice())
                .build();
    }
}
