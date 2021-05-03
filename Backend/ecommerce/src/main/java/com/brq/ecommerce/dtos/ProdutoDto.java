package com.brq.ecommerce.dtos;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.brq.ecommerce.models.ProdutoModel;

import lombok.Data;

@Data
public class ProdutoDto {
	
	private int idProd;
  
	@NotNull(message = "O campo 'nomeProd' não pode ser nulo!")
	private String nomeProd;
	
	@NotNull(message = "O campo 'precoUnitProd' não pode ser nulo!")
	private double precoUnitProd;
	
	@NotNull(message = "O campo 'qtdeEstoqueProd' não pode ser nulo!")
	private int qtdeEstoqueProd;
	
	public ProdutoModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, ProdutoModel.class);
	}
}