package com.joaolucas.Cadastro_usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class UsuarioDTO {

    private UUID id;

    @NotBlank(message = "Nome obrigatório")
    private String nome;

    @NotBlank(message = "Senha obrigatória")
    @Size(min = 5, message = "A senha deve ter no mínimo 5 caracteres")
    private String senha;

    @NotBlank(message = "Email obrigatório")
    @Email(message = "Email inválido")
    private String email;
}
