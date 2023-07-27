package com.example.BeautyLounge.service;

import com.example.BeautyLounge.dto.LipsOverviewDto;
import com.example.BeautyLounge.mapper.LipsMapper;
import com.example.BeautyLounge.model.Lips;
import com.example.BeautyLounge.repository.LipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LipsService {
    @Autowired
    LipsRepository lipsRepository;
    @Autowired
    LipsMapper lipsMapper;


    public List<LipsOverviewDto> getAllLips(){
        List<Lips> lipsList=lipsRepository.findAll();
        return lipsMapper.getLipsDtoList(lipsList);
    }

    public void saveLips(Lips lips) {
        lipsRepository.save(lips);
    }
    public void deleteLips(int lipsId) {
        Lips existingLips = lipsRepository.findById(lipsId).orElse(null);
        if (existingLips != null) {
            lipsRepository.delete(existingLips);
        }
    }
    public Lips getLipsById(int lipsId) {
        Optional<Lips> optionalLips = lipsRepository.findById(lipsId);
        return optionalLips.orElse(null);
    }
}
