package br.edu.utfpr.cp.java.helloworld.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNome(String nome);
}