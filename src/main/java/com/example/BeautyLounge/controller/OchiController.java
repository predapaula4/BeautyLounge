package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.model.Ochi;
import com.example.BeautyLounge.model.Ochi;
import com.example.BeautyLounge.model.Ten;
import com.example.BeautyLounge.repository.OchiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OchiController {

    @Autowired
    private OchiRepository ochiRepository;

    @GetMapping(value="/ochiProducts")
    @ResponseBody
    public List<Ochi> listOfProducts(){
        Ochi o1=new Ochi(1,"eyeshadow cream stick", "eyes",100,"metallic", 35);
        Ochi o2=new Ochi(2, "eyes","eyeliner", 80, "cream", 50);
        Ochi o3= new Ochi(3, "eyeshadow palette", "eyes",60, "matte, glitter", 100);
        return List.of(o1, o2, o3);
    }
    @GetMapping(value="/ochi")
    public String Ochi(Model model) {
        String text = "These are our products for your eyes: ";
        model.addAttribute("message", text);

        List<Ochi> ochiList = ochiRepository.findAll();
        model.addAttribute("ochiList", ochiList);

        return "ochi";
    }

    @GetMapping(value = "/ochiOverview")
    public String getOchiOverview(Model model) {

        List<Ochi> ochiList = ochiRepository.findAll();
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
        ochiRepository.save(ochi);
        return "redirect:/ochiOverview";
    }
}
