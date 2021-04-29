package com.brq.ecommerce.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brq.ecommerce.dtos.ItemPedidoDTO;
import com.brq.ecommerce.services.ItemPedidoService;

@Controller
@RequestMapping("item-pedidos")
public class ItemPedidoController {
	
	
	@Autowired
	ItemPedidoService itemPedidoService;
	
	@PatchMapping("/idItemPedido")
	public ResponseEntity<ItemPedidoDTO> update (@Valid @RequestBody ItemPedidoDTO newObj, @PathVariable int idItemPedido){
		return ResponseEntity.ok().body(this.itemPedidoService.update(idItemPedido, newObj));
	}

}
