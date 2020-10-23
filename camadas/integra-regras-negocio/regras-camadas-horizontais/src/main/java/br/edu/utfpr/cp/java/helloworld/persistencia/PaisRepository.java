package br.edu.utfpr.cp.java.helloworld.persistencia;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.cp.java.helloworld.entidade.PaisModel;

public interface PaisRepository extends JpaRepository<PaisModel, Long> { 

    public Optional<PaisModel> findByNome(String nome);
}