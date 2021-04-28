package com.brq.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.models.UsuarioLoginModel;
import com.brq.ecommerce.repositories.UsuarioLoginRepository;
import com.brq.ecommerce.security.CredencialSecurityModel;

@Service
public class CredentialDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioLoginRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UsuarioLoginModel usuario = this.repository.findByEmail( email );
		
		if (usuario == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new CredencialSecurityModel (usuario.getId(), usuario.getEmail(), 
				usuario.getSenha(), usuario.getNome(),  usuario.getPerfis() );
	}
}