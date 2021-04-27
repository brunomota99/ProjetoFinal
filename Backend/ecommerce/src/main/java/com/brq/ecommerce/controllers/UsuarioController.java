package com.brq.ecommerce.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.brq.ecommerce.dtos.UsuarioDTO;
import com.brq.ecommerce.services.UsuarioService;
import javax.validation.Valid;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("")
	public List<UsuarioDTO> findAll(){
		return this.usuarioService.findAll();
	}
  
  	@GetMapping("/{idUsuario}")
	public UsuarioDTO findOne(@PathVariable int idUsuario) {
		return this.usuarioService.findOne(idUsuario);
	}
	@PostMapping
	public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody UsuarioDTO novoUsuario) {
	  return ResponseEntity.ok().body(this.usuarioService.save(novoUsuario));
  	}
  
	@PatchMapping("/{idUsuario}")
	public ResponseEntity<UsuarioDTO> update(@Valid @PathVariable int idUsuario, @RequestBody UsuarioDTO updateUsuario) {
		return ResponseEntity.ok().body( this.usuarioService.update(idUsuario, updateUsuario));
	}
	@DeleteMapping ("/{idUsuario}")
	public void delete (@PathVariable int idUsuario){
		this.tipoUsuarioService.delete(idUsuario);
	}

}
