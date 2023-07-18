package com.example.BeautyLounge.controller;

import com.example.BeautyLounge.model.BeautyLounge;
import com.example.BeautyLounge.model.Ochi;
import com.example.BeautyLounge.model.Ten;
import com.example.BeautyLounge.repository.BeautyLoungeRepository;
import com.example.BeautyLounge.repository.OchiRepository;
import com.example.BeautyLounge.repository.TenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public class BeautyLoungeController {

    @Autowired
    private TenRepository tenRepository;
    @Autowired
    private OchiRepository ochiRepository;
    @Autowired
    private BeautyLoungeRepository beautyLoungeRepository;

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
        model.addAttribute("beautyLoungeProductsForm", new BeautyLounge());
        return "beautyLoungeProductsForm";
    }
    @PostMapping(value = "/selectCategory")
    public String handleCategorySelection(@RequestParam("category") String category, RedirectAttributes redirectAttributes) {
        if (category.equals("ten")) {
            return "redirect:/tenForm";
        } else if (category.equals("buze")) {
            return "redirect:/buzePage";
        } else if (category.equals("ochi")) {
            return "redirect:/ochiForm";
        } else if (category.equals("sprancene")) {
            return "redirect:/sprancenePage";
        } else {
            // Dacă selectarea nu corespunde niciuneia dintre opțiuni, redirecționează către pagina generală
            redirectAttributes.addFlashAttribute("error", "Invalid category selection");
            return "redirect:/beautyLoungeProducts";
        }
    }
    @PostMapping(value = "/submitBeautyLoungeProducts")
    public String submitBeautyLoungeProducts(@ModelAttribute("ten") BeautyLounge beautyLounge) {
        beautyLoungeRepository.save(beautyLounge);
        return "redirect:/tenOverview";
    }
}
