package com.brq.ecommerce.dtos;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;

import com.brq.ecommerce.models.UsuarioLoginModel;

import lombok.Data;

@Data
public class UsuarioLoginDTO {
	private int id;
	private String nome;	
	private String senha;
	private String email;		
	private Set<Integer> perfis = new HashSet<>();
	
	public UsuarioLoginModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper.map(this, UsuarioLoginModel.class);		
	}
}