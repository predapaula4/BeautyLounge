package com.example.BeautyLounge.service;

import com.example.BeautyLounge.dto.EyeOverviewDto;
import com.example.BeautyLounge.mapper.EyeMapper;
import com.example.BeautyLounge.model.Eye;
import com.example.BeautyLounge.repository.EyeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EyeService {
    @Autowired
    EyeRepository eyeRepository;
    @Autowired
    EyeMapper eyeMapper;


    public List<EyeOverviewDto> getAllEye(){
        List<Eye> eyeList = eyeRepository.findAll();
        return eyeMapper.getEyeDtoList(eyeList);
    }

    public void saveEye(Eye eye) {
        eyeRepository.save(eye);
    }
    public void deleteEye(int eyeId) {
        Eye existingEye = eyeRepository.findById(eyeId).orElse(null);
        if (existingEye != null) {
            eyeRepository.delete(existingEye);
        }
    }
    public Eye getEyeById(int eyeId) {
        Optional<Eye> optionalEye = eyeRepository.findById(eyeId);
        return optionalEye.orElse(null);
    }
}
