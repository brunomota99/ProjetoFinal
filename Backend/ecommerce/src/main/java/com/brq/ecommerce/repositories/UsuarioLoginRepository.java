package com.brq.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brq.ecommerce.models.UsuarioLoginModel;

@Repository
public interface UsuarioLoginRepository extends JpaRepository<UsuarioLoginModel, Integer>{
	public UsuarioLoginModel findByEmail(String email);
}