package com.brq.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.dtos.EnderecoDTO;
import com.brq.ecommerce.models.EnderecoModel;
import com.brq.ecommerce.repositories.EnderecoRepository;


@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<EnderecoDTO> getAll(){
		
		List<EnderecoModel> list = this.enderecoRepository.findAll();
		
		return list.stream()
	            .map( x -> x.toDto() )
	            .collect(Collectors.toCollection(ArrayList::new));
		
		
	}

}
