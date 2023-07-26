package com.example.BeautyLounge.mapper;

import com.example.BeautyLounge.dto.OchiFormDto;
import com.example.BeautyLounge.dto.OchiOverviewDto;
import com.example.BeautyLounge.model.Ochi;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OchiMapper {
    public List<OchiOverviewDto> getOchiDtoList(List<Ochi> ochiList){
        return ochiList.stream()
                .map(ochi->mapToOchiDto(ochi))
                .collect(Collectors.toList());
    }
    private OchiOverviewDto mapToOchiDto(Ochi ochi) {
        return OchiOverviewDto.builder()
                .id(ochi.getId())
                .name(ochi.getName())
                .quantity(ochi.getQuantity())
                .texture(ochi.getTexture())
                .price(ochi.getPrice())
                .category(ochi.getCategory())
                .build();
    }
    public Ochi mapToOchi(OchiFormDto ochiFormDto)
    {
        Ochi ochi=Ochi.builder()
                .id(ochiFormDto.getId())
                .name(ochiFormDto.getName())
                .quantity(ochiFormDto.getQuantity())
                .texture(ochiFormDto.getTexture())
                .price(ochiFormDto.getPrice())
                .category(ochiFormDto.getCategory())
                .build();
        return ochi;
    }

    public Ochi mapToOchiEntity(OchiFormDto ochiFormDto) {
        return Ochi.builder()
                .name(ochiFormDto.getName())
                .category(ochiFormDto.getCategory())
                .quantity(ochiFormDto.getQuantity())
                .texture(ochiFormDto.getTexture())
                .price(ochiFormDto.getPrice())
                .build();
    }
}
