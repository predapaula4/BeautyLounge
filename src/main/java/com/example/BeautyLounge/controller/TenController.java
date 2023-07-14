package com.example.BeautyLounge.controller;

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
    @GetMapping(value="/tenProducts")
    @ResponseBody
    public List<Ten> listOfProducts(){
        Ten t1=new Ten(1,"primer",125,"creamy", 50);
        Ten t2=new Ten(2, "foundation", 75, "mouse", 99);
        Ten t3= new Ten(3, "foundation", 50, "liquid", 60);
        return List.of(t1, t2, t3);
    }
    @GetMapping(value="/ten")
    public String ten(Model model) {
        String text = "These are our products for your skin: ";
        model.addAttribute("message", text);

        Ten t1 = new Ten(1, "primer", 125, "creamy", 50);
        Ten t2 = new Ten(2, "foundation", 75, "mouse", 99);
        Ten t3 = new Ten(3, "foundation", 50, "liquid", 60);
        List<Ten> products = List.of(t1, t2, t3);
        model.addAttribute("arrayOfProducts", products);

        return "ten";
    }
    @GetMapping(value="/tenOverview")
    public String index(Model model) {

        Ten t1 = new Ten(1, "primer", 125, "creamy", 50);
        Ten t2 = new Ten(2, "foundation", 75, "mouse", 99);
        Ten t3 = new Ten(3, "foundation", 50, "liquid", 60);
        List<Ten> products = List.of(t1, t2, t3);
        model.addAttribute("arrayOfProducts", products);

        return "ten";
    }
    @GetMapping(value = "/tenForm")
    public String getTenForm(Model model) {
        model.addAttribute("ten", new Ten());
        return "tenForm";
    }
    @PostMapping(value = "/submitTen")
    public String submitTen(@ModelAttribute("ten") Ten ten) {
        System.out.println(ten.toString());
        return "submitTen";
    }
}
