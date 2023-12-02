package agencias.service.controllerTest;

import agencias.service.controllers.PagoController;
import agencias.service.models.dto.Request.PagoRequestDTO;
import agencias.service.models.dto.Response.PagoResponseDTO;
import agencias.service.models.dto.Response.ResponseDeleteDto;
import agencias.service.service.PagoService;
import agencias.service.utils.PagoUtils;
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
public class PagoTest {

    @Mock
    PagoService service;

    @InjectMocks
    PagoController controller;

    @Test
    void guardarPagoTestOK(){
        PagoRequestDTO argumentSut = PagoUtils.pagoDto1();
        PagoResponseDTO respuesta = new PagoResponseDTO(PagoUtils.pagoDto1(), "se guardo con exito");
        ResponseEntity<?> expected = new ResponseEntity<>(respuesta, HttpStatus.OK);

        when(service.crearPago(argumentSut)).thenReturn(respuesta);
        ResponseEntity<?> actual = controller.guardarPago(argumentSut);

        assertEquals(expected, actual);
    }

    @Test
    void PagoPorIdTestOK(){
        Long id = 2L;
        PagoResponseDTO respuesta = new PagoResponseDTO(PagoUtils.pagoDto2(), "se guardo con exito");
        ResponseEntity<?> expected = new ResponseEntity<>(respuesta, HttpStatus.OK);

        when(service.traerPagoPorId(id)).thenReturn(respuesta);
        ResponseEntity<?> actual = controller.pagoPorId(id);

        assertEquals(expected, actual);
    }

    @Test
    void listarPagoTestOK(){
        List<PagoResponseDTO> respuesta = PagoUtils.pagoListResponseDto();
        ResponseEntity<?> expected = new ResponseEntity<>(respuesta, HttpStatus.OK);

        when(service.listarPagos()).thenReturn(respuesta);
        ResponseEntity<?> actual = controller.listarPagos();

        assertEquals(expected, actual);
    }

    @Test
    void eliminarPagoTestOK(){
        Long id = 1L;
        ResponseDeleteDto respuesta = new ResponseDeleteDto("Eliminado con exito");
        ResponseEntity<?> expected = new ResponseEntity<>(respuesta, HttpStatus.OK);

        when(service.borrarPago(id)).thenReturn(respuesta);
        ResponseEntity<?> actual = controller.eliminarPago(id);

        assertEquals(expected, actual);
    }
}
