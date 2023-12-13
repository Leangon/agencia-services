package agencias.service.service.impl;

import agencias.service.exceptions.TicketGenericException;
import agencias.service.exceptions.VueloGenericException;
import agencias.service.models.dto.Request.TicketCompleteDTO;
import agencias.service.models.dto.Request.TicketDTO;
import agencias.service.models.dto.Request.TicketRequestDTO;
import agencias.service.models.dto.Response.ResponseDeleteDto;
import agencias.service.models.dto.Response.TicketResponseDTO;
import agencias.service.models.entity.Ticket;
import agencias.service.models.entity.Vuelo;
import agencias.service.repository.TicketRepository;
import agencias.service.repository.VueloRepository;
import agencias.service.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    TicketRepository repository;

    VueloRepository vueloRepository;

    public TicketServiceImpl(TicketRepository repository, VueloRepository vueloRepository) {
        this.repository = repository;
        this.vueloRepository = vueloRepository;
    }

    @Override
    public TicketResponseDTO save(TicketDTO ticketDto) {
        ModelMapper mapper = new ModelMapper();
        Vuelo vuelo = vueloRepository.findById(ticketDto.getIdVuelo()).orElseThrow(
                () -> new VueloGenericException("No se han encontrado vuelo con ese id"));
        Ticket ticket = mapper.map(ticketDto, Ticket.class);
        ticket.setVuelo(vuelo);
        Ticket guardado = repository.save(ticket);
        TicketRequestDTO respuesta = response(guardado);
        return new TicketResponseDTO(respuesta, "El ticket fue guardado correctamente");
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
        TicketRequestDTO response = mapper.map(result, TicketRequestDTO.class);
        return new TicketResponseDTO(response, "Se ha encontrado un ticket");
    }

    @Override
    public TicketResponseDTO update(TicketCompleteDTO ticketDto) {
        ModelMapper mapper = new ModelMapper();
        Vuelo vuelo = vueloRepository.findById(ticketDto.getIdVuelo()).orElseThrow(
                () -> new VueloGenericException("No se han encontrado vuelos con este id"));
        Ticket ticket = mapper.map(ticketDto, Ticket.class);
        ticket.setVuelo(vuelo);
        Ticket encontrado = repository.findById(ticket.getIdTicket())
                .orElseThrow(() -> new TicketGenericException("No existen tickets con este id"));

        encontrado.setClase(ticket.getClase());
        encontrado.setPrecio(ticket.getPrecio());
        encontrado.setNumAsiento(ticket.getNumAsiento());
        encontrado.setReserva(ticket.getReserva());
        encontrado.setPasajero(ticket.getPasajero());
        encontrado.setVuelo(ticket.getVuelo());

        Ticket t = repository.save(encontrado);
        TicketRequestDTO r = response(t);
        return new TicketResponseDTO(r, "Ticket modificado correctamente");
    }

    @Override
    public ResponseDeleteDto delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new TicketGenericException("No existen tickets con este id"));
        repository.deleteById(id);
        return new ResponseDeleteDto("Ticket eliminado correctamente");
    }

    public TicketRequestDTO response(Ticket ticket){
       return new TicketRequestDTO(ticket.getNumAsiento(), ticket.getPrecio(), ticket.getClase(),
                ticket.getPasajero());
    }
 }
