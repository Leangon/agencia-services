package agencias.service.models.dto.Request;

import agencias.service.models.enums.Clase;
import agencias.service.models.enums.TipoPago;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaRequestDTO {

    @NotEmpty(message="Debe tener un número de asiento")
    @NotBlank(message="Debe tener un número de asiento")
    @Min(value = 1, message = "El número de asiento debe ser mayor o igual a 1")
    @Max(value = 200, message = "El número de asiento debe ser menor o igual a 200")
    private Long nroAsiento;
    private Clase clase;
    @NotBlank(message="Debe tener una fecha")
    @NotEmpty(message="Debe tener una fecha")
    @FutureOrPresent(message="La fecha debe ser la actual o una fecha futura")
    private LocalDate fechaReserva;
    @NotEmpty(message ="Debe tener un precio")
    @NotBlank(message="Debe tener un precio")
    @Positive(message="El precio debe ser un número positivo")
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio debe ser mayor o igual a 0.0")
    private Double precio;
    private TipoPago tipoPago;
    private VueloRequestDTO vuelo;
    private UsuarioRequestDTO usuario;
}
