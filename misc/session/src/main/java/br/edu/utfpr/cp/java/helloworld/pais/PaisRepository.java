package br.edu.utfpr.cp.java.helloworld.pais;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<PaisModel, Long> { 

    public Optional<PaisModel> findByNome(String nome);
}