package com.brq.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.dtos.PedidoDTO;
import com.brq.ecommerce.models.PedidoModel;
import com.brq.ecommerce.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidosRepository;

	public List<PedidoDTO> findAll() {
		List<PedidoModel> list = this.pedidosRepository.findAll();

		return list.stream().map(x -> x.toDto()).collect(Collectors.toCollection(ArrayList::new));
	}

	public PedidoDTO save(PedidoDTO newPedido) {
		return this.pedidosRepository.save(newPedido.toEntity()).toDto();
	}

	public PedidoDTO finOne(int idPedido) {
		return this.pedidosRepository.findById(idPedido).get().toDto();
	}

	public void delete(int idPedido) {
		this.pedidosRepository.deleteById(idPedido);
	}

	public PedidoDTO update(int id, PedidoDTO newObj) {
		Optional<PedidoModel> optObj = this.pedidosRepository.findById(id);

		if (optObj.isPresent()) {
			PedidoModel objFromDatabase = optObj.get();			

			objFromDatabase.setTotalPedido(newObj.getTotalPedido());

			return this.pedidosRepository.save(objFromDatabase).toDto();
		}

		else {
			throw new RuntimeException("Pedido não encontrado");
		}
		//change later
	}
}
