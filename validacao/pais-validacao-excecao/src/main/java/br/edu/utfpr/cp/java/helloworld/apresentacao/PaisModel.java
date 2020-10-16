package br.edu.utfpr.cp.java.helloworld.apresentacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PaisModel {

    private String sigla;
    private Long id;
    private String nome;    


    public void setNome(String nome) {
        if (nome.length() > 15)
            throw new IllegalArgumentException("Nome maior que 15 caracteres");

        this.nome = nome;
    }

    public void setSigla(String sigla) {
        if (sigla.length() > 3) 
            throw new IllegalArgumentException("Sigla não pode ser maior que 3 caracteres");

        this.sigla = sigla;
    }
}