package com.example.erroressrpingboot.controllers;

// TODO: Manejar errores y pasarlo a la vista

import com.example.erroressrpingboot.errors.UsuarioNoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler({ArithmeticException.class})
    public String aritmeticaError(Exception ex, Model model) {
        model.addAttribute("error","Error Aritmetico");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return "error/aritmetica";
    }

    @ExceptionHandler({UsuarioNoEncontrado.class})
    public String usuarioNoEncontrado (Exception ex, Model model) {
        model.addAttribute("error","Usuario no encontrado");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return "error/notFound";
    }


}
