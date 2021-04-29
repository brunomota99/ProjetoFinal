package com.brq.ecommerce.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.brq.ecommerce.dtos.ProdutoDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tab_produto")
public class ProdutoModel {
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator="produto_seq_generator")
	@SequenceGenerator(name="produto_seq_generator", sequenceName="produto_seq", allocationSize = 1)
	@Column(name = "id_prod")
	private int idProd;
	@Column(name = "nome_prod")
	private String nomeProd;
	@Column(name = "preco_unit_prod")
	private double precoUnitProd;
	@Column(name = "qtde_estoque_prod")
	private int qtdeEstoqueProd;

	public ProdutoDto toDTO() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, ProdutoDto.class);
	}
}