package br.edu.utfpr.cp.java.helloworld.apresentacao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaisController {

    private List<PaisModel> listaPaises;

    public PaisController() {
        listaPaises = Stream.of(
            PaisModel.builder().id(1L).nome("Brasil").sigla("BR").build(),
            PaisModel.builder().id(2L).nome("Estados Unidos").sigla("EUA").build()
        ).collect(Collectors.toList());
    }

    @GetMapping ("/pais")
    public String listar(Model memoria) {
        memoria.addAttribute("listaPaises", this.listaPaises);

        return "pais-page";
    }

    @GetMapping("/pais/apagar")
    public String apagar(@RequestParam Long id) {
        listaPaises.removeIf(paisAtual -> paisAtual.getId().equals(id));

        return "redirect:/pais";
    }

    @PostMapping("/pais/criar")
    public String criar(PaisModel pais, BindingResult result) {

        if (result.hasErrors()) {
            result.getFieldErrors().forEach(erro -> System.out.println (erro.getField() + " - " + erro.getDefaultMessage()));
            return "redirect:/pais";
        }


        pais.setId(new Long(listaPaises.size() + 1));
        listaPaises.add(pais);

        return "redirect:/pais";
    }

    @GetMapping("/pais/preparaAlterar")
    public String preparaAlterar(@RequestParam Long id, Model memoria) {

        var pais = listaPaises.stream().filter(paisAtual -> paisAtual.getId().equals(id)).findAny().get();
        memoria.addAttribute("paisAtual", pais);
        memoria.addAttribute("listaPaises", this.listaPaises);

        return "pais-page";
    }

    @PostMapping("/pais/alterar")
    public String alterar(PaisModel paisNovo) {

        var pais = listaPaises.stream().filter(paisAtual -> paisAtual.getId().equals(paisNovo.getId())).findAny().get();
        
        pais.setNome(paisNovo.getNome());
        pais.setSigla(paisNovo.getSigla());

        return "redirect:/pais";
    }
}