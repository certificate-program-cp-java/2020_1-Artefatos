package br.edu.utfpr.cp.java.helloworld.apresentacao;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PaisModel {

    @Size (min = 2, max = 3, message = "A sigla deve ter entre 2 e 3 caracteres")
    private String sigla;

    private Long id;

    @Size (min = 3, max = 15, message = "O nome do país deve ter entre 3 e 15 caracteres")
    private String nome;    
}