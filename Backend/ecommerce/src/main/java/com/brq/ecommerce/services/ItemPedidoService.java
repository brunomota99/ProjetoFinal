package com.brq.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.dtos.ItemPedidoDTO;
import com.brq.ecommerce.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public ItemPedidoDTO save(ItemPedidoDTO newItemPedido) {		
		Double valorItem = 10.0;
		newItemPedido.setPrecoItemPedido(valorItem);
		/*
		 *  Trocar o código acima pelo preço do produto que virá da tabela produto.
		 *  Lembrando que que o preço do tab_item_pedido é a soma do preço da quantidade de produtos que esse item terá.
		 *  O código ficará mais ou menos assim:
		 * Produto = produto = (funcaoFindById) ou outra.
		 * Double valorItem = produto.getPrice() * newItemPedido.getQtdeItemPedido();
		 * newItemPedido.setPrecoItemPedido(valorItem);
		 * 
		 * Antes de salvar: Chamar outra funcao, neste serviço ou no serviço do produto para checar se tem produto em estoque.
		 * No angular: Checar se o produto está indisponível e não exibir como opção de compra ou somente a quantidade desejada.
		 * Fabio Alves From Grupo Azul Claro
		 */	
		
		return this.itemPedidoRepository.save(newItemPedido.toEntity()).toDto();
	}

}
