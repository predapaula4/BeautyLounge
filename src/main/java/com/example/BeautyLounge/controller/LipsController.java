package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.dto.LipsFormDto;
import com.example.BeautyLounge.dto.LipsOverviewDto;
import com.example.BeautyLounge.dto.TenFormDto;
import com.example.BeautyLounge.mapper.LipsMapper;
import com.example.BeautyLounge.model.Lips;
import com.example.BeautyLounge.model.Ten;
import com.example.BeautyLounge.service.LipsService;
import org.springframework.ui.Model;
import com.example.BeautyLounge.mapper.TenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LipsController {
    @Autowired
    private LipsService lipsService;

    @Autowired
    private LipsMapper lipsMapper;

    @GetMapping("/lips")
    public String getLips(Model model)
    {
        String text = "These are our products for your lips: ";
        model.addAttribute("message", text);

        List<LipsOverviewDto> lipsList=lipsService.getAllLips();
        model.addAttribute("lipsList", lipsList);
        return  "lips";
    }

    @GetMapping(value="/lipsOverview")
    public String getLipsOverview(Model model)
    {
        List<LipsOverviewDto> lipsList= lipsService.getAllLips();
        model.addAttribute("lipsList", lipsList);
        return "lipsOverview";
    }

    @PostMapping("/submitLips")
    public String submitTen(@ModelAttribute("lips") LipsFormDto lipsFormDto, Model model) {
        Lips lipsEntity = lipsMapper.mapToLipsEntity(lipsFormDto);
        lipsService.saveLips(lipsEntity);
        return "redirect:/lipsOverview";
    }
    @GetMapping(value = "/lipsForm")
    public String getLipsForm(Model model)
    {
        model.addAttribute("lips", new Lips());
        return "lipsForm";
    }

    @GetMapping(value = "/deleteLips/{id}")
    public String deleteLips(@PathVariable("id") Integer id) {
        lipsService.deleteLips(id);
        return "redirect:/lipsOverview";
    }

    @GetMapping(value = "/editLips/{id}")
    public String getEditLipsForm(@PathVariable("id") Integer id, Model model) {
       Lips lips = lipsService.getLipsById(id);
        if (lips != null) {
            model.addAttribute("lips", lips);
            return "editLipsForm";
        }
        return "redirect:/lipsOverview";
    }
    @PostMapping("/updateLips/{id}")
    public String updateLips(@PathVariable("id") Integer id, @ModelAttribute("lipsFormDto") LipsFormDto updateLips) {
        Lips existingLips = lipsService.getLipsById(id);
        if (existingLips != null) {
            Lips updatedLips = lipsMapper.mapToLips(updateLips);
            existingLips.setName(updatedLips.getName());
            existingLips.setQuantity(updatedLips.getQuantity());
            existingLips.setTexture(updatedLips.getTexture());
            existingLips.setPrice(updatedLips.getPrice());
            lipsService.saveLips(existingLips);
        }
        return "redirect:/lipsOverview";
    }

    @GetMapping(value="/homeForLips")
    public String goHome() {return "redirect:/beautyLoungeProductsForm";}
}
