package agencias.service.models.dto.Response;

import agencias.service.models.dto.Request.AerolineaRequestDTO;
import agencias.service.models.dto.Request.ReservaRequestDTO;
import agencias.service.models.dto.Request.TicketRequestDTO;
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
public class VueloResponseDTO {

    private int numVuelo;
    private int cantPasajeros;
    private boolean disponibilidad;
    private LocalDate fecha;
    private String horaSalida;
    private String horaLLegada;
    private List<ReservaRequestDTO> listaReservas;
    private List<TicketRequestDTO> listaTickets;
    private AerolineaRequestDTO aerolinea;
}
