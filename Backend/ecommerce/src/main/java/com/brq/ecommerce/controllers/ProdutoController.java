package com.brq.ecommerce.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.ecommerce.dtos.ProdutoDto;
import com.brq.ecommerce.services.ProdutoService;

public class ProdutoController {
	
	@Autowired
	private ProdutoService service;

	// Excluir registro do banco
	@DeleteMapping("/{idprod}")
	public void delete(@PathVariable int id_prod) {
		this.service.delete(id_prod);
	}
	
	//Save
	@PostMapping("")
	public ProdutoDto save(@RequestBody ProdutoDto novo) {
		return this.service.save(novo);
	}

}
