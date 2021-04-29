package com.brq.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brq.ecommerce.models.ItemPedidoModel;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedidoModel, Integer> {

	
}
