package com.brq.ecommerce.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.brq.ecommerce.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
  
	List<UsuarioModel> findByNomeUsuarioContains(String nome);

	List<UsuarioModel> findByCpfUsuarioContains(String cpf);

	List<UsuarioModel> findByEmailUsuarioContains(String email);

}