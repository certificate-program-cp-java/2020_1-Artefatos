package br.edu.utfpr.cp.java.helloworld.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.utfpr.cp.java.helloworld.entidade.PaisModel;
import br.edu.utfpr.cp.java.helloworld.excecao.PaisJaExisteException;
import br.edu.utfpr.cp.java.helloworld.persistencia.PaisRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaisNegocio {

    private final PaisRepository paisRepository;

    public void criar(PaisModel pais) throws PaisJaExisteException {

        if (paisRepository.findByNome(pais.getNome()).isPresent())
            throw new PaisJaExisteException(); 

        else
            paisRepository.save(pais); 
    }

    public List<PaisModel> findAll() {
        return paisRepository.findAll();
    }

    public void deleteById(Long id) {
        paisRepository.deleteById(id);
    }

    public Optional<PaisModel> findById(Long id) {
        return paisRepository.findById(id);
    }

    public PaisModel saveAndFlush(PaisModel pais) {
        return paisRepository.saveAndFlush(pais);
    }
    
}