package com.joaolucas.Cadastro_usuario.controller;

import com.joaolucas.Cadastro_usuario.dto.UsuarioDTO;
import com.joaolucas.Cadastro_usuario.mapper.UsuarioMapper;
import com.joaolucas.Cadastro_usuario.model.Usuario;
import com.joaolucas.Cadastro_usuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioMapper mapper;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid UsuarioDTO dto) {

        Usuario usuario = mapper.toEntity(dto);

        Usuario usuarioSalvo = service.salvarUsuario(usuario);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuarioSalvo.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<UsuarioDTO> lista = service.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarPorEmail(@RequestParam String email) {
        Usuario usuario = service.buscarPorEmail(email);
        UsuarioDTO dto = mapper.toDto(usuario);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable UUID id) {
        service.deletarUsuarioPorId(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/email/{email}")
    public ResponseEntity<?> deletarPorEmail(@PathVariable String email) {
        service.deletarUsuarioPorEmail(email);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID id, @RequestBody UsuarioDTO dto) {
        service.atualizarUsuario(id, dto);
        return ResponseEntity.noContent().build();
    }
}
