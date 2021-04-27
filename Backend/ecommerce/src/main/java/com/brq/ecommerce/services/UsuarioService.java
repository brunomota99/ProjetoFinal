package com.brq.ecommerce.services;

<<<<<<< HEAD
import com.brq.ecommerce.dtos.UsuarioDTO;
import com.brq.ecommerce.models.UsuarioModel;
import com.brq.ecommerce.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
=======
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.dtos.UsuarioDTO;
import com.brq.ecommerce.models.UsuarioModel;
import com.brq.ecommerce.repositories.UsuarioRepository;
>>>>>>> a1da7034a2d0a9943994971a827bd03a8df85d98

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioDTO> findAll(){
		List<UsuarioModel> list = this.usuarioRepository.findAll();
		return list.stream().map( x -> x.toDTO()).collect(Collectors.toCollection(ArrayList :: new));
	}
	
	public UsuarioDTO findOne(int idUsuario) {
		return this.usuarioRepository.findById(idUsuario).orElseThrow(()-> new RuntimeException("Usuário não encontrado!")).toDTO();
	}

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
