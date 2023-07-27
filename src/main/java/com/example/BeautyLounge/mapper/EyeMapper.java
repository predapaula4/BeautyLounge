package com.example.BeautyLounge.mapper;

import com.example.BeautyLounge.dto.EyeFormDto;
import com.example.BeautyLounge.dto.EyeOverviewDto;
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
                .category(eyeFormDto.getCategory())
                .quantity(eyeFormDto.getQuantity())
                .texture(eyeFormDto.getTexture())
                .price(eyeFormDto.getPrice())
                .build();
    }
}
