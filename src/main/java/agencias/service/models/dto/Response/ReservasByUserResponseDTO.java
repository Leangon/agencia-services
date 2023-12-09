package agencias.service.models.dto.Response;


import agencias.service.models.dto.Request.ReservaRequestDTO;
import agencias.service.models.dto.Request.ReservasByUserRequestDTO;
import agencias.service.models.dto.Request.TicketRequestDTO;
import agencias.service.models.entity.Reserva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservasByUserResponseDTO {

    private String message;
    private List<ReservasByUserRequestDTO> listaReservas;
}
