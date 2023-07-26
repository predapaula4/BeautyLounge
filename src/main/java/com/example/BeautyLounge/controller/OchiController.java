package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.model.Ochi;
import com.example.BeautyLounge.model.Ochi;
import com.example.BeautyLounge.model.Ten;
import com.example.BeautyLounge.repository.BeautyLoungeRepository;
import com.example.BeautyLounge.repository.OchiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OchiController {

    @Autowired
    private OchiRepository ochiRepository;
    @Autowired
    private BeautyLoungeRepository beautyLoungeRepository;


//    @GetMapping(value="/ochiProducts")
//    @ResponseBody
//    public List<Ochi> listOfProducts(){
//        Ochi o1=new Ochi(1,"eyeshadow cream stick", "eyes", "metallic", 100, 35);
//        Ochi o2=new Ochi(2, "eyes","eyeliner", "cream", 80, 50);
//        Ochi o3= new Ochi(3, "eyeshadow palette", "eyes", "matte, glitter", 60, 100);
//        return List.of(o1, o2, o3);
//    }
//    @GetMapping(value="/ochi")
//    public String Ochi(Model model) {
//        String text = "These are our products for your eyes: ";
//        model.addAttribute("message", text);
//
//        List<Ochi> ochiList = ochiRepository.findAll();
//        model.addAttribute("ochiList", ochiList);
//
//        return "ochi";
//    }

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
    @GetMapping(value = "/deleteOchi/{id}")
    public String deleteOchi(@PathVariable("id") Integer id) {
        Ochi ochi = ochiRepository.findById(id).orElse(null);
        if (ochi != null) {
            ochiRepository.delete(ochi);

        }
        return "redirect:/ochiOverview";
    }

    @GetMapping(value = "/editOchi/{id}")
    public String getEditOchiForm(@PathVariable("id") Integer id, Model model) {
        Ochi ochi = ochiRepository.findById(id).orElse(null);
        if (ochi != null) {
            model.addAttribute("ochi", ochi);
            return "editOchiForm";
        }
        return "redirect:/ochiOverview";
    }

    @PostMapping(value = "/updateOchi/{id}")
    public String updateOchi(@PathVariable("id") Integer id, @ModelAttribute("ochi") Ochi updatedOchi) {
        Ochi ochi = ochiRepository.findById(id).orElse(null);
        if (ochi != null) {
            ochi.setName(updatedOchi.getName());
            ochi.setQuantity(updatedOchi.getQuantity());
            ochi.setTexture(updatedOchi.getTexture());
            ochi.setPrice(updatedOchi.getPrice());
            ochiRepository.save(ochi);

        }
        return "redirect:/ochiOverview";
    }
    @GetMapping(value="/homeForEye")
    public String goHome(){
        return "redirect:/beautyLoungeProductsForm";
    }
}
