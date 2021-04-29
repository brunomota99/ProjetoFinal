package com.brq.ecommerce.dtos;


import org.modelmapper.ModelMapper;

import com.brq.ecommerce.models.EnderecoModel;

import lombok.Data;

@Data
public class EnderecoDTO {
	
	private Integer id;
	
	private String logradouro;
	
	private String numero;
	
	private String complemento;
	
	private String cep;
	
	private String cidade;
	
	private String estado;
	
	//dto do usuario
	//private EnderecoDTO enderecoObj;
	
	
	public EnderecoModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper.map(this,  EnderecoModel.class);
	}

}