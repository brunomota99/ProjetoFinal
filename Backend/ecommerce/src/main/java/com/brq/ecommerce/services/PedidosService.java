package com.brq.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.repositories.PedidosRepository;

@Service
public class PedidosService {
	
	
	@Autowired
	private PedidosRepository pedidosRepository;
	
	

}
