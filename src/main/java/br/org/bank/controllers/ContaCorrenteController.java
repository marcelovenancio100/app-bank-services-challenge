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

import br.org.bank.entities.ContaCorrente;
import br.org.bank.services.ContaCorrenteService;

@RestController
@RequestMapping("/api/v1/contaCorrente")
public class ContaCorrenteController {

	@Autowired
	private ContaCorrenteService contaCorrenteService;
	
	@PatchMapping
	public Page<ContaCorrente> filtrar(Pageable pageable) {
		return contaCorrenteService.filtrar(pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContaCorrente> consultar(@PathVariable Long id) {
		return new ResponseEntity<ContaCorrente>(contaCorrenteService.consultar(id).orElseThrow(() -> new RuntimeException("ContaCorrente não encontrado")), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ContaCorrente> incluir(@RequestBody ContaCorrente c) {
		return new ResponseEntity<ContaCorrente>(contaCorrenteService.salvar(c), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ContaCorrente> editar(@PathVariable Long id, @RequestBody ContaCorrente c) {
		return new ResponseEntity<ContaCorrente>(contaCorrenteService.editar(id, c), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		contaCorrenteService.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
