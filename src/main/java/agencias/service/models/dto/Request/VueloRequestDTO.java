package agencias.service.models.dto.Request;

import agencias.service.models.entity.Itinerario;
import agencias.service.models.entity.Promocion;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VueloRequestDTO {

    private Long idVuelo;
    private int numVuelo;
    private int cantPasajeros;
    private boolean disponibilidad;
    private LocalDate fecha;
    private Itinerario Itinerario;
    private List<ReservaRequestDTO> listaReservas;
    private List<TicketRequestDTO> listaTickets;
    private List<PromocionRequestDto> listaPromociones;
    private AerolineaRequestDTO aerolinea;
}
