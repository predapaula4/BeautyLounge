package com.example.BeautyLounge.controller;

import org.springframework.ui.Model;
import com.example.BeautyLounge.model.Ten;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        String text = "This is our products for your ten: ";
        model.addAttribute("message", text);

        Ten t1 = new Ten(1, "primer", 125, "creamy", 50);
        Ten t2 = new Ten(2, "foundation", 75, "mouse", 99);
        Ten t3 = new Ten(3, "foundation", 50, "liquid", 60);
        List<Ten> products = List.of(t1, t2, t3);
        model.addAttribute("arrayOfProducts", products);

        return "ten";
    }
}
