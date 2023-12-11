package agencias.service.models.dto.Request;

import agencias.service.models.entity.Pasajero;
import agencias.service.models.enums.Clase;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@NoArgsConstructor
@Data
public class TicketRequestDTO {

    @NotNull(message = "Debe tener un número de asiento")
    @Range(min = 1, max = 200, message = "El número de asiento debe estar entre 1 y 200")
    private int numAsiento;

    @NotNull(message ="Debe tener un precio")
    @Positive(message="El precio debe ser un número positivo")
    private Double precio;

    private Clase clase;

    private Pasajero pasajero;

    private Long idVuelo;

}
