package com.brq.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.ecommerce.dtos.ProdutosDto;
import com.brq.ecommerce.services.ProdutoService;

@RequestMapping("produtos")
@RestController
@CrossOrigin(origins = "*")
public class ProdutosController {
	@Autowired
	private ProdutoService service;
	
	//Save
	@PostMapping("")
	public ProdutosDto save(@RequestBody ProdutosDto novo) {
		return this.service.save(novo);
	}
}