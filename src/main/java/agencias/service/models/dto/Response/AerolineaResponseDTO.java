package agencias.service.models.dto.Response;


import agencias.service.models.dto.Request.VueloRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AerolineaResponseDTO {

    private String razonSocial;
    private String cuit;



    private String message;

    private List<VueloRequestDTO> listaVuelos;
}
