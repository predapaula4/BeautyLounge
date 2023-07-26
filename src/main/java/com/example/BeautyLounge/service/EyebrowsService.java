package com.example.BeautyLounge.service;

import com.example.BeautyLounge.dto.EyebrowsOverviewDto;
import com.example.BeautyLounge.dto.TenOverviewDto;
import com.example.BeautyLounge.mapper.EyebrowsMapper;
import com.example.BeautyLounge.model.Eyebrows;
import com.example.BeautyLounge.model.Ten;
import com.example.BeautyLounge.repository.EyebrowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EyebrowsService {
    @Autowired
    EyebrowsRepository eyebrowsRepository;
    @Autowired
    EyebrowsMapper eyebrowsMapper;


    public List<EyebrowsOverviewDto> getAllEyebrows(){
        List<Eyebrows> eyebrowsList=eyebrowsRepository.findAll();
        return eyebrowsMapper.getEyebrowsDtoList(eyebrowsList);
    }

    public void saveEyebrows(Eyebrows eyebrows) {
        eyebrowsRepository.save(eyebrows);
    }
    public void deleteEyebrows(int eyebrowsId) {
        Eyebrows existingEyebrows = eyebrowsRepository.findById(eyebrowsId).orElse(null);
        if (existingEyebrows != null) {
            eyebrowsRepository.delete(existingEyebrows);
        }
    }
    public Eyebrows getEyebrowsById(int eyebrowsId) {
        Optional<Eyebrows> optionalEyebrows = eyebrowsRepository.findById(eyebrowsId);
        return optionalEyebrows.orElse(null);
    }
}
