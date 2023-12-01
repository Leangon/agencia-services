package agencias.service.models.dto.Response;

import agencias.service.models.dto.Request.ReporteRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReporteResponseDTO {
    public ReporteRequestDTO reporteDto;
    public String mensaje;
}
