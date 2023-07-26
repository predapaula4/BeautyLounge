package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.dto.OchiFormDto;
import com.example.BeautyLounge.dto.OchiOverviewDto;
import com.example.BeautyLounge.mapper.OchiMapper;
import com.example.BeautyLounge.model.Ochi;
import com.example.BeautyLounge.service.OchiService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OchiController {
    @Autowired
    private OchiService ochiService;

    @Autowired
    private OchiMapper ochiMapper;

    @GetMapping("/ochi")
    public String getOchi(Model model)
    {
        String text = "These are our products for your eyes: ";
        model.addAttribute("message", text);

        List<OchiOverviewDto> ochiList=ochiService.getAllOchi();
        model.addAttribute("ochiList", ochiList);
        return  "ochi";
    }

    @GetMapping(value="/ochiOverview")
    public String getOchiOverview(Model model)
    {
        List<OchiOverviewDto> ochiList= ochiService.getAllOchi();
        model.addAttribute("ochiList", ochiList);
        return "ochiOverview";
    }

    @PostMapping("/submitOchi")
    public String submitOchi(@ModelAttribute("ochi") OchiFormDto ochiFormDto, Model model) {
        Ochi ochiEntity = ochiMapper.mapToOchiEntity(ochiFormDto);
        ochiService.saveOchi(ochiEntity);
        return "redirect:/ochiOverview";
    }
    @GetMapping(value = "/ochiForm")
    public String getOchiForm(Model model)
    {
        model.addAttribute("ochi", new Ochi());
        return "ochiForm";
    }

    @GetMapping(value = "/deleteOchi/{id}")
    public String deleteOchi(@PathVariable("id") Integer id) {
        ochiService.deleteOchi(id);
        return "redirect:/ochiOverview";
    }

    @GetMapping(value = "/editOchi/{id}")
    public String getEditOchiForm(@PathVariable("id") Integer id, Model model) {
        Ochi ochi = ochiService.getOchiById(id);
        if (ochi != null) {
            model.addAttribute("ochi", ochi);
            return "editOchiForm";
        }
        return "redirect:/ochiOverview";
    }
    @PostMapping("/updateOchi/{id}")
    public String updateOchi(@PathVariable("id") Integer id, @ModelAttribute("ochiFormDto") OchiFormDto updateOchi) {
        Ochi existingOchi = ochiService.getOchiById(id);
        if (existingOchi != null) {
            Ochi updatedOchi = ochiMapper.mapToOchi(updateOchi);
            existingOchi.setName(updatedOchi.getName());
            existingOchi.setQuantity(updatedOchi.getQuantity());
            existingOchi.setTexture(updatedOchi.getTexture());
            existingOchi.setPrice(updatedOchi.getPrice());
            ochiService.saveOchi(existingOchi);
        }
        return "redirect:/ochiOverview";
    }

    @GetMapping(value="/homeForOchi")
    public String goHome() {return "redirect:/beautyLoungeProductsForm";}
}
