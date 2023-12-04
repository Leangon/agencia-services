package agencias.service.models.dto.Response;

import agencias.service.models.dto.Request.AerolineaRequestDTO;
import agencias.service.models.dto.Request.PromocionRequestDto;
import agencias.service.models.dto.Request.VueloRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AerolineaResponseDTO {

    private String message;

    private List<VueloRequestDTO> listaVuelos;
}
