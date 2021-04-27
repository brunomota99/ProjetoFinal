package com.brq.ecommerce.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.brq.ecommerce.dtos.PedidosDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity


@Table(name="tab_pedido")
public class PedidosModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="pedido_seq")
	@SequenceGenerator(name = "pedido_seq", sequenceName = "pedido_seq", allocationSize = 1)
	@Column(name = "id_pedido")
	private Integer idPedido;
	
	@Column(name="data_pedido")
	private LocalDateTime dataPedido;
	
	@Column(name="total_pedido")
	private Double totalPedido;
	
	@Column(name="id_usuario")
	private Integer idUsuario;
	
	public PedidosDTO toDto() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, PedidosDTO.class);
	}
}

