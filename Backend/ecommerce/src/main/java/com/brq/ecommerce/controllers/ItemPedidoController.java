package com.brq.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("paginacao")
	public ResponseEntity< Page<ItemPedidoDTO> > paginacao(
			@RequestParam(name="pagina", defaultValue="0") int pagina,
			@RequestParam(name="registros", defaultValue = "10") int registros
			){
		Page<ItemPedidoDTO> pageDTO = this.itemPedidoService.paginacao(pagina, registros);
		return ResponseEntity.ok().body(pageDTO);
	}
	

}
