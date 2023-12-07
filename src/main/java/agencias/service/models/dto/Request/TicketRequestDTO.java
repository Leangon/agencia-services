package agencias.service.models.dto.Request;

import agencias.service.models.entity.Pasajero;
import agencias.service.models.enums.Clase;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketRequestDTO {
    @NotEmpty(message="Debe tener un número de asiento")
    @NotBlank(message="Debe tener un número de asiento")
    @Min(value = 1, message = "El número de asiento debe ser mayor o igual a 1")
    @Max(value = 200, message = "El número de asiento debe ser menor o igual a 200")
    private int numAsiento;

    @NotEmpty(message ="Debe tener un precio")
    @NotBlank(message="Debe tener un precio")
    @Positive(message="El precio debe ser un número positivo")
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio debe ser mayor o igual 0.0")
    private double precio;
    private Clase clase;
    private Pasajero pasajero;
    private VueloRequestDTO vuelo;
    private ReservaRequestDTO reserva;
}
