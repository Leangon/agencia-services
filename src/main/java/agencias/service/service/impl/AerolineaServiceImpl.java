package agencias.service.service.impl;

import agencias.service.models.dto.Request.AerolineaRequestDTO;
import agencias.service.models.dto.Response.AerolineaResponseDTO;
import agencias.service.service.AerolineaService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AerolineaServiceImpl  implements AerolineaService {

    @Override
    public AerolineaResponseDTO guardarAerolinea(AerolineaRequestDTO aerolinea) {
        return null;
    }

    @Override
    public AerolineaResponseDTO borrarAerolinea(Long idAerolinea) {
        return null;
    }

    @Override
    public AerolineaResponseDTO mostrarAerolinea(Long idAerolinea) {
        return null;
    }

    @Override
    public List<AerolineaResponseDTO> listarAerolinea() {
        return null;
    }
}
