package agencias.service.models.dto.Response;

import agencias.service.models.dto.Request.PagoRequestDTO;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagoResponseDTO {
    private PagoRequestDTO pago;
    private String mensaje;
}
