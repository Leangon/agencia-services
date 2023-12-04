package agencias.service.controllerTest;

import agencias.service.controllers.TicketController;
import agencias.service.models.dto.Request.TicketCompleteDTO;
import agencias.service.models.dto.Request.TicketRequestDTO;
import agencias.service.models.dto.Response.ResponseDeleteDto;
import agencias.service.models.dto.Response.TicketResponseDTO;
import agencias.service.service.TicketService;
import agencias.service.utils.TicketUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TicketTest {

    @Mock
    TicketService service;

    @InjectMocks
    TicketController controller;

  /*  @Test
    void guardarTicketTestOK(){
        TicketRequestDTO argumentSut = TicketUtils.ticketDto1();
        TicketResponseDTO respuesta = new TicketResponseDTO(TicketUtils.ticketDto1(),"se guardo con exito");
        ResponseEntity<?> expected = new ResponseEntity<>(respuesta, HttpStatus.OK);

        when(service.save(argumentSut)).thenReturn(respuesta);
        ResponseEntity<?> actual = controller.save(argumentSut);

        assertEquals(expected, actual);
    }*/

   /* @Test
    void TicketPorIdTestOK(){
        Long id = 2L;
        TicketResponseDTO respuesta = new TicketResponseDTO(TicketUtils.ticketDto1(), "se guardo con exito");
        ResponseEntity<?> expected = new ResponseEntity<>(respuesta, HttpStatus.OK);

        when(service.findById(id)).thenReturn(respuesta);
        ResponseEntity<?> actual = controller.findById(id);

        assertEquals(expected, actual);
    }*/

   /* @Test
    void findAllTicketTestOK(){
        List<TicketRequestDTO> respuesta = TicketUtils.listaTicketsDto();
        ResponseEntity<?> expected = new ResponseEntity<>(respuesta, HttpStatus.OK);

        when(service.findAll()).thenReturn(respuesta);
        ResponseEntity<?> actual = controller.findAll();

        assertEquals(expected, actual);
    }*/

    /*@Test
    void updateTicketTestOK(){
        TicketCompleteDTO argumentSut = TicketUtils.ticketCompleteDto1();
        TicketResponseDTO respuesta = new TicketResponseDTO(TicketUtils.ticketDto1(),"se guardo con exito");
        ResponseEntity<?> expected = new ResponseEntity<>(respuesta, HttpStatus.OK);

        when(service.update(argumentSut)).thenReturn(respuesta);
        ResponseEntity<?> actual = controller.update(argumentSut);

        assertEquals(expected, actual);
    }*/

    @Test
    void deleteTicketTestOK(){
        Long id = 1L;
        ResponseDeleteDto respuesta = new ResponseDeleteDto("Eliminado con exito");
        ResponseEntity<?> expected = new ResponseEntity<>(respuesta, HttpStatus.OK);

        when(service.delete(id)).thenReturn(respuesta);
        ResponseEntity<?> actual = controller.delete(id);

        assertEquals(expected, actual);
    }
}
