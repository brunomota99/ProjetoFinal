package com.brq.ecommerce.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PedidoDTO {	
	
	private Integer idPedido;
	
	private LocalDateTime dataPedido;

	@NotNull
	private Double totalPedido;

}