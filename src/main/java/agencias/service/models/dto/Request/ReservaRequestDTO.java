package agencias.service.models.dto.Request;

import agencias.service.models.enums.Clase;
import agencias.service.models.enums.TipoPago;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaRequestDTO {

    private Long nroAsiento;
    private Clase clase;
    private LocalDate fechaReserva;
    private Double precio;
    private TipoPago tipoPago;
    private VueloRequestDTO vuelo;
    private UsuarioRequestDTO usuario;
}
