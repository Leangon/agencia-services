package agencias.service.service.impl;

import agencias.service.exceptions.TicketGenericException;
import agencias.service.models.dto.Request.TicketCompleteDTO;
import agencias.service.models.dto.Request.TicketRequestDTO;
import agencias.service.models.dto.Response.ResponseDeleteDto;
import agencias.service.models.dto.Response.TicketResponseDTO;
import agencias.service.models.entity.Ticket;
import agencias.service.repository.TicketRepository;
import agencias.service.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    TicketRepository repository;

    public TicketServiceImpl(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public TicketResponseDTO save(TicketRequestDTO ticketDto) {
        ModelMapper mapper = new ModelMapper();
        Ticket ticket = mapper.map(ticketDto, Ticket.class);
        Ticket guardado = repository.save(ticket);
        TicketRequestDTO response = mapper.map(guardado, TicketRequestDTO.class);
        return new TicketResponseDTO(response, "El ticket fue guardado correctamente");
    }

    @Override
    public List<TicketRequestDTO> findAll() {
        List<Ticket> lista = repository.findAll();
        if(lista.isEmpty()) {
            throw new TicketGenericException("No se han encontrado tickets");
        }
        ModelMapper mapper = new ModelMapper();
        return lista.stream()
                .map(t -> mapper.map(t, TicketRequestDTO.class))
                .toList();
    }

    @Override
    public TicketResponseDTO findById(Long id) {
        Ticket result = repository.findById(id)
                .orElseThrow(() -> new TicketGenericException("No existen tickets con este id"));
        ModelMapper mapper = new ModelMapper();
        TicketRequestDTO response = mapper.map(result, TicketRequestDTO.class);
        return new TicketResponseDTO(response, "Se ha encontrado un ticket");
    }

    @Override
    public TicketResponseDTO update(TicketCompleteDTO ticketDto) {
        ModelMapper mapper = new ModelMapper();
        Ticket ticket = mapper.map(ticketDto, Ticket.class);
        Ticket encontrado = repository.findById(ticket.getIdTicket())
                .orElseThrow(() -> new TicketGenericException("No existen tickets con este id"));

        encontrado.setClase(ticket.getClase());
        encontrado.setPrecio(ticket.getPrecio());
        encontrado.setNumAsiento(ticket.getNumAsiento());
        encontrado.setReserva(ticket.getReserva());
        encontrado.setPasajero(ticket.getPasajero());

        Ticket t = repository.save(encontrado);
        TicketRequestDTO r = mapper.map(t, TicketRequestDTO.class);
        return new TicketResponseDTO(r, "Ticket modificado correctamente");
    }

    @Override
    public ResponseDeleteDto delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new TicketGenericException("No existen tickets con este id"));
        repository.deleteById(id);
        return new ResponseDeleteDto("Ticket eliminado correctamente");
    }
}
