package com.brq.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brq.ecommerce.dtos.ItemPedidoDTO;
import com.brq.ecommerce.services.ItemPedidoService;

@Controller
@RequestMapping("item-pedidos")
public class ItemPedidoController {
	
	
	@Autowired
	ItemPedidoService itemPedidoService;
	
	@GetMapping("")
	public ResponseEntity< List<ItemPedidoDTO> > findAll(){
		return ResponseEntity.ok().body(this.itemPedidoService.findAll());
	}
	
	@DeleteMapping("/{idItemPedido}")
	public void delete( @PathVariable int idItemPedido ) {
		this.itemPedidoService.delete(idItemPedido);
	}
	

}
