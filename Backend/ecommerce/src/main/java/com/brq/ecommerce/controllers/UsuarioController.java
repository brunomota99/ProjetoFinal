package com.brq.ecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brq.ecommerce.dtos.UsuarioDTO;
import com.brq.ecommerce.services.UsuarioService;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("")
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		return ResponseEntity.ok().body( this.usuarioService.findAll());
	}

	@GetMapping("/{idUsuario}")
	public ResponseEntity<UsuarioDTO> findOne(@PathVariable int idUsuario) {
		return ResponseEntity.ok().body( this.usuarioService.findOne(idUsuario));
	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody UsuarioDTO novoUsuario) {
		return ResponseEntity.ok().body(this.usuarioService.save(novoUsuario));
	}

	@PatchMapping("/{idUsuario}")
	public ResponseEntity<UsuarioDTO> update(@Valid @PathVariable int idUsuario,
			@RequestBody UsuarioDTO updateUsuario) {
		return ResponseEntity.ok().body(this.usuarioService.update(idUsuario, updateUsuario));
	}

	@DeleteMapping("/{idUsuario}")
	public void delete(@PathVariable int idUsuario) {
		this.usuarioService.delete(idUsuario);
	}

	@DeleteMapping("many/{idUsuario}")
	public void deleteMany(@PathVariable int[] id) {

		this.usuarioService.deleteMany(id);
	}

	// Paginacao Alunos
	@GetMapping("paginacao")
	public ResponseEntity<Page<UsuarioDTO>> paginacao(@RequestParam(name = "pagina", defaultValue = "0") int pagina,
			@RequestParam(name = "registros", defaultValue = "10") int registros) {
		return ResponseEntity.ok().body(this.usuarioService.paginacao(pagina, registros));
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<UsuarioDTO>> findByNome(@PathVariable String nome) {
		return ResponseEntity.ok().body(this.usuarioService.findByNome(nome));
	}

	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<List<UsuarioDTO>> findByCpf(@PathVariable String cpf) {
		return ResponseEntity.ok().body(this.usuarioService.findByCpf(cpf));
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<List<UsuarioDTO>> findByEmail(@PathVariable String email) {
		return ResponseEntity.ok().body(this.usuarioService.findByEmail(email));
	}
}
