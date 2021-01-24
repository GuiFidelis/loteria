package com.project.loteria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.loteria.model.Bilhete;

@Repository
public interface BilheteRepository extends JpaRepository<Bilhete, Long> {
    public List<Bilhete> findAllBynumeroBilheteContainingIgnoreCase(String numerobilhete);
}