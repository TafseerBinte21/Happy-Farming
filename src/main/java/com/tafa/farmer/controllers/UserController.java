package com.tafa.farmer.controllers;

import java.util.ArrayList;
import java.util.List;

import com.tafa.farmer.models.crop;
import com.tafa.farmer.models.User;
import com.tafa.farmer.services.CropService;
import com.tafa.farmer.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private CropService cropService;

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String profile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userService.getUserByEmail(username);
        model.addAttribute("user", user);
        return "profile";
    }

//    @GetMapping("/library")
//    public String gamelist(Model model) throws Exception {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Object principal = auth.getPrincipal();
//        String username = ((UserDetails) principal).getUsername();
//        User user = userService.getUserByEmail(username);
//        List<Long> croplist = user.getCroplist();
//        List<crop> crops = new ArrayList<>();
//        for (Long aGame : croplist) {
//            crops.add(cropService.findcropById(aGame));
//        }
//        model.addAttribute("games", crops);
//        return "croplist";
//    }

    @GetMapping("/MyCrops")
    public String croplist(Model model) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userService.getUserByEmail(username);
        List<Long> croplist = user.getCroplist();
        List<crop> crops = new ArrayList<>();
        for (Long aGame : croplist) {
            crops.add(cropService.findcropById(aGame));
        }
        System.out.println();
        System.out.println();
        System.out.println(crops);
        System.out.println();
        System.out.println();
        model.addAttribute("crops", crops);
        return "MyCrops";
    }

    @RequestMapping("/MyCrops/add/{id}")
    public String addcropcroplist(@PathVariable String id, Model model) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userService.getUserByEmail(username);
        userService.addcropByIdInMyCrops(user, Long.valueOf(id));
        return "redirect:/MyCrops";
    }

    @RequestMapping("/MyCrops/delete/{id}")
    public String deletecropcroplist(@PathVariable String id, Model model) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userService.getUserByEmail(username);
        userService.deletecropByIdFromMyCrops(user, Long.valueOf(id));
        return "redirect:/MyCrops";
    }
//
//    @GetMapping("/cart")
//    public String cart(Model model) throws Exception {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Object principal = auth.getPrincipal();
//        String username = ((UserDetails) principal).getUsername();
//        User user = userService.getUserByEmail(username);
//        List<Long> cart = user.getCart();
//        List<Game> games = new ArrayList<>();
//        for (Long aGame : cart) {
//            games.add(gameService.findGameById(aGame));
//        }
//        model.addAttribute("games", games);
//        return "cart";
//    }
//
//    @RequestMapping("/cart/add/{id}")
//    public String addGameCart(@PathVariable String id, Model model) throws Exception {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Object principal = auth.getPrincipal();
//        String username = ((UserDetails) principal).getUsername();
//        User user = userService.getUserByEmail(username);
//        userService.addGameByIdInCart(user, Long.valueOf(id));
//        return "redirect:/cart";
//    }
//
//    @RequestMapping("/cart/delete/{id}")
//    public String deleteGameCart(@PathVariable String id, Model model) throws Exception {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Object principal = auth.getPrincipal();
//        String username = ((UserDetails) principal).getUsername();
//        User user = userService.getUserByEmail(username);
//        userService.deleteGameByIdFromCart(user, Long.valueOf(id));
//        return "redirect:/cart";
//    }

}
