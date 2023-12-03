package agencias.service.service;


import agencias.service.models.dto.Request.AerolineaRequestDTO;
import agencias.service.models.dto.Response.AerolineaResponseDTO;

import java.util.List;

public interface AerolineaService {


        public AerolineaResponseDTO guardarAerolinea(AerolineaRequestDTO aerolinea );
        public AerolineaResponseDTO borrarAerolinea(Long idAerolinea );

    AerolineaResponseDTO traerAerolineaPorId(Long idAerolinea);

    public List<AerolineaResponseDTO> listarAerolinea();


}


