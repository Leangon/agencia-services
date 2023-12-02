package agencias.service.models.dto.Response;

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
    private String razonsocial;
    private String cuil;

    private PromocionRequestDto promocion;

    private List<VueloRequestDTO> listaVuelos;
}
