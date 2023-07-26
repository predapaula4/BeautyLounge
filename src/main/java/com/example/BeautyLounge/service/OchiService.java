package com.example.BeautyLounge.service;

import com.example.BeautyLounge.dto.OchiOverviewDto;
import com.example.BeautyLounge.dto.TenOverviewDto;
import com.example.BeautyLounge.mapper.OchiMapper;
import com.example.BeautyLounge.model.Ochi;
import com.example.BeautyLounge.model.Ten;
import com.example.BeautyLounge.repository.OchiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OchiService {
    @Autowired
    OchiRepository ochiRepository;
    @Autowired
    OchiMapper ochiMapper;


    public List<OchiOverviewDto> getAllOchi(){
        List<Ochi> ochiList=ochiRepository.findAll();
        return ochiMapper.getOchiDtoList(ochiList);
    }

    public void saveOchi(Ochi ochi) {
        ochiRepository.save(ochi);
    }
    public void deleteOchi(int ochiId) {
        Ochi existingOchi = ochiRepository.findById(ochiId).orElse(null);
        if (existingOchi != null) {
            ochiRepository.delete(existingOchi);
        }
    }
    public Ochi getOchiById(int ochiId) {
        Optional<Ochi> optionalOchi = ochiRepository.findById(ochiId);
        return optionalOchi.orElse(null);
    }
}
