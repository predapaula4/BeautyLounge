package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.model.Ten;
import com.example.BeautyLounge.repository.TenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.BeautyLounge.model.Ten;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TenController {

    @Autowired
    private TenRepository tenRepository;

    @GetMapping(value="/tenProducts")
    @ResponseBody
    public List<Ten> listOfProducts(){
        Ten t1=new Ten(1,"primer", "face", 125,"creamy", 50);
        Ten t2=new Ten(2, "foundation", "face", 75, "mousse", 99);
        Ten t3= new Ten(3, "foundation", "face", 50, "liquid", 60);
        return List.of(t1, t2, t3);
    }
    @GetMapping(value="/ten")
    public String Ten(Model model) {
        String text = "These are our products for your eyes: ";
        model.addAttribute("message", text);

        List<Ten> tenList = tenRepository.findAll();
        model.addAttribute("tenList", tenList);

        return "ten";
    }

    @GetMapping(value = "/tenOverview")
    public String getTenOverview(Model model) {

        List<Ten> tenList = tenRepository.findAll();
        model.addAttribute("tenList", tenList);

        return "tenOverview";
    }
    @GetMapping(value = "/tenForm")
    public String getTenForm(Model model) {
        model.addAttribute("ten", new Ten());
        return "tenForm";
    }
    @PostMapping(value = "/submitTen")
    public String submitTen(@ModelAttribute("ten") Ten ten) {
        tenRepository.save(ten);
        return "redirect:/tenOverview";
    }
}
