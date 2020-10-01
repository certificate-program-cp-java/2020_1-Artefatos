package br.edu.utfpr.cp.java.helloworld.apresentacao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;

@Controller
public class PaisController {

    private List<PaisModel> listaPaises;

    public PaisController() {
        listaPaises = Stream.of(
            PaisModel.builder().id(1L).nome("Brasil").sigla("BR").build(),
            PaisModel.builder().id(2L).nome("Estados Unidos").sigla("EUA").build()
        ).collect(Collectors.toList());
    }
}