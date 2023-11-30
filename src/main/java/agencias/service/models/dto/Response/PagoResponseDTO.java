package agencias.service.models.dto.Response;

import agencias.service.models.dto.Request.PagoRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagoResponseDTO {
    private PagoRequestDTO pago;
    private String mensaje;
}
