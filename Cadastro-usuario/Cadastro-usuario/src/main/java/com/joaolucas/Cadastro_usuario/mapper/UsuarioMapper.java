package com.joaolucas.Cadastro_usuario.mapper;

import com.joaolucas.Cadastro_usuario.dto.UsuarioDTO;
import com.joaolucas.Cadastro_usuario.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);
    UsuarioDTO toDto(Usuario usuario);
}
