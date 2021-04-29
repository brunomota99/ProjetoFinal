package com.brq.ecommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.dtos.ItemPedidoDTO;
import com.brq.ecommerce.models.ItemPedidoModel;
import com.brq.ecommerce.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	
	public ItemPedidoDTO update(int id, ItemPedidoDTO newObj) {
		Optional<ItemPedidoModel> optObj = this.itemPedidoRepository.findById(id);
		
		if (optObj.isPresent()) {
			ItemPedidoModel obj = optObj.get();
			
			obj.setQtdeItemPedido(newObj.getQtdeItemPedido());
			
			/*Nesse caso a alteração de preços é automatizada. (preçoItem * quantidadeItem)
			 * Guilherme Pessoa, grupo Azul Claro
			 */
			return this.itemPedidoRepository.save(obj).toDto();
		}else {
			throw new RuntimeException("Pedido não encontrado");
		}
	}
}
