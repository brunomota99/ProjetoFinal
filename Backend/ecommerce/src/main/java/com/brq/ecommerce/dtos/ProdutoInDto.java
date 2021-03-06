package com.brq.ecommerce.dtos;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.brq.ecommerce.models.ProdutoModel;

import lombok.Data;

@Data
public class ProdutoInDto {
	
	private Integer idProd;
	
	@NotNull(message = "O campo 'precoUnitProd' não pode ser nulo!")
	private double precoUnitProd;
	
	public ProdutoModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, ProdutoModel.class);
	}
}