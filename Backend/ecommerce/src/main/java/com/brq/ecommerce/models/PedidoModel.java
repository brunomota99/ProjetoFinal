package com.brq.ecommerce.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.modelmapper.ModelMapper;

import com.brq.ecommerce.dtos.PedidoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tab_pedido")
public class PedidoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_seq")
	@SequenceGenerator(name = "pedido_seq", sequenceName = "pedido_seq", allocationSize = 1)
	@Column(name = "id_pedido")
	private Integer idPedido;

	@Column(name = "data_pedido")
	@CreationTimestamp
	private LocalDateTime dataPedido;

	@Column(name = "total_pedido")
	private Double totalPedido;	

	public PedidoDTO toDto() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, PedidoDTO.class);
	}
}