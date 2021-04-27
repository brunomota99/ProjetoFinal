package com.brq.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.dtos.UsuarioDTO;
import com.brq.ecommerce.models.UsuarioModel;
import com.brq.ecommerce.repositories.UsuarioRepository;

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

}
