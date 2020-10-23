package br.edu.utfpr.cp.java.helloworld.apresentacao;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.utfpr.cp.java.helloworld.entidade.PaisModel;
import br.edu.utfpr.cp.java.helloworld.excecao.PaisJaExisteException;
import br.edu.utfpr.cp.java.helloworld.negocio.PaisNegocio;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Controller
@Log
@RequiredArgsConstructor
public class PaisController {

    private final PaisNegocio paisNegocio;

    private void adicionaListaPaisesNaMemoria(Model memoria) {
        memoria.addAttribute("listaPaises", paisNegocio.findAll());
    }

    @GetMapping("/pais")
    public String listar(Model memoria) {
        this.adicionaListaPaisesNaMemoria(memoria);

        return "pais-page";
    }

    @GetMapping("/pais/apagar")
    public String apagar(@RequestParam Long id) {
        paisNegocio.deleteById(id);

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

        try {
            paisNegocio.criar(pais);

        } catch (PaisJaExisteException e) {
            log.info(e.getMessage());
        }
        
        return "redirect:/pais";
    }

    @GetMapping("/pais/preparaAlterar")
    public String preparaAlterar(@RequestParam Long id, Model memoria) {

        var pais = paisNegocio.findById(id).get();
        
        this.adicionaListaPaisesNaMemoria(memoria);

        memoria.addAttribute("paisAtual", pais);
        memoria.addAttribute("alterar", true);

        return "pais-page";
    }

    @PostMapping("/pais/alterar")
    public String alterar(PaisModel paisNovo) {

        var pais = paisNegocio.findById(paisNovo.getId()).get();
        
        pais.setNome(paisNovo.getNome());
        pais.setSigla(paisNovo.getSigla());

        paisNegocio.saveAndFlush(pais);

        return "redirect:/pais";
    }
}