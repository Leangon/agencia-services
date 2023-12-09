package agencias.service.models.dto.Response;

import agencias.service.models.dto.Request.TicketDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TicketResponseDTO {

    private TicketDTO ticket;
    private String message;
}
