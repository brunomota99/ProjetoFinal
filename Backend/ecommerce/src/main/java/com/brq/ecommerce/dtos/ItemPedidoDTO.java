package com.brq.ecommerce.dtos;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.brq.ecommerce.models.ItemPedidoModel;

import lombok.Data;

@Data
public class ItemPedidoDTO {
	
	
	@NotNull
	private Integer qtdeItemPedido;	
	
	
	@NotNull
	private Double PrecoItemPedido;
	
	
	public ItemPedidoModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, ItemPedidoModel.class);
	}
}
