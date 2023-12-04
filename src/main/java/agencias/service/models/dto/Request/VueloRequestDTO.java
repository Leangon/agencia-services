package agencias.service.models.dto.Request;

import agencias.service.models.entity.Aerolinea;
import agencias.service.models.entity.Itinerario;
import agencias.service.models.entity.Reserva;
import agencias.service.models.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VueloRequestDTO {

    private Long idVuelo;
    private int numVuelo;
    private int cantPasajeros;
    private boolean disponibilidad;
    private LocalDate fecha;
    private String horaSalida;
    private String horaLLegada;
    private List<ReservaRequestDTO> listaReservas;
    private List<TicketRequestDTO> listaTickets;
    private AerolineaRequestDTO aerolinea;
    private ItinerarioRequestDto itinerario;
}
