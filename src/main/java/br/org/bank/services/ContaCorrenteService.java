package br.org.bank.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.org.bank.entities.ContaCorrente;
import br.org.bank.repositories.ContaCorrenteRepository;

@Service
public class ContaCorrenteService {

	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;
	
	public Page<ContaCorrente> filtrar(Pageable pageable) {
		return contaCorrenteRepository.findAll(pageable);
	}
	
	public Optional<ContaCorrente> consultar(Long id) {
		return contaCorrenteRepository.findById(id);
	}
	
	public ContaCorrente salvar(ContaCorrente c) {
		return contaCorrenteRepository.save(c);
	}
	
	public ContaCorrente editar(Long id, ContaCorrente c) {
		c.setId(id);
		return contaCorrenteRepository.save(c);
	}
	
	public void excluir(Long id) {
		contaCorrenteRepository.deleteById(id);
	}
}
