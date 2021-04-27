package com.brq.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brq.ecommerce.models.PedidosModel;

@Repository
public interface PedidosRepository extends JpaRepository<PedidosModel, Integer> {

}
