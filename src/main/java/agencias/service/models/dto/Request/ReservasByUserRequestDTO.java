package agencias.service.models.dto.Request;

import agencias.service.models.entity.Usuario;
import agencias.service.models.entity.Vuelo;
import agencias.service.models.enums.TipoPago;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservasByUserRequestDTO {

    private LocalDate fechaReserva;
    private Usuario usuario;
    private TipoPago tipoPago;
    private Vuelo vuelo;
    List<TicketRequestDTO> tickets;
}
