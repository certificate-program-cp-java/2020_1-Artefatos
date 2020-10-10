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

}