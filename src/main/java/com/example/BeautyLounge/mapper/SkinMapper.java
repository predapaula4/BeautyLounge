package com.example.BeautyLounge.mapper;

import com.example.BeautyLounge.dto.SkinFormDto;
import com.example.BeautyLounge.dto.SkinOverviewDto;
import com.example.BeautyLounge.model.Skin;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class SkinMapper {
    public List<SkinOverviewDto> getSkinDtoList(List<Skin> skinList){
        return skinList.stream()
                .map(skin->mapToSkinDto(skin))
                .collect(Collectors.toList());
    }

    private SkinOverviewDto mapToSkinDto(Skin skin) {
        return SkinOverviewDto.builder()
                .id(skin.getId())
                .name(skin.getName())
                .quantity(skin.getQuantity())
                .texture(skin.getTexture())
                .price(skin.getPrice())
                .category(skin.getCategory())
                .build();
    }
    public Skin mapToSkin(SkinFormDto skinFormDto)
    {
        Skin skin = Skin.builder()
                .id(skinFormDto.getId())
                .name(skinFormDto.getName())
                .quantity(skinFormDto.getQuantity())
                .texture(skinFormDto.getTexture())
                .price(skinFormDto.getPrice())
                .category(skinFormDto.getCategory())
                .build();
        return skin;
    }

    public Skin mapToSkinEntity(SkinFormDto skinFormDto) {
        return Skin.builder()
                .name(skinFormDto.getName())
                .category(skinFormDto.getCategory())
                .quantity(skinFormDto.getQuantity())
                .texture(skinFormDto.getTexture())
                .price(skinFormDto.getPrice())
                .build();
    }
}
