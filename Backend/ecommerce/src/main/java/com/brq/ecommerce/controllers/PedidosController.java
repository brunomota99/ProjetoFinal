package com.brq.ecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.ecommerce.dtos.PedidosDTO;
import com.brq.ecommerce.services.PedidosService;

@RequestMapping("pedidos")
@RestController
@CrossOrigin(origins = "*")
public class PedidosController {

	@Autowired
	private PedidosService pedidoService;
	
	@GetMapping("")
	public List<PedidosDTO> findAll(){
		return this.pedidoService.findAll();
	}
	
	
	@PostMapping("")
	private ResponseEntity<PedidosDTO> save(PedidosDTO newPedido){
		return ResponseEntity.ok().body(this.pedidoService.save(newPedido));
	}	
	

	@PatchMapping("{id}")
	public PedidosDTO update(@Valid @RequestBody PedidosDTO newObj, @PathVariable int id) {
		return this.pedidoService.update(id, newObj);
	}
	

}
