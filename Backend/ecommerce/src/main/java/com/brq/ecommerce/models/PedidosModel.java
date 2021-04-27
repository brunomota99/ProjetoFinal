package com.brq.ecommerce.models;

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
	
	
}
