package com.brq.ecommerce.dtos;

import javax.validation.constraints.NotBlank;
import org.modelmapper.ModelMapper;
import com.brq.ecommerce.models.UsuarioModel;
import lombok.Data;

@Data
public class UsuarioDTO {

	private int idUsuario;

	@NotBlank(message = "Nome deve ser preenchido")
	private String nomeUsuario;

	@NotBlank(message = "CPF deve ser preenchido")
	private String cpfUsuario;

	@NotBlank(message = "Email deve ser preenchido")
	private String emailUsuario;

	@NotBlank(message = "Telefone deve ser preenchido")
	private String telefoneUsuario;

	@NotBlank(message = "Senha deve ser preenchido")
	private String senhaUsuario;

	public UsuarioModel toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, UsuarioModel.class);
	}

}
