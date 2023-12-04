package agencias.service.service;

import agencias.service.exceptions.CustomException;
import agencias.service.models.dto.Request.UsuarioRequestDTO;
import agencias.service.models.dto.Response.UsuarioResponseDTO;
import agencias.service.models.entity.Mensaje;
import agencias.service.models.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    UsuarioResponseDTO createUsuario(UsuarioRequestDTO usuarioRequestDTO) throws CustomException;

    UsuarioResponseDTO getUsuarioById(Long id) throws CustomException;

    Mensaje deleteUsuarioById(Long id) throws CustomException;

    UsuarioResponseDTO updateUsuario(UsuarioRequestDTO usuarioRequestDTO) throws CustomException;

    List<UsuarioResponseDTO> usuarioList();

    UsuarioResponseDTO mapToUsuarioResponseDto(Usuario usuario);

}
