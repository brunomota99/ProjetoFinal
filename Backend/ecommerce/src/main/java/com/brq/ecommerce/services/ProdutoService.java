package com.brq.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.dtos.ProdutoDto;
import com.brq.ecommerce.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;

	public void delete(int id) {
				
		this.repository.deleteById(id);

	}
	
	public ProdutoDto save(ProdutoDto novo) {
		return this.repository.save(novo.toEntity()).toDTO();
	}

}
