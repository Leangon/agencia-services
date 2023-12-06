package agencias.service.models.dto.Request;

import agencias.service.models.entity.Pasajero;
import agencias.service.models.enums.Clase;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketRequestDTO {

    private int numAsiento;
    private double precio;
    private Clase clase;
    private Pasajero pasajero;
    private VueloRequestDTO vuelo;
    private ReservaRequestDTO reserva;
}
