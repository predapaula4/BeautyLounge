package com.example.BeautyLounge.mapper;

import com.example.BeautyLounge.dto.LipsFormDto;
import com.example.BeautyLounge.dto.LipsOverviewDto;
import com.example.BeautyLounge.model.Lips;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LipsMapper {
    public List<LipsOverviewDto> getLipsDtoList(List<Lips> lipsList){
        return lipsList.stream()
                .map(lips->mapToLipsDto(lips))
                .collect(Collectors.toList());
    }
    private LipsOverviewDto mapToLipsDto(Lips lips) {
        return LipsOverviewDto.builder()
                .id(lips.getId())
                .name(lips.getName())
                .quantity(lips.getQuantity())
                .texture(lips.getTexture())
                .price(lips.getPrice())
                .category(lips.getCategory())
                .build();
    }
    public Lips mapToLips(LipsFormDto lipsFormDto)
    {
        Lips lips=Lips.builder()
                .id(lipsFormDto.getId())
                .name(lipsFormDto.getName())
                .quantity(lipsFormDto.getQuantity())
                .texture(lipsFormDto.getTexture())
                .price(lipsFormDto.getPrice())
                .category(lipsFormDto.getCategory())
                .build();
        return lips;
    }

    public Lips mapToLipsEntity(LipsFormDto lipsFormDto) {
        return Lips.builder()
                .name(lipsFormDto.getName())
                .category(lipsFormDto.getCategory())
                .quantity(lipsFormDto.getQuantity())
                .texture(lipsFormDto.getTexture())
                .price(lipsFormDto.getPrice())
                .build();
    }
}
