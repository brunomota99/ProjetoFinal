package com.brq.ecommerce.services;

import com.brq.ecommerce.dtos.UsuarioDTO;
import com.brq.ecommerce.models.UsuarioModel;
import com.brq.ecommerce.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    public UsuarioDTO update(int idUsuario, UsuarioDTO updateUsuario) {
        Optional<UsuarioModel> usuarioOptional = this.usuarioRepository.findById(idUsuario);
        if(usuarioOptional.isPresent()) {
            UsuarioModel usuarioExistente = usuarioOptional.get();
            usuarioExistente.setNomeUsuario(updateUsuario.getNomeUsuario());
            usuarioExistente.setCpfUsuario(updateUsuario.getCpfUsuario());
            usuarioExistente.setEmailUsuario(updateUsuario.getEmailUsuario());
            usuarioExistente.setTelefoneUsuario(updateUsuario.getTelefoneUsuario());
            usuarioExistente.setSenhaUsuario(updateUsuario.getSenhaUsuario());

            return this.usuarioRepository.save(usuarioExistente).toDTO();
        }else {
            throw new RuntimeException("Usuario(a) nao encontrado(a)");
        }

    }

}
