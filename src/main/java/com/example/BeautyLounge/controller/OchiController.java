package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.model.Ochi;
import com.example.BeautyLounge.model.Ochi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OchiController {
    @GetMapping(value="/ochiProducts")
    @ResponseBody
    public List<Ochi> listOfProducts(){
        Ochi o1=new Ochi(1,"eyeshadow cream stick",100,"metallic", 35);
        Ochi o2=new Ochi(2, "eyeliner", 80, "cream", 50);
        Ochi o3= new Ochi(3, "eyeshadow palette", 60, "matte, glitter", 100);
        return List.of(o1, o2, o3);
    }
    @GetMapping(value="/ochi")
    public String Ochi(Model model) {
        String text = "These are our products for your eyes: ";
        model.addAttribute("message", text);

        Ochi o1 = new Ochi(1, "eyeshadow cream stick", 100, "metallic", 35);
        Ochi o2 = new Ochi(2, "eyeliner", 80, "cream", 50);
        Ochi o3 = new Ochi(3, "eyeshadow palette", 60, "matte, glitter", 100);
        List<Ochi> products = List.of(o1, o2, o3);
        model.addAttribute("arrayOfProducts", products);

        return "ochi";
    }

    @GetMapping(value = "/ochiOverview")
    public String getOchiOverview(Model model) {
        Ochi o1 = new Ochi(1,"eyeshadow cream stick",100,"metallic, cream", 35);
        Ochi o2 = new Ochi(2, "eyeliner", 80, "cream", 50);
        Ochi o3 = new Ochi(3, "eyeshadow palette", 60, "matte, glitter", 100);

        List<Ochi> ochiList = List.of(o1, o2, o3);
        model.addAttribute("ochiList", ochiList);

        return "ochiOverview";
    }

    @GetMapping(value = "/ochiForm")
    public String getOchiForm(Model model) {
        model.addAttribute("ochi", new Ochi());
        return "ochiForm";
    }

    @PostMapping(value = "/submitOchi")
    public String submitOchi(@ModelAttribute("ochi") Ochi ochi) {
        System.out.println(ochi.toString());
        return null;
    }
}
