package com.project.loteria.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@ToString(exclude="id")
public class Usuario {
    
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter private long id;

    @NotNull
    @Column
    @Email
    @NotEmpty
    @Getter @Setter private String email;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Bilhete> bilhete;

}
