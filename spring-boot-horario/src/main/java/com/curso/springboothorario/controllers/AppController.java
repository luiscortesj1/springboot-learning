package com.curso.springboothorario.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"/","/index"})
    public String index(Model model){
        model.addAttribute("titulo", "Horario de atención");
        return "index";
    }


    @GetMapping({"/cerrado"})
    public String cerrado(Model model){
        model.addAttribute("titulo", "Cerrado");
        return "cerrado";
    }
}
