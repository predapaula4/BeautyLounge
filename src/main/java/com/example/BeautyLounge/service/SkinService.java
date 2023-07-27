package com.example.BeautyLounge.service;

import com.example.BeautyLounge.dto.SkinOverviewDto;
import com.example.BeautyLounge.mapper.SkinMapper;
import com.example.BeautyLounge.model.Skin;
import com.example.BeautyLounge.repository.SkinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkinService {
    @Autowired
    SkinRepository skinRepository;
    @Autowired
    SkinMapper skinMapper;

    public List<SkinOverviewDto> getAllSkin(){
        List<Skin> skinList = skinRepository.findAll();
        return skinMapper.getSkinDtoList(skinList);
    }

    public void saveSkin(Skin skin) {
        skinRepository.save(skin);
    }
    public void deleteSkin(int skinId) {
        Skin existingSkin = skinRepository.findById(skinId).orElse(null);
        if (existingSkin != null) {
            skinRepository.delete(existingSkin);
        }
    }
    public Skin getSkinById(int skinId) {
        Optional<Skin> optionalSkin = skinRepository.findById(skinId);
        return optionalSkin.orElse(null);
    }
}
