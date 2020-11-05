package br.edu.utfpr.cp.java.helloworld.usuario;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Usuario implements Serializable {

    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String senha;

    @ElementCollection (fetch = FetchType.EAGER)
    private List<String> papeis;
}