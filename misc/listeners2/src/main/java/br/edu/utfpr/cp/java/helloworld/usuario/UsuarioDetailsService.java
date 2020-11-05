package br.edu.utfpr.cp.java.helloworld.usuario;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var usuario = usuarioRepository.findByNome(username);

        if (usuario == null)
            throw new UsernameNotFoundException("Usuário não encontrado!");

        return new UsuarioPrincipal(usuario);
    }

}