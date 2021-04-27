package com.brq.ecommerce.controllers;

<<<<<<< HEAD

import com.brq.ecommerce.dtos.UsuarioDTO;
import com.brq.ecommerce.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("usuarios")
@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PatchMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDTO> update(@Valid @PathVariable int idUsuario, @RequestBody UsuarioDTO updateUsuario) {

        return ResponseEntity.ok().body( this.usuarioService.update(idUsuario, updateUsuario));
    }
}


=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.ecommerce.dtos.UsuarioDTO;
import com.brq.ecommerce.services.UsuarioService;


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

}
>>>>>>> a1da7034a2d0a9943994971a827bd03a8df85d98
