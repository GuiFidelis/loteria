package com.project.loteria.controller;

import java.util.List;

import com.project.loteria.model.Usuario;
import com.project.loteria.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	public UsuarioService usuarioService;

	@PostMapping("/cadastrar")
		public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
			Usuario usuarioCadastrado = usuarioService.cadastrar(usuario);
			return new ResponseEntity<>(usuarioCadastrado, HttpStatus.CREATED);
	}

	@PutMapping("/alterar")
	public ResponseEntity<Usuario> alterarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioAlterado = usuarioService.alterar(usuario);		
		return new ResponseEntity<Usuario>(usuarioAlterado, HttpStatus.OK);
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Usuario> deletarUsuario(@PathVariable Long id) {
		Usuario usuarioEncontrado = usuarioService.buscarPorId(id);
		if (usuarioEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			usuarioService.deletar(usuarioEncontrado);
			return new ResponseEntity<>( HttpStatus.OK);
		}
	}

	@GetMapping("/emails")
	public ResponseEntity<List< Usuario>> buscarTodosUsuarios() {
		List< Usuario> usuariosBuscados= usuarioService.buscarTodos();
		return new ResponseEntity<>(usuariosBuscados, HttpStatus.OK);
	}

}
