package agencias.service.service;

import agencias.service.models.dto.Request.TicketCompleteDTO;
import agencias.service.models.dto.Request.TicketRequestDTO;
import agencias.service.models.dto.Response.ResponseDeleteDto;
import agencias.service.models.dto.Response.TicketResponseDTO;

import java.util.List;

public interface TicketService {

    TicketResponseDTO save(TicketRequestDTO ticketDto);

    List<TicketRequestDTO> findAll();

    TicketResponseDTO findById(Long id);

    TicketResponseDTO update(TicketCompleteDTO ticketDto);

    ResponseDeleteDto delete(Long id);
}
