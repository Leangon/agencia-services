package agencias.service.models.dto.Request;

import agencias.service.models.enums.Clase;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaRequestDTO {

    private Long nroAsiento;
    private Clase clase;
    private LocalDate fechaReserva;
    private Double precio;
    private PagoRequestDTO pago;
    private VueloRequestDTO vuelo;
    private UsuarioRequestDTO usuario;
}
