package agencias.service.servicesTest;

import agencias.service.exceptions.TicketGenericException;
import agencias.service.models.dto.Request.TicketCompleteDTO;
import agencias.service.models.dto.Request.TicketDTO;
import agencias.service.models.dto.Response.ResponseDeleteDto;
import agencias.service.models.dto.Response.TicketResponseDTO;
import agencias.service.models.entity.Ticket;
import agencias.service.repository.TicketRepository;
import agencias.service.service.impl.TicketServiceImpl;
import agencias.service.utils.TicketUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {

    @Mock
    TicketRepository repository;

    @InjectMocks
    TicketServiceImpl service;

    @Test
    @DisplayName(value = "Test OK para guardar ticket")
    void guardarTicketTestOK(){
        TicketDTO ticketDto = TicketUtils.ticketDto1();
        Ticket argumentSut = TicketUtils.ticket1();
        TicketResponseDTO expected = new TicketResponseDTO(TicketUtils.ticketDto1(),
                "El ticket fue guardado correctamente");

        when(repository.save(any())).thenReturn(argumentSut);
        TicketResponseDTO actual = service.save(ticketDto);

        assertEquals(expected.getMessage(), actual.getMessage());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "Test OK para find All ticket")
    void findAllTicketsTestOK(){
        List<Ticket> argumentSut = TicketUtils.listaTickets();
        List<TicketDTO> expected = TicketUtils.listaTicketsDto();

        when(repository.findAll()).thenReturn(argumentSut);
        List<TicketDTO> actual = service.findAll();

        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0), actual.get(0));
    }

    @Test
    @DisplayName(value = "Test lanzar EXCEPTION por no encontrar tickets")
    void findAllTicketsTestEXCEPTION(){

        TicketGenericException expected = new TicketGenericException("No se han encontrado tickets");
        List<Ticket> tickets = new ArrayList<>();
        when(repository.findAll()).thenReturn(tickets);

        TicketGenericException actual = assertThrows(TicketGenericException.class, () -> service.findAll());
        assertEquals(actual.getMessage(), expected.getMessage());
    }

    @Test
    @DisplayName(value = "Test OK de buscar un ticket por id")
    void ticketPorIdTestOK(){
        Long id = 1L;
        Ticket argumentSut = TicketUtils.ticket1();
        TicketResponseDTO expected = new TicketResponseDTO(TicketUtils.ticketDto1(), "Se ha encontrado un ticket");

        when(repository.findById(any())).thenReturn(Optional.of(argumentSut));
        TicketResponseDTO actual = service.findById(id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "Test lanzar EXCEPTION por no encontrar ticket asociado con el id")
    void TicketPorIdTestEXCEPTION(){
        Long id = 1L;
        TicketGenericException expected = new TicketGenericException ("No existen tickets con este id");
        when(repository.findById(any())).thenReturn(Optional.empty());

        TicketGenericException actual = assertThrows(TicketGenericException.class, () -> service.findById(id));
        assertEquals(actual.getMessage(), expected.getMessage());
    }

    @Test
    @DisplayName(value = "Test OK para update ticket")
    void updateTicketTestOK(){
        Ticket argumentSut = TicketUtils.ticket1();
        Ticket modificado = TicketUtils.ticket1modificado();
        TicketCompleteDTO completeDTO = TicketUtils.ticketCompleteDto1();
        TicketResponseDTO expected = new TicketResponseDTO(TicketUtils.ticketDto1modificado(), "Ticket modificado correctamente");

        when(repository.findById(any())).thenReturn(Optional.of(argumentSut));
        when(repository.save(any())).thenReturn(modificado);

        TicketResponseDTO actual = service.update(completeDTO);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "Test lanzar EXCEPTION en update por no encontrar ticket asociado")
    void UpdateTicketTestEXCEPTION(){
        TicketCompleteDTO completeDTO = TicketUtils.ticketCompleteDto1();
        TicketGenericException expected = new TicketGenericException ("No existen tickets con este id");
        when(repository.findById(any())).thenReturn(Optional.empty());

        TicketGenericException actual = assertThrows(TicketGenericException.class, () -> service.update(completeDTO));
        assertEquals(actual.getMessage(), expected.getMessage());
    }


    @Test
    @DisplayName(value = "Test OK de eliminar un ticket por id")
    void eliminarTicketPorIdTestOK(){
        Long id = 1L;
        Ticket argumentSut = TicketUtils.ticket1();
        ResponseDeleteDto expected = new ResponseDeleteDto("Ticket eliminado correctamente");

        when(repository.findById(any())).thenReturn(Optional.of(argumentSut));
        repository.deleteById(1L);
        ResponseDeleteDto actual = service.delete(id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "Test lanzar EXCEPTION en eliminar por no encontrar ticket asociado")
    void eliminarTicketPorIdTestEXCEPTION(){
        Long id = 1L;
        TicketGenericException expected = new TicketGenericException ("No existen tickets con este id");
        when(repository.findById(any())).thenReturn(Optional.empty());

        RuntimeException actual = assertThrows(TicketGenericException.class, () -> service.delete(id));
        assertEquals(actual.getMessage(), expected.getMessage());
    }
}
