package com.brq.ecommerce.services;

import com.brq.ecommerce.dtos.UsuarioDTO;
import com.brq.ecommerce.models.UsuarioModel;
import com.brq.ecommerce.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioDTO> findAll() {
		List<UsuarioModel> list = this.usuarioRepository.findAll();
		return list.stream().map(x -> x.toDTO()).collect(Collectors.toCollection(ArrayList::new));
	}

	public UsuarioDTO findOne(int idUsuario) {
		return this.usuarioRepository.findById(idUsuario)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado!")).toDTO();
	}

	public UsuarioDTO update(int idUsuario, UsuarioDTO updateUsuario) {
		Optional<UsuarioModel> usuarioOptional = this.usuarioRepository.findById(idUsuario);
		if (usuarioOptional.isPresent()) {
			UsuarioModel usuarioExistente = usuarioOptional.get();
			usuarioExistente.setNomeUsuario(updateUsuario.getNomeUsuario());
			usuarioExistente.setCpfUsuario(updateUsuario.getCpfUsuario());
			usuarioExistente.setEmailUsuario(updateUsuario.getEmailUsuario());
			usuarioExistente.setTelefoneUsuario(updateUsuario.getTelefoneUsuario());
			usuarioExistente.setSenhaUsuario(updateUsuario.getSenhaUsuario());

			return this.usuarioRepository.save(usuarioExistente).toDTO();
		} else {
			throw new RuntimeException("Usuario(a) nao encontrado(a)");
		}

	}

	public UsuarioDTO save(UsuarioDTO novoUsuario) {
		return this.usuarioRepository.save(novoUsuario.toEntity()).toDTO();
	}

	public void delete(int id) {
		this.usuarioRepository.deleteById(id);
	}

	// deletar multiplos
	public void deleteMany(int[] ids) {
		for (int i : ids) {
			this.usuarioRepository.deleteById(i);
		}
	}

}
