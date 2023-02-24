package com.example.erroressrpingboot.services;

import com.example.erroressrpingboot.models.domain.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<Usuario> findAll ();
    public Usuario findById (Integer id);
    public Optional<Usuario> findByIdOptional (Integer id);

}
