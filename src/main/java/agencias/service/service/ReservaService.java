package agencias.service.service;

import agencias.service.models.dto.Response.ReservasByUserResponseDTO;

public interface ReservaService {

    ReservasByUserResponseDTO reservasByUsuario(Long id);
}
