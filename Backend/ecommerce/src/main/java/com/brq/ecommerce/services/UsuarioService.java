package com.brq.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.dtos.UsuarioDTO;
import com.brq.ecommerce.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioDTO save(UsuarioDTO novoUsuario) {
		return this.usuarioRepository.save(novoUsuario.toEntity()).toDTO();
	}

}
