package com.joaolucas.Cadastro_usuario.mapper;

import com.joaolucas.Cadastro_usuario.dto.UsuarioDTO;
import com.joaolucas.Cadastro_usuario.model.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-18T15:20:54-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toEntity(UsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        return usuario;
    }

    @Override
    public UsuarioDTO toDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        return usuarioDTO;
    }
}
