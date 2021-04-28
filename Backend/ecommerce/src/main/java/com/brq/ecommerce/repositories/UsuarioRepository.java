package com.brq.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brq.ecommerce.models.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer>{
	public UsuarioModel findByEmail(String email);
}