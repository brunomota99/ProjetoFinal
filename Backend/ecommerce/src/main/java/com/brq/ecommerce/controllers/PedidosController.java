package com.brq.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.brq.ecommerce.dtos.PedidosDTO;
import com.brq.ecommerce.services.PedidosService;

public class PedidosController {

	@Autowired
	private PedidosService pedidoService;
	
	@GetMapping("")
	public List<PedidosDTO> findAll(){
		return this.pedidoService.findAll();
	}
	
}
