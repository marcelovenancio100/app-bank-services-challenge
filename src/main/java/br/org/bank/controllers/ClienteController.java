package br.org.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.org.bank.entities.Cliente;
import br.org.bank.services.ClienteService;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PatchMapping
	public Page<Cliente> filtrar(Pageable pageable) {
		return clienteService.filtrar(pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> consultar(@PathVariable Long id) {
		return new ResponseEntity<Cliente>(clienteService.consultar(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado")), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> incluir(@RequestBody Cliente c) {
		return new ResponseEntity<Cliente>(clienteService.salvar(c), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> editar(@PathVariable Long id, @RequestBody Cliente c) {
		return new ResponseEntity<Cliente>(clienteService.editar(id, c), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		clienteService.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}