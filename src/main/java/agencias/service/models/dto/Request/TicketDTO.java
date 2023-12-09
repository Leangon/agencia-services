package agencias.service.models.dto.Request;

import agencias.service.models.entity.Pasajero;
import agencias.service.models.enums.Clase;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TicketDTO {

    private int numAsiento;
    private double precio;
    private Clase clase;
    private Pasajero pasajero;
    private VueloRequestDTO vuelo;
    private ReservaRequestDTO reserva;
}
