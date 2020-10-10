package br.edu.utfpr.cp.java.helloworld.apresentacao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping ("/list")
    public String listar(Model memoria) {
        memoria.addAttribute("listaPaises", this.listaPaises);

        return "pais-page";
    }

    @GetMapping("/delete")
    public String deletar(@RequestParam Long id) {
        listaPaises.removeIf(paisAtual -> paisAtual.getId().equals(id));

        return "redirect:/list";
    }

    @PostMapping("/create")
    public String create(PaisModel pais) {

        pais.setId(new Long(listaPaises.size() + 1));
        listaPaises.add(pais);

        return "redirect:/list";
    }

    @GetMapping("/prepareUpdate")
    public String preparaAlterar(@RequestParam Long id, Model memoria) {

        var pais = listaPaises.stream().filter(paisAtual -> paisAtual.getId().equals(id)).findAny().get();
        memoria.addAttribute("paisAtual", pais);
        memoria.addAttribute("listaPaises", this.listaPaises);

        return "pais-page";
    }

    @PostMapping("/update")
    public String update(PaisModel paisNovo) {

        var pais = listaPaises.stream().filter(paisAtual -> paisAtual.getId().equals(paisNovo.getId())).findAny().get();
        
        pais.setNome(paisNovo.getNome());
        pais.setSigla(paisNovo.getSigla());

        return "redirect:/list";
    }
}