package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.dto.SkinFormDto;
import com.example.BeautyLounge.dto.SkinOverviewDto;
import com.example.BeautyLounge.mapper.SkinMapper;
import com.example.BeautyLounge.model.Skin;
import com.example.BeautyLounge.service.SkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SkinController {

    @Autowired
    private SkinService skinService;
    @Autowired
    private SkinMapper skinMapper;


    @GetMapping(value = "/skinOverview")
    public String getSkinOverview(Model model) {

        List<SkinOverviewDto> skinList = skinService.getAllSkin();
        model.addAttribute("skinList", skinList);

        return "skinOverview";
    }
    @GetMapping(value = "/skinForm")
    public String getSkinForm(Model model) {
        model.addAttribute("skin", new SkinFormDto());
        return "skinForm";
    }
    @PostMapping("/submitSkin")
    public String submitSkin(@ModelAttribute("skin") SkinFormDto skin, Model model) {
        Skin skinEntity = skinMapper.mapToSkinEntity(skin);
        skinService.saveSkin(skinEntity);
        return "redirect:/skinOverview";
    }
    @GetMapping(value = "/deleteSkin/{id}")
    public String deleteSkin(@PathVariable("id") Integer id) {
        skinService.deleteSkin(id);
        return "redirect:/skinOverview";
    }

    @GetMapping(value = "/editSkin/{id}")
    public String getEditSkinForm(@PathVariable("id") Integer id, Model model) {
        Skin skin = skinService.getSkinById(id);
        if (skin != null) {
            model.addAttribute("skin", skin);
            return "editSkinForm";
        }
        return "redirect:/skinOverview";
    }

    @PostMapping("/updateSkin/{id}")
    public String updateSkin(@PathVariable("id") Integer id, @ModelAttribute("skinFormDto") SkinFormDto updateSkin) {
        Skin existingSkin = skinService.getSkinById(id);
        if (existingSkin != null) {
            Skin updatedSkin = skinMapper.mapToSkin(updateSkin);
            existingSkin.setName(updatedSkin.getName());
            existingSkin.setQuantity(updatedSkin.getQuantity());
            existingSkin.setTexture(updatedSkin.getTexture());
            existingSkin.setPrice(updatedSkin.getPrice());
            skinService.saveSkin(existingSkin);
        }
        return "redirect:/skinOverview";
    }

    @GetMapping(value="/homeForSkin")
    public String goHome(){
        return "redirect:/beautyLoungeProductsForm";
    }

}
