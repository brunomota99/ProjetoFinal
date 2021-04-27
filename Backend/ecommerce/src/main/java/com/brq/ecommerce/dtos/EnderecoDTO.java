package com.brq.ecommerce.dtos;


import org.modelmapper.ModelMapper;

import com.brq.ecommerce.models.EnderecoModel;

import lombok.Data;

@Data
public class EnderecoDTO {
	
	
	private String logradouro;
	
	private String numero;
	
	private String complemento;
	
	private String cep;
	
	private String cidade;
	
	private String estado;
	
	public EnderecoModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper.map(this,  EnderecoModel.class);
	}

}
