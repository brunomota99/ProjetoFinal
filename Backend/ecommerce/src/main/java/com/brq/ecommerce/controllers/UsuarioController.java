package com.brq.ecommerce.controllers;


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


