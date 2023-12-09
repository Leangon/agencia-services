package agencias.service.service.impl;

import agencias.service.exceptions.TicketGenericException;
import agencias.service.models.dto.Request.TicketCompleteDTO;
import agencias.service.models.dto.Request.TicketDTO;
import agencias.service.models.dto.Response.ResponseDeleteDto;
import agencias.service.models.dto.Response.TicketResponseDTO;
import agencias.service.models.entity.Ticket;
import agencias.service.repository.TicketRepository;
import agencias.service.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    TicketRepository repository;

    public TicketServiceImpl(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public TicketResponseDTO save(TicketDTO ticketDto) {
        ModelMapper mapper = new ModelMapper();
        Ticket ticket = mapper.map(ticketDto, Ticket.class);
        Ticket guardado = repository.save(ticket);
        TicketDTO response = mapper.map(guardado, TicketDTO.class);
        return new TicketResponseDTO(response, "El ticket fue guardado correctamente");
    }

    @Override
    public List<TicketDTO> findAll() {
        List<Ticket> lista = repository.findAll();
        if(lista.isEmpty()) {
            throw new TicketGenericException("No se han encontrado tickets");
        }
        ModelMapper mapper = new ModelMapper();
        return lista.stream()
                .map(t -> mapper.map(t, TicketDTO.class))
                .toList();
    }

    @Override
    public TicketResponseDTO findById(Long id) {
        Ticket result = repository.findById(id)
                .orElseThrow(() -> new TicketGenericException("No existen tickets con este id"));
        ModelMapper mapper = new ModelMapper();
        TicketDTO response = mapper.map(result, TicketDTO.class);
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
        encontrado.setVuelo(ticket.getVuelo());

        Ticket t = repository.save(encontrado);
        TicketDTO r = mapper.map(t, TicketDTO.class);
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
