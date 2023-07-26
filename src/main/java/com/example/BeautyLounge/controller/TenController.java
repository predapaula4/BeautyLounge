package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.dto.TenFormDto;
import com.example.BeautyLounge.dto.TenOverviewDto;
import com.example.BeautyLounge.mapper.TenMapper;
import com.example.BeautyLounge.model.Ochi;
import com.example.BeautyLounge.model.Ten;
import com.example.BeautyLounge.repository.BeautyLoungeRepository;
import com.example.BeautyLounge.repository.TenRepository;
import com.example.BeautyLounge.service.TenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.BeautyLounge.model.Ten;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TenController {

    @Autowired
    private TenService tenService;
    @Autowired
    private TenMapper tenMapper;


@GetMapping("/ten")
public String getTen(Model model) {
    String text = "These are our products for your eyes: ";
    model.addAttribute("message", text);

    List<TenOverviewDto> tenList = tenService.getAllTen();
    model.addAttribute("tenList", tenList);

    return "ten";
}

    @GetMapping(value = "/tenOverview")
    public String getTenOverview(Model model) {

        List<TenOverviewDto> tenList = tenService.getAllTen();
        model.addAttribute("tenList", tenList);

        return "tenOverview";
    }
    @GetMapping(value = "/tenForm")
    public String getTenForm(Model model) {
        model.addAttribute("ten", new Ten());
        return "tenForm";
    }
    @PostMapping("/submitTen")
    public String submitTen(@ModelAttribute("ten") TenFormDto ten, Model model) {
        Ten tenEntity = tenMapper.mapToTenEntity(ten);
        tenService.saveTen(tenEntity);
        return "redirect:/tenOverview";
    }
    @GetMapping(value = "/deleteTen/{id}")
    public String deleteTen(@PathVariable("id") Integer id) {
        tenService.deleteTen(id);
        return "redirect:/tenOverview";
    }

    @GetMapping(value = "/editTen/{id}")
    public String getEditTenForm(@PathVariable("id") Integer id, Model model) {
        Ten ten = tenService.getTenById(id);
        if (ten != null) {
            model.addAttribute("ten", ten);
            return "editTenForm";
        }
        return "redirect:/tenOverview";
    }

    @PostMapping("/updateTen/{id}")
    public String updateTen(@PathVariable("id") Integer id, @ModelAttribute("tenFormDto") TenFormDto updateTen) {
        Ten existingTen = tenService.getTenById(id);
        if (existingTen != null) {
            Ten updatedTen = tenMapper.mapToTen(updateTen);
            existingTen.setName(updatedTen.getName());
            existingTen.setQuantity(updatedTen.getQuantity());
            existingTen.setTexture(updatedTen.getTexture());
            existingTen.setPrice(updatedTen.getPrice());
            tenService.saveTen(existingTen);
        }
        return "redirect:/tenOverview";
    }

    @GetMapping(value="/homeForTen")
    public String goHome(){
        return "redirect:/beautyLoungeProductsForm";
    }

}
