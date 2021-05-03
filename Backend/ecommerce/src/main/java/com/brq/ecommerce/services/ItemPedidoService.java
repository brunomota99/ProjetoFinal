package com.brq.ecommerce.services;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.dtos.ItemPedidoDTO;
import com.brq.ecommerce.dtos.ItemPedidoNewDTO;
import com.brq.ecommerce.models.ItemPedidoModel;
import com.brq.ecommerce.models.PedidoModel;
import com.brq.ecommerce.models.ProdutoModel;
import com.brq.ecommerce.repositories.ItemPedidoRepository;
import com.brq.ecommerce.repositories.PedidoRepository;
import com.brq.ecommerce.repositories.ProdutoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public ItemPedidoDTO save(ItemPedidoNewDTO newItemPedido) {
		int idProd = newItemPedido.getProduto().getIdProd();
		int idPed = newItemPedido.getPedido().getIdPedido();
		
		Optional<ProdutoModel> objProd = this.produtoRepository.findById(idProd);
		Optional<PedidoModel> objPed = this.pedidoRepository.findById(idPed);
		
		if(objProd.isPresent() && objPed.isPresent()) {
			double preco = newItemPedido.getProduto().getPrecoUnitProd();
			
			ItemPedidoModel model = newItemPedido.toEntity();
			
			model.setPrecoItemPedido(preco);
			model.setProduto(objProd.get());
			model.setPedido(objPed.get());
			
			return this.itemPedidoRepository.save(model).toDto();
		} else {
			return null;
		}
	}
  
	public List<ItemPedidoDTO> findAll(){
		List<ItemPedidoModel> list = this.itemPedidoRepository.findAll();
		return list.stream().map(x -> x.toDto()).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public void delete(int idItemPedido) {
		this.itemPedidoRepository.deleteById(idItemPedido);
	}
	
	public Page<ItemPedidoDTO> paginacao(int pagina, int registros){
		PageRequest pageRequest = PageRequest.of(pagina, registros);
		Page<ItemPedidoModel> pageModel = this.itemPedidoRepository.findAll(pageRequest);
		
		Page<ItemPedidoDTO> pageDTO = pageModel.map(
				new Function<ItemPedidoModel, ItemPedidoDTO>(){
					public ItemPedidoDTO apply(ItemPedidoModel model) {
						return model.toDto();
					}
				}
				);			
		return pageDTO;
	}

	public ItemPedidoDTO finOne(int itemPedido) {
		return this.itemPedidoRepository.findById(itemPedido).get().toDto();
	}
	
	public ItemPedidoDTO update(int id, ItemPedidoDTO newObj) {
		Optional<ItemPedidoModel> optObj = this.itemPedidoRepository.findById(id);
		
		if (optObj.isPresent()) {
			ItemPedidoModel obj = optObj.get();
			
			obj.setQtdeItemPedido(newObj.getQtdeItemPedido());
			
			/*Nesse caso a alteração de preços é automatizada. (preçoItem * quantidadeItem)
			 * Guilherme Pessoa, grupo Azul Claro
			 */
			return this.itemPedidoRepository.save(obj).toDto();
		}else {
			throw new RuntimeException("Pedido não encontrado");
		}

	}
}
