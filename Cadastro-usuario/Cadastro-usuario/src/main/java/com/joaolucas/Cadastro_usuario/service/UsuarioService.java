package com.joaolucas.Cadastro_usuario.service;

import com.joaolucas.Cadastro_usuario.dto.UsuarioDTO;
import com.joaolucas.Cadastro_usuario.exception.RecursoNaoEncontrado;
import com.joaolucas.Cadastro_usuario.mapper.UsuarioMapper;
import com.joaolucas.Cadastro_usuario.model.Usuario;
import com.joaolucas.Cadastro_usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final PasswordEncoder encoder;

    public List<UsuarioDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public Usuario buscarPorEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new RecursoNaoEncontrado("Email " + email + " não encontrado")
                );
    }

    public Usuario salvarUsuario(Usuario usuario){
        return repository.save(usuario);
    }

    public void deletarUsuarioPorEmail(String email) {

        Optional<Usuario> usuario = repository.findByEmail(email);

        if (usuario.isPresent()) {
            repository.deleteByEmail(email);
        } else {
            throw new RecursoNaoEncontrado("Usuario com email " + email + " inexistente");
        }
    }

    public void deletarUsuarioPorId(UUID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RecursoNaoEncontrado("Usuario com ID "+id+" não encontrado.");
        }
    }

    public void atualizarUsuario(UUID id, UsuarioDTO dto) {

        Usuario usuario = repository.findById(id).orElseThrow(() -> new RecursoNaoEncontrado
                ("Usuario com ID " + id + " não encontrado.")
        );

        usuario.setNome(dto.getNome());
        usuario.setSenha(encoder.encode(dto.getSenha()));
        usuario.setEmail(dto.getEmail());

        repository.save(usuario);
    }
}
