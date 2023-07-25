package com.example.BeautyLounge.mapper;

import com.example.BeautyLounge.dto.TenFormDto;
import com.example.BeautyLounge.dto.TenOverviewDto;
import com.example.BeautyLounge.model.Ten;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class TenMapper {
    public List<TenOverviewDto> getTenDtoList(List<Ten> tenList){
        return tenList.stream()
                .map(ten->mapToTenDto(ten))
                .collect(Collectors.toList());
    }

    private TenOverviewDto mapToTenDto(Ten ten) {
        return TenOverviewDto.builder()
                .id(ten.getId())
                .name(ten.getName())
                .quantity(ten.getQuantity())
                .texture(ten.getTexture())
                .price(ten.getPrice())
                .category(ten.getCategory())
                .build();
    }
    public Ten mapToTen(TenFormDto tenFormDto)
    {
        Ten ten=Ten.builder()
                .id(tenFormDto.getId())
                .name(tenFormDto.getName())
                .quantity(tenFormDto.getQuantity())
                .texture(tenFormDto.getTexture())
                .price(tenFormDto.getPrice())
                .category(tenFormDto.getCategory())
                .build();
        return ten;
    }

    public Ten mapToTenEntity(TenFormDto tenFormDto) {
        return Ten.builder()
                .name(tenFormDto.getName())
                .category(tenFormDto.getCategory())
                .quantity(tenFormDto.getQuantity())
                .texture(tenFormDto.getTexture())
                .price(tenFormDto.getPrice())
                .build();
    }
}
