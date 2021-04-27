package com.brq.ecommerce.dtos;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.brq.ecommerce.models.PedidosModel;

import lombok.Data;

@Data
public class PedidosDTO {

	@NotNull
	private Integer idPedido;

	@NotNull
	private Double totalPedido;

	public PedidosModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, PedidosModel.class);
	}
}