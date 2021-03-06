package br.com.milhas.controller;

import br.com.milhas.model.Cliente;
import br.com.milhas.repository.ClienteRepository;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping({"/clientes"})
public class ClienteController {
	
	private ClienteRepository repository;
	
	ClienteController(ClienteRepository clienteRepository) {
		this.repository = clienteRepository;
	}
	
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Cliente> findById(@PathVariable long id) {
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Cliente create(@RequestBody @Valid Cliente cliente) {
		return repository.save(cliente);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Cliente> update(@PathVariable("id") long id,
			@RequestBody Cliente cliente) {
		return repository.findById(id)
				.map(record -> {
						record.setNome(cliente.getNome());
						record.setCpf(cliente.getCpf());
						record.setEmail(cliente.getEmail());
						record.setTelefone(cliente.getTelefone());
						Cliente updated = repository.save(record);
						return ResponseEntity.ok().body(updated);
						}).orElse(ResponseEntity.notFound().build());
	}
	@DeleteMapping(path={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		return repository.findById(id)
				.map(record -> {
					repository.deleteById(id);
					return ResponseEntity.ok().build();
						}).orElse(ResponseEntity.notFound().build());
	}

}
