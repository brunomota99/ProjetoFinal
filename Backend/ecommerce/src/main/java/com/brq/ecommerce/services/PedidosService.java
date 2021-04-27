package com.brq.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.dtos.PedidosDTO;
import com.brq.ecommerce.models.PedidosModel;
import com.brq.ecommerce.repositories.PedidosRepository;

@Service
public class PedidosService {
	
	
	@Autowired
	private PedidosRepository pedidosRepository;
	
	public List<PedidosDTO> findAll(){
		List<PedidosModel> list = this.pedidosRepository.findAll();
		
		return list.stream()
				.map(x -> x.toDto())
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public PedidosDTO update (int id, PedidosDTO newObj) {
		Optional<PedidosModel> optObj = this.pedidosRepository.findById(id);
		
		if(optObj.isPresent()) {
			PedidosModel objFromDatabase = optObj.get();
			
			objFromDatabase.setDataPedido(newObj.getDataPedido());
			objFromDatabase.setIdPedido(newObj.getIdPedido());
			objFromDatabase.setIdUsuario(newObj.getIdUsuario());
			objFromDatabase.setTotalPedido(newObj.getTotalPedido());
			
			return this.pedidosRepository.save(objFromDatabase).toDto();
			
		}
		
		else {
			throw new RuntimeException("Pedido não encontrado");
		}
	}
}
