package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.model.BeautyLounge;
import com.example.BeautyLounge.model.Ochi;
import com.example.BeautyLounge.model.Ten;
import com.example.BeautyLounge.repository.OchiRepository;
import com.example.BeautyLounge.repository.TenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
//template uri pentru fiecare
public class BeautyLoungeController {

    @Autowired
    private TenRepository tenRepository;
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
}
