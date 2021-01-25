package com.project.loteria.model;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "bilhete")
@Getter @Setter
@NoArgsConstructor
@ToString(exclude="id")    
public class Bilhete {
    
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column
    private String numeroBilhete = generatedSequence();

    @Temporal(TemporalType.TIMESTAMP)
    private Date data = new java.sql.Date(System.currentTimeMillis());

    private String generatedSequence() {
        Integer valor;
        String valorFinal;
        Random code = new Random();
        valor = code.nextInt(10000000 - 1);
        valorFinal = String.valueOf(valor);
        return valorFinal;
    }

    @ManyToOne
	@JsonIgnoreProperties("bilhete")
	private Usuario usuario;
}
