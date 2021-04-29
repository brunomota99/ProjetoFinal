package com.brq.ecommerce.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tab_endereco")
public class UsuarioEnderecoModel {
	
	@Id
	private int id;
	
	@Column(name = "id_end")	
	private int endId;
	
	@Column (name = "id_usuario")
	private int usuarioId;

}
