package com.brq.ecommerce.dtos;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ItemPedidoDTO {
	
	@NotNull
	private Integer qtdeItemPedido;
	
	@NotNull
	private Double precoItemPedido;
	
	@NotNull
	private ProdutoDto produto;
}
