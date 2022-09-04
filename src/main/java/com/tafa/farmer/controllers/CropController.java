package com.tafa.farmer.controllers;

import java.util.ArrayList;
import java.util.List;

import com.tafa.farmer.models.crop;
import com.tafa.farmer.services.CropService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CropController {

    @Autowired
    private CropService cropService;

    @GetMapping("/shop")
    public String shop(Model model) {
        List<crop> crops = cropService.findAll();
        model.addAttribute("crops", crops);
        return "shop";
    }

    @RequestMapping("/crop/{id}")
    public String crop(@PathVariable String id, Model model) {
        Long gameId = Long.valueOf(id);
        try {
            crop c = cropService.findcropById(gameId);
            model.addAttribute("crop", c);
        } catch (Exception e) {
            System.out.println("crop not found by id.");
            e.printStackTrace();
        }
        return "crop";
    }
    
	@GetMapping("/checkout")
	public String ch() {
		return "checkout";
	}

}
