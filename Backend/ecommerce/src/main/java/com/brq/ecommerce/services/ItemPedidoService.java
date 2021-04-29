package com.brq.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.dtos.ItemPedidoDTO;
import com.brq.ecommerce.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public ItemPedidoDTO finOne(int itemPedido) {
		return this.itemPedidoRepository.findById(itemPedido).get().toDto();
	}
}
