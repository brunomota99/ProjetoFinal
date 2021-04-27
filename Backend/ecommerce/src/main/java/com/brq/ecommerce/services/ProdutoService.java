package com.brq.ecommerce.services;

import org.springframework.stereotype.Service;

import com.brq.ecommerce.dtos.ProdutosDto;
import com.brq.ecommerce.repositories.ProdutoRepositories;

@Service
public class ProdutoService {
	private ProdutoRepositories repository;
	
	// Save
	public ProdutosDto save(ProdutosDto novo) {
		return this.repository.save(novo.toEntity()).toDTO();
	}
}