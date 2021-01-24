package com.project.loteria.controller;

import java.util.List;

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
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
	public UsuarioRepository usuarioRepository;

	@GetMapping("/todos")
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id) {
		return usuarioRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/email/{email}")
	    public ResponseEntity<List<Usuario>> getByeName(@PathVariable String email) {
	        return ResponseEntity.ok(usuarioRepository.findAllByEmailContainingIgnoreCase(email));
	    }
	
    @PostMapping
		public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
	}

}
