package agencias.service.service;

import agencias.service.models.dto.Request.RolRequestDTO;
import agencias.service.models.dto.Response.RolResponseDTO;

public interface RolService {

    RolResponseDTO save(RolRequestDTO rolDto);

    RolResponseDTO asignarRol(Long idRol, Long idUsuario);
}
