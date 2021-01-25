package com.project.loteria.service;

import java.util.List;

import com.project.loteria.error.ResourceConflictException;
import com.project.loteria.model.Bilhete;
import com.project.loteria.repository.BilheteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilheteService {
    
    @Autowired
	BilheteRepository bilheteRepository;

    public List<Bilhete> buscarTodos(){
		return bilheteRepository.findAll();
    }
    
    public Bilhete cadastrar(Bilhete bilhete) {
		Bilhete bilheteNovo = bilheteRepository.findByNumeroBilhete(bilhete.getNumeroBilhete());
		if (bilheteNovo == null) {
			return bilheteRepository.save(bilhete);
		} else {
			throw new ResourceConflictException("Já existe um bilhete com esse numero");
		}

	}
    
    public void deletar (Bilhete bilhete) {	
		bilheteRepository.delete(bilhete);
	}
	
	public Bilhete buscarPorId(long id) {
		Bilhete bilhete = bilheteRepository.findById(id);
		return bilhete;
	}
}
