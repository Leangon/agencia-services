package agencias.service.models.dto.Response;

import agencias.service.models.enums.Clase;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaResponseDTO {

    private Long nroAsiento;
    private Clase clase;
    private LocalDate fechaReserva;
    private Double precio;

}
