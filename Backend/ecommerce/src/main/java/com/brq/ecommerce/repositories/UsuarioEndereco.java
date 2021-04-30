package com.brq.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.brq.ecommerce.models.UsuarioEnderecoModel;

public interface UsuarioEndereco extends JpaRepository<UsuarioEnderecoModel, Integer> {
	
	@Transactional
	List<UsuarioEnderecoModel> findById(int usuarioId);

}
