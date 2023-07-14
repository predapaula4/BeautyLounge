package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.model.BeautyLounge;
import com.example.BeautyLounge.model.Ten;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
//template uri pentru fiecare
public class BeautyLoungeController {
    @GetMapping(value="/beautyLoungeProducts")
    @ResponseBody
    public String listOfProducts(Model model){

        String text = "These are our products for your skin: ";
        model.addAttribute("message", text);

        BeautyLounge t1=new BeautyLounge(1,"primer",125,"creamy", 50, "ten");
        BeautyLounge t2=new BeautyLounge(2, "foundation", 75, "mouse", 99, "ten");
        BeautyLounge t3= new BeautyLounge(3, "foundation", 50, "liquid", 60, "ten");

        return "beautyLoungeProducts";
    }

    @GetMapping(value = "/bautyLoungeForm")
    public String getBeautyLoungeForm(Model model) {
        model.addAttribute("beautyLounge", new BeautyLounge());
        return "bautyLoungeForm";
    }
    @PostMapping(value = "/submitBeautyLounge")
    public String submitTen(@ModelAttribute("beautyLounge") BeautyLounge beautyLounge) {
        System.out.println(beautyLounge.toString());
        return "submitBeautyLounge";
    }
}
