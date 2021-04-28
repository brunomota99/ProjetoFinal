package com.brq.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brq.ecommerce.models.UsuarioModel;
import com.brq.ecommerce.repositories.UsuarioRepository;
import com.brq.ecommerce.security.CredencialSecurityModel;

@Service
public class CredentialDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UsuarioModel usuario = this.usuarioRepository.findByEmail( email );
		
		if (usuario == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new CredencialSecurityModel (usuario.getId(), usuario.getEmail(), 
				usuario.getSenha(), usuario.getNome(),  usuario.getPerfis() );
	}
}