package com.brq.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brq.ecommerce.models.ProdutoModel;

@Repository
public interface ProdutoRepositories extends JpaRepository<ProdutoModel, Integer>{

}