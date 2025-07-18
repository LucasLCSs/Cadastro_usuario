package com.joaolucas.Cadastro_usuario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "usuarios")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @Size(min = 5,message = "A senha deve ter no mínimo 5 caracteres")
    private String senha;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @CreationTimestamp
    private Instant dataAtualizacao;
}
