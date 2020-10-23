package br.edu.utfpr.cp.java.helloworld.apresentacao;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Controller
@Log
@RequiredArgsConstructor
public class PaisController {

    private final PaisRepository paisRepository;

    private void adicionaListaPaisesNaMemoria(Model memoria) {
        memoria.addAttribute("listaPaises", paisRepository.findAll());
    }

    @GetMapping ("/pais")
    public String listar(Model memoria) {
        this.adicionaListaPaisesNaMemoria(memoria);

        return "pais-page";
    }

    @GetMapping("/pais/apagar")
    public String apagar(@RequestParam Long id) {
        // listaPaises.removeIf(paisAtual -> paisAtual.getId().equals(id));

        return "redirect:/pais";
    }

    @PostMapping("/pais/criar")
    public String criar(@Valid PaisModel pais, BindingResult result, Model memoria) {

        if (result.hasErrors()) {
            result.getFieldErrors().forEach(erro -> memoria.addAttribute(erro.getField(), erro.getDefaultMessage()));

            this.adicionaListaPaisesNaMemoria(memoria);
            memoria.addAttribute("paisAtual", pais);

            return "pais-page";
        }

        paisRepository.save(pais);

        return "redirect:/pais";
    }

    @GetMapping("/pais/preparaAlterar")
    public String preparaAlterar(@RequestParam Long id, Model memoria) {

        // var pais = listaPaises.stream().filter(paisAtual -> paisAtual.getId().equals(id)).findAny().get();
        
        this.adicionaListaPaisesNaMemoria(memoria);

        // memoria.addAttribute("paisAtual", pais);
        memoria.addAttribute("alterar", true);

        return "pais-page";
    }

    @PostMapping("/pais/alterar")
    public String alterar(PaisModel paisNovo) {

        // var pais = listaPaises.stream().filter(paisAtual -> paisAtual.getId().equals(paisNovo.getId())).findAny().get();
        
        // pais.setNome(paisNovo.getNome());
        // pais.setSigla(paisNovo.getSigla());

        return "redirect:/pais";
    }
}