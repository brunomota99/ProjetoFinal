package com.brq.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.dtos.PedidoDTO;
import com.brq.ecommerce.dtos.PedidoDTOIn;
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

	public PedidoDTO save(PedidoDTOIn newPedido) {
		return this.pedidosRepository.save(newPedido.toEntity()).toDto();
	}

	public PedidoDTO finOne(int idPedido) {
		return this.pedidosRepository.findById(idPedido).get().toDto();
	}

	public void delete(int idPedido) {
		this.pedidosRepository.deleteById(idPedido);
	}

	public PedidoDTO update(int id, PedidoDTOIn newObj) {
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
	
	public Page<PedidoDTO> paginacao(int pagina, int registros) {
		PageRequest pageRequest = PageRequest.of(pagina, registros);
		// later.. add a new parameter to search for user name the orders
		
		Page<PedidoModel> pageModel = this.pedidosRepository.findAll(pageRequest);
		
		Page<PedidoDTO> pageDTO = pageModel.map(
				new Function<PedidoModel, PedidoDTO>(){
					public PedidoDTO apply(PedidoModel model) {
						return model.toDto();
					}
				}
			);		
		return pageDTO;
	}
}
