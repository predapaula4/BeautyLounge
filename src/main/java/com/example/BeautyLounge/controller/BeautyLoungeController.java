package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.model.BeautyLounge;
import com.example.BeautyLounge.model.Ochi;
import com.example.BeautyLounge.model.Ten;
import com.example.BeautyLounge.repository.OchiRepository;
import com.example.BeautyLounge.repository.TenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class BeautyLoungeController {

    @Autowired
    private TenRepository tenRepository;
    @Autowired
    private OchiRepository ochiRepository;

    @GetMapping(value="/beautyLoungeProducts")
    public String listOfProducts(Model model){

        String text = "These are our products for your skin: ";
        model.addAttribute("message", text);

        List<Ten> tenList = tenRepository.findAll();
        model.addAttribute("tenList", tenList);

        List<Ochi> ochiList = ochiRepository.findAll();
        model.addAttribute("ochiList", ochiList);

        return "beautyLoungeProducts";
    }
    @GetMapping(value = "/beautyLoungeProductsForm")
    public String getbeautyLoungeProductsForm(Model model) {
        model.addAttribute("beautyLoungeProducts", new BeautyLounge());
        return "beautyLoungeProductsForm";
    }
    @GetMapping(value = "/showAllProducts")
    public String goToAllProducts(Model model) {

        return  "redirect:/beautyLoungeProducts";
    }
    @GetMapping(value = "/tenProduct")
    public String goToTenProducts(Model model) {

        return  "redirect:/tenForm";
    }
    @GetMapping(value = "/ochiProduct")
    public String goToEyeProducts(Model model) {

        return  "redirect:/ochiForm";
    }
    @GetMapping(value="/homeForProducts")
    public String goHome(){
        return "redirect:/beautyLoungeProductsForm";
    }
}
