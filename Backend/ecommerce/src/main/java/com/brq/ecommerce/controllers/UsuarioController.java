package com.brq.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.ecommerce.dtos.UsuarioDTO;
import com.brq.ecommerce.services.UsuarioService;


@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("")
	public List<UsuarioDTO> findAll(){
		return this.usuarioService.findAll();
	}
	
	@GetMapping("/{idUsuario}")
	public UsuarioDTO findOne(@PathVariable int idUsuario) {
		return this.usuarioService.findOne(idUsuario);
	}

}