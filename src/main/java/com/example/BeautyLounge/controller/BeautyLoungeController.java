package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.model.*;
import com.example.BeautyLounge.repository.EyebrowsRepository;
import com.example.BeautyLounge.repository.LipsRepository;
import com.example.BeautyLounge.repository.EyeRepository;
import com.example.BeautyLounge.repository.SkinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class BeautyLoungeController {

    @Autowired
    private SkinRepository skinRepository;
    @Autowired
    private EyeRepository eyeRepository;

    @Autowired
    private LipsRepository lipsRepository;

    @Autowired
    private EyebrowsRepository eyebrowsRepository;

    @GetMapping(value="/beautyLoungeProducts")
    public String listOfProducts(Model model){

        String text = "These are our products for your skin: ";
        model.addAttribute("message", text);

        List<Skin> skinList = skinRepository.findAll();
        model.addAttribute("skinList", skinList);

        List<Eye> eyeList = eyeRepository.findAll();
        model.addAttribute("eyeList", eyeList);

        List<Lips> lipsList=lipsRepository.findAll();
        model.addAttribute("lipsList", lipsList);

        List<Eyebrows> eyebrowsList=eyebrowsRepository.findAll();
        model.addAttribute("eyebrowsList", eyebrowsList);

        return "beautyLoungeProducts";
    }
    @GetMapping(value = "/beautyLoungeProductsForm")
    public String getbeautyLoungeProductsForm(Model model, Authentication authentication) {

        authentication.getPrincipal();
        addUserToModel(model, authentication);
        model.addAttribute("beautyLoungeProducts", new BeautyLounge());
        return "beautyLoungeProductsForm";
    }
    @GetMapping(value = "/showAllProducts")
    public String goToAllProducts(Model model) {

        return  "redirect:/beautyLoungeProducts";
    }
    @GetMapping(value = "/skinProduct")
    public String goToSkinProducts(Model model) {

        return  "redirect:/skinForm";
    }
    @GetMapping(value = "/eyeProduct")
    public String goToEyeProducts(Model model) {

        return  "redirect:/eyeForm";
    }
    @GetMapping(value = "/lipsProduct")
    public String goToLipsProducts(Model model) {

        return  "redirect:/lipsForm";
    }

    @GetMapping(value = "/eyebrowProduct")
    public String goToEyebrowProducts(Model model) {

        return  "redirect:/eyebrowsForm";
    }

    @GetMapping(value="/homeForProducts")
    public String goHome(){
        return "redirect:/beautyLoungeProductsForm";
    }

    protected void addUserToModel(Model model, Authentication authentication) {
        var roles = authentication.getAuthorities().stream()
                .map(String::valueOf)
                .toList();

        model.addAttribute("userName", authentication.getName());
        model.addAttribute("isAdmin", roles.contains("ROLE_ADMIN"));
    }
}
