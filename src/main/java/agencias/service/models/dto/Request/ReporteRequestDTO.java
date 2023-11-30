package agencias.service.models.dto.Request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReporteRequestDTO {
    private Integer cant_ventas;
    private List<PagoRequestDTO> listaPagos;
}
