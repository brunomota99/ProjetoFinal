package com.brq.ecommerce.dtos;

import lombok.Data;

@Data
public class ItemPedidoDTO {
	
	private Integer idItemPedido;
	
	private Integer qtdeItemPedido;
	
	private Double precoItemPedido;
	
	private ProdutoDto produto;
}
