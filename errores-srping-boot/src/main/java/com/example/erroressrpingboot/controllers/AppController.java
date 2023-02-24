package com.example.erroressrpingboot.controllers;

import com.example.erroressrpingboot.errors.UsuarioNoEncontrado;
import com.example.erroressrpingboot.models.domain.Usuario;
import com.example.erroressrpingboot.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/index")
    public String index() {
        //Integer valor = 100/0;
        Integer valor = Integer.parseInt("10x");
        return "index";
    }


    @GetMapping("/ver/{id}")
    public String ver(@PathVariable("id") Integer id, Model model) {
        //Usuario usuario = usuarioService.findById(id);
        //if (usuario == null) throw  new UsuarioNoEncontrado(id.toString());
        // TODO: utilizando api opcional , otra funcionalidad
        Usuario usuario = usuarioService.findByIdOptional(id).orElseThrow(()-> new UsuarioNoEncontrado(id.toString()));
        model.addAttribute(usuario);
        model.addAttribute("title", "Detalles del usuario "+ usuario.getNombre());
        return "ver";
    }
}
