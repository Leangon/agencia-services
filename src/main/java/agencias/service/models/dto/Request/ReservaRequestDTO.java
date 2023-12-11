package agencias.service.models.dto.Request;

import agencias.service.models.enums.Clase;
import agencias.service.models.enums.TipoPago;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaRequestDTO {

    @NotNull(message = "Debe tener un número de asiento")
    @Range(min = 1, max = 200, message = "El número de asiento debe estar entre 1 y 200")
    private int nroAsiento;

    @NotNull(message = "Debe indicarse la clase")
    private Clase clase;

    @NotNull(message="Debe tener una fecha")
    @FutureOrPresent(message="La fecha debe ser la actual o una fecha futura")
    private LocalDate fechaReserva;

    @NotNull(message ="Debe tener un precio")
    @Positive(message="El precio debe ser un número positivo")
    private Double precio;

    @NotNull(message ="Debe tener un tipo de pago asociado")
    private TipoPago tipoPago;

    private Long idVuelo;

    private Long idUsuario;

    private List<TicketRequestDTO> tickets;
}
