package com.project.loteria.controller;

import java.util.List;

import com.project.loteria.model.Bilhete;
import com.project.loteria.repository.BilheteRepository;
import com.project.loteria.model.Usuario;
import com.project.loteria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bilhete")
public class BilheteController {
    @Autowired
	public BilheteRepository bilheteRepository;

	@Autowired
	public UsuarioRepository usuarioRepository;

	@GetMapping("/todos")
	public ResponseEntity<List<Bilhete>> getAll() {
		return ResponseEntity.ok(bilheteRepository.findAll());
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Bilhete> getById(@PathVariable Long id) {
		return bilheteRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
    @PostMapping
		public ResponseEntity<Bilhete> post(@RequestBody Bilhete bilhete) {
			return ResponseEntity.status(HttpStatus.CREATED).body(bilheteRepository.save(bilhete));
	}
}
