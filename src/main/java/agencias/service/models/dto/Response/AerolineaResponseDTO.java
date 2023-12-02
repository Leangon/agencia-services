package agencias.service.models.dto.Response;

import agencias.service.models.dto.Request.AerolineaRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AerolineaResponseDTO {
    private AerolineaRequestDTO aerolinea;
    private String message;

}
