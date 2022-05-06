package br.org.bank.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.org.bank.entities.Cliente;
import br.org.bank.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Page<Cliente> filtrar(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}
	
	public Optional<Cliente> consultar(Long id) {
		return clienteRepository.findById(id);
	}
	
	public Cliente salvar(Cliente c) {
		return clienteRepository.save(c);
	}
	
	public Cliente editar(Long id, Cliente c) {
		c.setId(id);
		return clienteRepository.save(c);
	}
	
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
}
