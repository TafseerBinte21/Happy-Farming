package com.tafa.farmer.controllers;

import java.util.List;

import com.tafa.farmer.controllers.dto.cropdto;
import com.tafa.farmer.models.crop;
import com.tafa.farmer.services.CropService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private CropService cropService;

    @GetMapping
    public String search() {
        return "search";
    }

    @PostMapping
    public String searchResult(@RequestParam(value = "crop") String crop, cropdto CropDto, Model model) {
    	System.out.println(" ");
    	System.out.println(crop);
    	System.out.println(" ");
        if (crop != "") {
            List<crop> crops = cropService.findcropBykeyword(crop);
            System.out.println(crops);
            model.addAttribute("crops", crops);
        }
        return "search";
    }

}
