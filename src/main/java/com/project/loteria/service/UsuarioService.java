package com.project.loteria.service;

import com.project.loteria.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
	private UsuarioRepository usuarioRepository;

    public Usuario findById(Long id){
        return usuarioRepository.findById(id).get();
    }
    
}
