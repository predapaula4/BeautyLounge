package com.example.BeautyLounge.mapper;

import com.example.BeautyLounge.dto.EyeFormDto;
import com.example.BeautyLounge.dto.EyeOverviewDto;
import com.example.BeautyLounge.model.Brand;
import com.example.BeautyLounge.model.Eye;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EyeMapper {
    public List<EyeOverviewDto> getEyeDtoList(List<Eye> eyeList){
        return eyeList.stream()
                .map(eye->mapToEyeDto(eye))
                .collect(Collectors.toList());
    }
    private EyeOverviewDto mapToEyeDto(Eye eye) {
        return EyeOverviewDto.builder()
                .id(eye.getId())
                .brand_id(eye.getBrandCode())
                .brand_name(eye.getBrandName())
                .name(eye.getName())
                .quantity(eye.getQuantity())
                .texture(eye.getTexture())
                .price(eye.getPrice())
                .category(eye.getCategory())
                .build();
    }
    public Eye mapToEye(EyeFormDto eyeFormDto)
    {
        Eye eye = Eye.builder()
                .id(eyeFormDto.getId())
                .brand(Brand.builder().id(eyeFormDto.getBrandId()).build())
                .name(eyeFormDto.getName())
                .quantity(eyeFormDto.getQuantity())
                .texture(eyeFormDto.getTexture())
                .price(eyeFormDto.getPrice())
                .category(eyeFormDto.getCategory())
                .build();
        return eye;
    }

    public Eye mapToEyeEntity(EyeFormDto eyeFormDto) {
        return Eye.builder()
                .name(eyeFormDto.getName())
                .brand(Brand.builder().id(eyeFormDto.getBrandId()).build())
                .category(eyeFormDto.getCategory())
                .quantity(eyeFormDto.getQuantity())
                .texture(eyeFormDto.getTexture())
                .price(eyeFormDto.getPrice())
                .build();
    }

    public EyeFormDto mapToEyeFormDto(Eye eye)
    {
        EyeFormDto eyeFormDto=new EyeFormDto();
        eyeFormDto.setId(eye.getId());
        eyeFormDto.setName(eye.getName());
        eyeFormDto.setPrice(eye.getPrice());
        eyeFormDto.setQuantity(eye.getQuantity());
        eyeFormDto.setTexture(eye.getTexture());
        return eyeFormDto;
    }
}
