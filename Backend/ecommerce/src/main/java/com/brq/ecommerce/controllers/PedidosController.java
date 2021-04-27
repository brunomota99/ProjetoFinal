package com.brq.ecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.brq.ecommerce.dtos.PedidosDTO;
import com.brq.ecommerce.services.PedidosService;

public class PedidosController {

	@Autowired
	private PedidosService pedidoService;
	
	@GetMapping("")
	public List<PedidosDTO> findAll(){
		return this.pedidoService.findAll();
	}
	
	@PatchMapping("{id}")
	public PedidosDTO update(@Valid @RequestBody PedidosDTO newObj, @PathVariable int id) {
		return this.pedidoService.update(id, newObj);
	}
	
}
