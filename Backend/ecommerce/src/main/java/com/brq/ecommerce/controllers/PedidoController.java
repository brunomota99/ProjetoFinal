package com.brq.ecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.ecommerce.dtos.PedidoDTO;
import com.brq.ecommerce.services.PedidoService;

@RequestMapping("pedidos")
@RestController
@CrossOrigin(origins = "*")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("")
	public List<PedidoDTO> findAll(){
		return this.pedidoService.findAll();
	}
	
	
	@PostMapping("")
	private ResponseEntity<PedidoDTO> save(@RequestBody @Valid PedidoDTO newPedido){
		return ResponseEntity.ok().body(this.pedidoService.save(newPedido));
	}	
	


	@PatchMapping("/{idPedido}")
	public ResponseEntity<PedidoDTO> update(@Valid @RequestBody PedidoDTO newObj, @PathVariable int idPedido) {
		return ResponseEntity.ok().body(this.pedidoService.update(idPedido, newObj));

	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		this.pedidoService.delete(id);
	}
	

}
