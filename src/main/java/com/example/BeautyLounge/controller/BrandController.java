package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.model.Brand;
import com.example.BeautyLounge.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping(value = "/brandOverview")
    public String brandOverview(Model model) {
        List<Brand> brandList = brandRepository.findAll();
        model.addAttribute("brandList", brandList);

        return "brandOverview";
    }

}
