package agencias.service.models.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VueloResponseDTO {

    private int numVuelo;
    private int cantPasajeros;
    private boolean disponibilidad;
    private LocalDate fecha;
    private String horaSalida;
    private String horaLLegada;

}
