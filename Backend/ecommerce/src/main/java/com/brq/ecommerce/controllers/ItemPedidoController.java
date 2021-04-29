package com.brq.ecommerce.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brq.ecommerce.dtos.ItemPedidoDTO;
import com.brq.ecommerce.services.ItemPedidoService;

@Controller
@RequestMapping("item-pedidos")
public class ItemPedidoController {
	
	
	@Autowired
	ItemPedidoService itemPedidoService;
	
	
	@PostMapping("")
	public ResponseEntity<ItemPedidoDTO> save(@RequestBody @Valid ItemPedidoDTO newItemPedido){		
		return ResponseEntity.ok().body(this.itemPedidoService.save(newItemPedido));
	}
	
	
}
