package com.brq.ecommerce.dtos;

import org.modelmapper.ModelMapper;

import com.brq.ecommerce.models.UsuarioModel;

import lombok.Data;

@Data
public class UsuarioDTO {
	
	private int idUsuario;
	private String nomeUsuario;
	private String cpfUsuario;
	private String emailUsuario;
	private String telefoneUsuario;
	private String senhaUsuario;
	
	public UsuarioModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper.map(this, UsuarioModel.class);		
	}

}
