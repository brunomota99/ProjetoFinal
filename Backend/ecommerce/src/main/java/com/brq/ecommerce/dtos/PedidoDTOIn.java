package com.brq.ecommerce.dtos;

import org.modelmapper.ModelMapper;

import com.brq.ecommerce.models.PedidoModel;

import lombok.Data;

@Data
public class PedidoDTOIn {
	
	private Double totalPedido;
	
	public PedidoModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, PedidoModel.class);
	}
	

}
