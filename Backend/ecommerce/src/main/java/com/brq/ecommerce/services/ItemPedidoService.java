package com.brq.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.dtos.ItemPedidoDTO;
import com.brq.ecommerce.models.ItemPedidoModel;
import com.brq.ecommerce.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public List<ItemPedidoDTO> findAll(){
		List<ItemPedidoModel> list = this.itemPedidoRepository.findAll();
		return list.stream().map(x -> x.toDto()).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public void delete(int idItemPedido) {
		this.itemPedidoRepository.deleteById(idItemPedido);
	}
	

}
