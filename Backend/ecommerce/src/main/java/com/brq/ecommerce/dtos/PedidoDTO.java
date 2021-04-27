package com.brq.ecommerce.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.brq.ecommerce.models.PedidosModel;

import lombok.Data;

@Data
public class PedidoDTO {
	
	@NotNull
	private Integer idPedido;
	@NotNull
	private LocalDateTime dataPedido;
	@NotNull
	private Double totalPedido;
	@NotNull
	private Integer idUsuario;
	
	public PedidosModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, PedidosModel.class);
	}
	
	
}
