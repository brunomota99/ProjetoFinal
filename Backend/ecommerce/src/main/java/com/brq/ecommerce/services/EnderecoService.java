package com.brq.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.dtos.EnderecoDTO;
import com.brq.ecommerce.dtos.EnderecoNewDTO;
import com.brq.ecommerce.models.EnderecoModel;
import com.brq.ecommerce.models.UsuarioModel;
import com.brq.ecommerce.repositories.EnderecoRepository;
import com.brq.ecommerce.repositories.UsuarioRepository;


@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<EnderecoDTO> getAll(){
		
		List<EnderecoModel> list = this.enderecoRepository.findAll();
		
		return list.stream()
	            .map( x -> x.toDto() )
	            .collect(Collectors.toCollection(ArrayList::new));
		
		
	}
	
	public EnderecoDTO findOne(int id) {
		return this.enderecoRepository.findById(id)
				.orElseThrow( () -> new RuntimeException("Endereco não encontrado")  ).toDto();
	}
	
	public EnderecoDTO save(EnderecoNewDTO newEndereco) {
		int idUsuario = newEndereco.getUsuario().getIdUsuario();
		Optional<UsuarioModel> optObj = this.usuarioRepository.findById(idUsuario);
		
		if(optObj.isPresent()) {
			EnderecoModel model = newEndereco.toEntity();
			model.setUsuario(optObj.get());
			
			return this.enderecoRepository.save(model).toDto();
		}else {
			// Descomentar quando o tratamento de erro estiver pronto
			//throw new ObjetoNaoEncontradoException("Usuário não encontrado");
			return null; // Apagar depois do trat. de erro
		}
	}
	
	public EnderecoDTO update(int id, EnderecoDTO attEndereco)

	{						
		Optional<EnderecoModel> endereco = this.enderecoRepository.findById(id);
		if(endereco.isPresent())
		{
			EnderecoModel obj = endereco.get();
			obj.setLogradouro(attEndereco.getLogradouro());
			obj.setCep(attEndereco.getCep());
			obj.setEstado(attEndereco.getEstado());
			obj.setNumero(attEndereco.getNumero());
			obj.setComplemento(attEndereco.getComplemento());
			obj.setCidade(attEndereco.getCidade());
			return this.enderecoRepository.save(obj).toDto();
		}else
		{
			throw new RuntimeException("Aluno não encontrada");
		}
		
	}
	
		
	public void delete(int id) {
		this.enderecoRepository.deleteById(id);
	}	
	
	public void deleteMany(int[] ids) {
		for (int i : ids) {
			this.enderecoRepository.deleteById(i);
		}

	}
}
