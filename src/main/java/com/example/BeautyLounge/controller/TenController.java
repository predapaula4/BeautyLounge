package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.model.Ochi;
import com.example.BeautyLounge.model.Ten;
import com.example.BeautyLounge.repository.BeautyLoungeRepository;
import com.example.BeautyLounge.repository.TenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.BeautyLounge.model.Ten;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TenController {

    @Autowired
    private TenRepository tenRepository;
    @Autowired
    private BeautyLoungeRepository beautyLoungeRepository;


    @GetMapping(value="/tenProducts")
    @ResponseBody
    public List<Ten> listOfProducts(){
        Ten t1=new Ten(1,"primer", "face", "creamy",125, 50);
        Ten t2=new Ten(2, "foundation", "face", "mousse", 75, 99);
        Ten t3= new Ten(3, "foundation", "face","liquid", 50,  60);
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
    @GetMapping(value = "/deleteTen/{id}")
    public String deleteTen(@PathVariable("id") Integer id) {
        Ten ten = tenRepository.findById(id).orElse(null);
        if (ten != null) {
            tenRepository.delete(ten);
        }
        return "redirect:/tenOverview";
    }

    @GetMapping(value = "/editTen/{id}")
    public String getEditTenForm(@PathVariable("id") Integer id, Model model) {
        Ten ten = tenRepository.findById(id).orElse(null);
        if (ten != null) {
            model.addAttribute("ten", ten);
            return "editTenForm";
        }
        return "redirect:/tenOverview";
    }

    @PostMapping(value = "/updateTen/{id}")
    public String updateTen(@PathVariable("id") Integer id, @ModelAttribute("ten") Ten updateTen) {
        Ten ten = tenRepository.findById(id).orElse(null);
        if (ten != null) {
            ten.setName(updateTen.getName());
            ten.setQuantity(updateTen.getQuantity());
            ten.setTexture(updateTen.getTexture());
            ten.setPrice(updateTen.getPrice());
            tenRepository.save(ten);
        }
        return "redirect:/tenOverview";
    }
    @GetMapping(value="/homeForTen")
    public String goHome(){
        return "redirect:/beautyLoungeProductsForm";
    }

}
