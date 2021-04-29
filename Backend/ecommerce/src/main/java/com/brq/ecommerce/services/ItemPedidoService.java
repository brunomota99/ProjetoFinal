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
import com.brq.ecommerce.models.ItemPedidoModel;
import com.brq.ecommerce.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public ItemPedidoDTO save(ItemPedidoDTO newItemPedido) {		
		Double valorItem = 10.0;
		newItemPedido.setPrecoItemPedido(valorItem);
		/*
		 *  Trocar o código acima pelo preço do produto que virá da tabela produto.
		 *  Lembrando que que o preço do tab_item_pedido é a soma do preço da quantidade de produtos que esse item terá.
		 *  O código ficará mais ou menos assim:
		 * Produto = produto = (funcaoFindById) ou outra.
		 * Double valorItem = produto.getPrice() * newItemPedido.getQtdeItemPedido();
		 * newItemPedido.setPrecoItemPedido(valorItem);
		 * 
		 * Antes de salvar: Chamar outra funcao, neste serviço ou no serviço do produto para checar se tem produto em estoque.
		 * No angular: Checar se o produto está indisponível e não exibir como opção de compra ou somente a quantidade desejada.
		 * Fabio Alves From Grupo Azul Claro
		 */	
		
		return this.itemPedidoRepository.save(newItemPedido.toEntity()).toDto();
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
