package agencias.service.models.dto.Request;


import agencias.service.models.dto.Response.ReservaResponseDTO;
import agencias.service.models.enums.TipoPago;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PagoRequestDTO {
    private Long idPago;
    private Integer num_transaccion;
    private TipoPago tipoPago;
    private LocalDate fecha_pago;
    private List<ReservaResponseDTO> reservaDto;

}
