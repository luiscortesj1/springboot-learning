package com.example.erroressrpingboot.errors;

// error de usuario no encontrado, establecer el error
public class UsuarioNoEncontrado  extends  RuntimeException{
    public UsuarioNoEncontrado(String id) {
        super("Usuario con ID: ".concat(id).concat(" no existe"));
    }
}
