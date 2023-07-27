package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.dto.EyeFormDto;
import com.example.BeautyLounge.dto.EyeOverviewDto;
import com.example.BeautyLounge.mapper.EyeMapper;
import com.example.BeautyLounge.model.Eye;
import com.example.BeautyLounge.service.EyeService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EyeController {
    @Autowired
    private EyeService eyeService;

    @Autowired
    private EyeMapper eyeMapper;

    @GetMapping("/eye")
    public String getEye(Model model)
    {
        String text = "These are our products for your eyes: ";
        model.addAttribute("message", text);

        List<EyeOverviewDto> eyeList= eyeService.getAllEye();
        model.addAttribute("eyeList", eyeList);
        return  "eye";
    }

    @GetMapping(value="/eyeOverview")
    public String getEyeOverview(Model model)
    {
        List<EyeOverviewDto> eyeList= eyeService.getAllEye();
        model.addAttribute("eyeList", eyeList);
        return "eyeOverview";
    }

    @PostMapping("/submitEye")
    public String submitEye(@ModelAttribute("eye") EyeFormDto eyeFormDto, Model model) {
        Eye eyeEntity = eyeMapper.mapToEyeEntity(eyeFormDto);
        eyeService.saveEye(eyeEntity);
        return "redirect:/eyeOverview";
    }
    @GetMapping(value = "/eyeForm")
    public String getEyeForm(Model model)
    {
        model.addAttribute("eye", new Eye());
        return "eyeForm";
    }

    @GetMapping(value = "/deleteEye/{id}")
    public String deleteEye(@PathVariable("id") Integer id) {
        eyeService.deleteEye(id);
        return "redirect:/eyeOverview";
    }

    @GetMapping(value = "/editEye/{id}")
    public String getEditEyeForm(@PathVariable("id") Integer id, Model model) {
        Eye eye = eyeService.getEyeById(id);
        if (eye != null) {
            model.addAttribute("eye", eye);
            return "editEyeForm";
        }
        return "redirect:/eyeOverview";
    }
    @PostMapping("/updateEye/{id}")
    public String updateEye(@PathVariable("id") Integer id, @ModelAttribute("eyeFormDto") EyeFormDto updateEye) {
        Eye existingEye = eyeService.getEyeById(id);
        if (existingEye != null) {
            Eye updatedEye = eyeMapper.mapToEye(updateEye);
            existingEye.setName(updatedEye.getName());
            existingEye.setQuantity(updatedEye.getQuantity());
            existingEye.setTexture(updatedEye.getTexture());
            existingEye.setPrice(updatedEye.getPrice());
            eyeService.saveEye(existingEye);
        }
        return "redirect:/eyeOverview";
    }

    @GetMapping(value="/homeForEye")
    public String goHome() {return "redirect:/beautyLoungeProductsForm";}
}
