package com.example.erroressrpingboot.services;

import com.example.erroressrpingboot.models.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl  implements UsuarioService{

    private List<Usuario> lista;

    public UsuarioServiceImpl() {
        this.lista= new ArrayList<>();
        this.lista.add(new Usuario(1,"Luis","cortes"));
        this.lista.add(new Usuario(2,"Gabriel","Jacanamijoy"));
    }

    @Override
    public List<Usuario> findAll() {
        return lista;
    }

    @Override
    public Usuario findById(Integer id) {
        Usuario resultado = null;
        for(Usuario u: this.lista) {
            if(u.getId().equals(id)) {
                resultado = u;
                break;
            }
        }

        return resultado;
    }

    @Override
    public Optional<Usuario> findByIdOptional(Integer id) {
        Usuario usuario= findById(id);
        return Optional.ofNullable(usuario);
    }
}
