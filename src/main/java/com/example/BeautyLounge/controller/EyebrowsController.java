package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.dto.EyebrowsFormDto;
import com.example.BeautyLounge.dto.EyebrowsOverviewDto;
import com.example.BeautyLounge.mapper.EyebrowsMapper;
import com.example.BeautyLounge.model.Eyebrows;
import com.example.BeautyLounge.service.EyebrowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EyebrowsController {

    @Autowired
    private EyebrowsService eyebrowsService;

    @Autowired
    private EyebrowsMapper eyebrowsMapper;

    @GetMapping("/eyebrowsOverview")
    public String getEyebrowsOverview(Model model) {
        List<EyebrowsOverviewDto> eyebrowsList = eyebrowsService.getAllEyebrows();
        model.addAttribute("eyebrowsList", eyebrowsList);
        return "eyebrowsOverview";
    }

    @GetMapping("/eyebrowsForm")
    public String getEyebrowsForm(Model model) {
        model.addAttribute("eyebrows", new EyebrowsFormDto());
        return "eyebrowsForm";
    }

    @PostMapping("/submitEyebrows")
    public String submitEyebrows(@ModelAttribute("eyebrows") EyebrowsFormDto eyebrows, Model model) {
        Eyebrows eyebrowsEntity = eyebrowsMapper.mapToEyebrowsEntity(eyebrows);
        eyebrowsService.saveEyebrows(eyebrowsEntity);
        return "redirect:/eyebrowsOverview";
    }

    @GetMapping("/deleteEyebrows/{id}")
    public String deleteEyebrows(@PathVariable("id") Integer id) {
        eyebrowsService.deleteEyebrows(id);
        return "redirect:/eyebrowsOverview";
    }

    @GetMapping("/editEyebrows/{id}")
    public String getEditEyebrowsForm(@PathVariable("id") Integer id, Model model) {
        Eyebrows eyebrows = eyebrowsService.getEyebrowsById(id);
        if (eyebrows != null) {
            model.addAttribute("eyebrowsFormDto", eyebrowsMapper.mapToEyebrowsFormDto(eyebrows));
            return "editEyebrowsForm";
        }
        return "redirect:/eyebrowsOverview";
    }


    @PostMapping("/updateEyebrows/{id}")
    public String updateEyebrows(@PathVariable("id") Integer id, @ModelAttribute("eyebrowsFormDto") EyebrowsFormDto updateEyebrows) {
        Eyebrows existingEyebrows = eyebrowsService.getEyebrowsById(id);
        if (existingEyebrows != null) {
            Eyebrows updatedEyebrows = eyebrowsMapper.mapToEyebrowsEntity(updateEyebrows);
            existingEyebrows.setName(updatedEyebrows.getName());
            existingEyebrows.setQuantity(updatedEyebrows.getQuantity());
            existingEyebrows.setTexture(updatedEyebrows.getTexture());
            existingEyebrows.setPrice(updatedEyebrows.getPrice());
            eyebrowsService.saveEyebrows(existingEyebrows);
        }
        return "redirect:/eyebrowsOverview";
    }

    @GetMapping("/homeForEyebrows")
    public String goHome() {
        return "redirect:/beautyLoungeProductsForm";
    }
}
