package agencias.service.models.dto.Request;

import agencias.service.models.entity.Itinerario;
import lombok.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VueloRequestDTO {

    private Long idVuelo;
    private int numVuelo;
    private int cantAsientos;
    private boolean disponibilidad;
    private LocalDate fecha;
    private Itinerario Itinerario;
    private AerolineaRequestDTO aerolinea;
}
