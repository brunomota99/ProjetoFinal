package com.brq.ecommerce.controllers;

import java.util.List;

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

import com.brq.ecommerce.dtos.EnderecoDTO;
import com.brq.ecommerce.services.EnderecoService;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("")
	public ResponseEntity<List<EnderecoDTO>> getAll(){

		return ResponseEntity.ok().body(this.enderecoService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity< EnderecoDTO > findOne( @PathVariable("id") int id  ) {
		
		return ResponseEntity.ok().body( this.enderecoService.findOne(id) );						
	}
	
	
	@PostMapping("")
	public EnderecoDTO save(@RequestBody EnderecoDTO enderecoDTO) {
		return this.enderecoService.save(enderecoDTO);
	}
	
	
	@PatchMapping("/{id}")
	public ResponseEntity<EnderecoDTO> update (@PathVariable int id, @RequestBody EnderecoDTO attEndereco)
	{
		return ResponseEntity.ok(this.enderecoService.update(id, attEndereco));
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		
		this.enderecoService.delete(id);
	}
	
	@DeleteMapping("many/{id}")
	public void deleteMany(@PathVariable int[] id) {
		
		this.enderecoService.deleteMany(id);
}
	
	

}
