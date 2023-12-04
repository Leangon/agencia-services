package agencias.service.controllerTest;

import agencias.service.controllers.PromocionController;
import agencias.service.models.dto.Request.PromocionCompleteDTO;
import agencias.service.models.dto.Request.PromocionRequestDto;
import agencias.service.models.dto.Response.PromocionResponseDto;
import agencias.service.models.dto.Response.ResponseDeleteDto;
import agencias.service.service.PromocionService;
import agencias.service.utils.PromocionUtils;
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
public class PromocionTest {

    @Mock
    PromocionService service;

    @InjectMocks
    PromocionController controller;

    @Test
    void guardarPromocionTestOK(){
        PromocionRequestDto argumentSut = PromocionUtils.promoDto1();
        PromocionResponseDto respuesta = new PromocionResponseDto(PromocionUtils.promoDto1(),"se guardo con exito");
        ResponseEntity<?> expected = new ResponseEntity<>(respuesta, HttpStatus.OK);

        when(service.save(argumentSut)).thenReturn(respuesta);
        ResponseEntity<?> actual = controller.save(argumentSut);

        assertEquals(expected, actual);
    }

    @Test
    void PromocionPorIdTestOK(){
        Long id = 2L;
        PromocionResponseDto respuesta = new PromocionResponseDto(PromocionUtils.promoDto1(), "se guardo con exito");
        ResponseEntity<?> expected = new ResponseEntity<>(respuesta, HttpStatus.OK);

        when(service.findById(id)).thenReturn(respuesta);
        ResponseEntity<?> actual = controller.findById(id);

        assertEquals(expected, actual);
    }

    @Test
    void findAllPromocionTestOK(){
        List<PromocionRequestDto> respuesta = PromocionUtils.listaPromocionesDto();
        ResponseEntity<?> expected = new ResponseEntity<>(respuesta, HttpStatus.OK);

        when(service.findAll()).thenReturn(respuesta);
        ResponseEntity<?> actual = controller.findAll();

        assertEquals(expected, actual);
    }

    @Test
    void updatePromocionTestOK(){
        PromocionCompleteDTO argumentSut = PromocionUtils.promocionCompleteDto1();
        PromocionResponseDto respuesta = new PromocionResponseDto(PromocionUtils.promoDto1(),"se guardo con exito");
        ResponseEntity<?> expected = new ResponseEntity<>(respuesta, HttpStatus.OK);

        when(service.update(argumentSut)).thenReturn(respuesta);
        ResponseEntity<?> actual = controller.update(argumentSut);

        assertEquals(expected, actual);
    }

    @Test
    void deletePromocionTestOK(){
        Long id = 1L;
        ResponseDeleteDto respuesta = new ResponseDeleteDto("Eliminado con exito");
        ResponseEntity<?> expected = new ResponseEntity<>(respuesta, HttpStatus.OK);

        when(service.delete(id)).thenReturn(respuesta);
        ResponseEntity<?> actual = controller.delete(id);

        assertEquals(expected, actual);
    }
}
