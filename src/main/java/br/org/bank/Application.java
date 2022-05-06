package br.org.bank;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.org.bank.entities.Cliente;
import br.org.bank.entities.ContaCorrente;
import br.org.bank.repositories.ClienteRepository;
import br.org.bank.repositories.ContaCorrenteRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository, ContaCorrenteRepository contaCorrenteRepository) {
		return args -> {
			Cliente c1 = new Cliente();
			c1.setCodigo("001");
			c1.setNome("João da Silva");
			c1.setCpf("610.946.370-17");
			c1.setEmail("joao@email.com");
			c1.setTelefone("1155634523");
			c1.setCep("12345678");
			c1.setEndereco("Rua Campos Salles");
			c1.setBairro("Jardim das Flores");
			c1.setNumero(11);
			c1.setMunicipio("São Paulo");
			c1.setUf("SP");
			c1.setDataNasc(new Date());
			clienteRepository.save(c1);
			
			Cliente c2 = new Cliente();
			c2.setCodigo("002");
			c2.setNome("Maria dos Santos");
			c2.setCpf("944.923.440-04");
			c2.setEmail("maria@email.com");
			c2.setTelefone("1145672234");
			c2.setCep("99999888");
			c2.setEndereco("Avenida Joaquim Barbosa");
			c2.setBairro("Jardim das Árvores");
			c2.setNumero(11);
			c2.setMunicipio("São Paulo");
			c2.setUf("SP");
			c2.setDataNasc(new Date());
			clienteRepository.save(c2);
			
			ContaCorrente cc1 = new ContaCorrente();
			cc1.setCliente(c1);
			cc1.setAgencia("1234");
			cc1.setConta("123456");
			cc1.setNomeBanco("Bradesco");
			cc1.setNumBanco(237);
			cc1.setSenha("12345678");
			contaCorrenteRepository.save(cc1);
			
			ContaCorrente cc2 = new ContaCorrente();
			cc2.setCliente(c1);
			cc2.setAgencia("9999");
			cc2.setConta("987651");
			cc2.setNomeBanco("Itaú");
			cc2.setNumBanco(341);
			cc2.setSenha("12345678");
			contaCorrenteRepository.save(cc2);
		};
	}
}
