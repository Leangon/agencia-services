package agencias.service.models.dto.Request;

import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagoRequestDTO {
    private Long idPago;
    private Integer num_transaccion;
    private Double monto;
    private LocalDate fecha_pago;
    private ReservaRequestDTO ReservaDto;
    private ReporteRequestDTO reporteDto;
}
