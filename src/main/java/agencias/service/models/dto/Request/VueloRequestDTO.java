package agencias.service.models.dto.Request;

import agencias.service.models.entity.Itinerario;

import jakarta.validation.constraints.*;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VueloRequestDTO {

    private Long idVuelo;
    @NotBlank(message="El número de vuelo es obligatorio")
    @NotEmpty(message="El número de vuelo es obligatorio")
    @Positive(message="El número de vuelo no puede ser un negativo")

    private int numVuelo;
    @NotBlank(message="La cantidad de pasajeros es obligatoria")
    @NotEmpty(message="La cantidad de pasajeros es obligatoria)")
    @Positive(message="La cantidad de pasajeros no puede ser un negativa")
    @Min(value =1,message="La cantidad de pasajeros debe ser mayor a 0")
    @Max(value =200, message="La cantidad de pasajeros no debe ser mayor a 200")
    private int cantPasajeros;
    @NotBlank(message = "El vuelo debe indicar si tiene disponibilidad de asientos")
    @NotEmpty(message="El vuelo debe indicar si tiene disponibilida de asientos")
    private boolean disponibilidad;
    @NotBlank(message="Debe tener una fecha")
    @FutureOrPresent(message="La fecha debe ser actual o fecha futura")
    private LocalDate fecha;
    private Itinerario Itinerario;
    private AerolineaRequestDTO aerolinea;
}
