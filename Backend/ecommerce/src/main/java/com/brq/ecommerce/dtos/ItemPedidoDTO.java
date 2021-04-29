package com.brq.ecommerce.dtos;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.brq.ecommerce.models.ItemPedidoModel;

import lombok.Data;

@Data
public class ItemPedidoDTO {
	
	
	@NotNull
	private Integer qtdeItemPedido;	
	
	private Double precoItemPedido;
	// No need to pass it. We'll use it only to show the output.

	public ItemPedidoModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, ItemPedidoModel.class);
	}
}
