package com.example.BeautyLounge.service;

import com.example.BeautyLounge.dto.TenFormDto;
import com.example.BeautyLounge.dto.TenOverviewDto;
import com.example.BeautyLounge.mapper.TenMapper;
import com.example.BeautyLounge.model.Ten;
import com.example.BeautyLounge.repository.TenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenService {
    @Autowired
    TenRepository tenRepository;
    @Autowired
    TenMapper tenMapper;

    public List<TenOverviewDto> getAllTen(){
        List<Ten> tenList=tenRepository.findAll();
        return tenMapper.getTenDtoList(tenList);
    }

    public void saveTen(Ten ten) {
        tenRepository.save(ten);
    }
    public void deleteTen(int tenId) {
        Ten existingTen = tenRepository.findById(tenId).orElse(null);
        if (existingTen != null) {
            tenRepository.delete(existingTen);
        }
    }
    public Ten getTenById(int tenId) {
        Optional<Ten> optionalTen = tenRepository.findById(tenId);
        return optionalTen.orElse(null);
    }
}
