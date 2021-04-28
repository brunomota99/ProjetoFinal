package com.brq.ecommerce.dtos;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PedidoDTO {
	
	private Integer dataPedido;

	@NotNull
	private Double totalPedido;

}