package com.project.loteria.service;

import java.util.List;

import com.project.loteria.error.ResourceConflictException;
import com.project.loteria.error.ResourceNotFoundException;
import com.project.loteria.model.Usuario;
import com.project.loteria.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario cadastrar(Usuario usuario) {
		Usuario userNovo = usuarioRepository.findByEmail(usuario.getEmail());
		if (userNovo == null) {
			return usuarioRepository.save(usuario);
		} else {
			throw new ResourceConflictException("Já existe um usuario com esse email!");
		}

	}

	public Usuario alterar(Usuario usuario) {
		Usuario userAlteracao = usuarioRepository.findById(usuario.getId());
		Usuario userNovo = usuarioRepository.findByEmail(usuario.getEmail());

		if (userAlteracao != null && userNovo == null) {
			return usuarioRepository.save(usuario);
		} else {
			if (userAlteracao == null){
				throw new ResourceNotFoundException("Id não encontrado");
			}else{
				throw new ResourceConflictException("Já existe um usuario com esse email!");
			}
			
		}
	}

	public void deletar (Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	public Usuario buscarPorId(long id) {
		Usuario usuarioId = usuarioRepository.findById(id);
		return usuarioId;
	}

	public Usuario buscarPorEmail(String email) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		return usuario;
	}

	public List< Usuario> buscarTodos(){
		return usuarioRepository.findAll();
	}

	

}
