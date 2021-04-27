package com.brq.ecommerce.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.brq.ecommerce.dtos.EnderecoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tab_endereco")
public class EnderecoModel {
	
	@Id
	@SequenceGenerator(name="endereco", sequenceName="endereco_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="endereco")
	@Column(name="id_end")
	private int id;
	
	@Column(name="logradouro_end")
	private String logradouro;
	
	@Column(name="numero_end")
	private String numero;
	
	@Column(name="complemento_end")
	private String complemento;
	
	@Column(name="cep_end ")
	private String cep;
	
	@Column(name="cidade_end")
	private String cidade;
	
	@Column(name="estado_end")
	private String estado;
	 
	// private Aluno aluno   {
	
	public EnderecoDTO toDto() {
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper.map(this, EnderecoDTO.class);
	}
	
}
