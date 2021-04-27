package com.brq.ecommerce.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ProdutoController {
	
	private Object produtoService;

	// Excluir registro do banco
	@DeleteMapping("/{idprod}")
	public void delete(@PathVariable int id_prod) {
		((ProdutoController) this.produtoService).delete(id_prod);
	}

}
