package agencias.service.servicesTest;

import agencias.service.models.dto.Request.PromocionCompleteDTO;
import agencias.service.models.dto.Request.PromocionRequestDto;
import agencias.service.models.dto.Response.PromocionResponseDto;
import agencias.service.models.dto.Response.ResponseDeleteDto;
import agencias.service.models.entity.Promocion;
import agencias.service.repository.PromocionRepository;
import agencias.service.service.impl.PromocionServiceImpl;
import agencias.service.utils.PromocionUtils;
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
public class PromocionServiceTest {

   @Mock
   PromocionRepository repository;

    @InjectMocks
    PromocionServiceImpl service;

    @Test
    @DisplayName(value = "Test OK para guardar promoción")
    void guardarPromocionTestOK(){
        PromocionRequestDto promoDto = PromocionUtils.promoDto1();
        Promocion argumentSut = PromocionUtils.promo1();
        PromocionResponseDto expected = new PromocionResponseDto(PromocionUtils.promoDto1(),
                "La promoción fue guardado correctamente");

        when(repository.save(any())).thenReturn(argumentSut);
        PromocionResponseDto actual = service.save(promoDto);

        assertEquals(expected.getMessage(), actual.getMessage());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "Test OK para find All promoción")
    void findAllPromocionesTestOK(){
        List<Promocion> argumentSut =PromocionUtils.listaPromociones();
        List<PromocionRequestDto> expected = PromocionUtils.listaPromocionesDto();

        when(repository.findAll()).thenReturn(argumentSut);
        List<PromocionRequestDto> actual = service.findAll();

        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0), actual.get(0));
    }

    @Test
    @DisplayName(value = "Test lanzar EXCEPTION por no encontrar promociones")
    void findAllPromocionesTestEXCEPTION(){

        RuntimeException expected = new RuntimeException ("No se han encontrado promociones");
        List<Promocion> promociones = new ArrayList<>();
        when(repository.findAll()).thenReturn(promociones);

        RuntimeException actual = assertThrows(RuntimeException.class, () -> service.findAll());
        assertEquals(actual.getMessage(), expected.getMessage());
    }

    @Test
    @DisplayName(value = "Test OK de buscar un promoción por id")
    void promocionPorIdTestOK(){
        Long id = 1L;
        Promocion argumentSut = PromocionUtils.promo1();
        PromocionResponseDto expected = new PromocionResponseDto(PromocionUtils.promoDto1(), "Se ha encontrado una promoción");

        when(repository.findById(any())).thenReturn(Optional.of(argumentSut));
        PromocionResponseDto actual = service.findById(id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "Test lanzar EXCEPTION por no encontrar promoción asociada con el id")
    void PromocionPorIdTestEXCEPTION(){
        Long id = 1L;
        RuntimeException expected = new RuntimeException ("No existen promociones con este id");
        when(repository.findById(any())).thenReturn(Optional.empty());

        RuntimeException actual = assertThrows(RuntimeException.class, () -> service.findById(id));
        assertEquals(actual.getMessage(), expected.getMessage());
    }

    @Test
    @DisplayName(value = "Test OK para update promoción")
    void updatePromocionTestOK(){
        Promocion argumentSut = PromocionUtils.promo1();
        Promocion modificado = PromocionUtils.promo1modificado();
        PromocionCompleteDTO completeDTO = PromocionUtils.promocionCompleteDto1();
        PromocionResponseDto expected = new PromocionResponseDto(PromocionUtils.promo1modificadoDto(), "Promoción modificada correctamente");

        when(repository.findById(any())).thenReturn(Optional.of(argumentSut));
        when(repository.save(any())).thenReturn(modificado);

        PromocionResponseDto actual = service.update(completeDTO);

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName(value = "Test lanzar EXCEPTION en update por no encontrar una promoción asociada")
    void UpdatePromocionTestEXCEPTION(){
        PromocionCompleteDTO completeDTO = PromocionUtils.promocionCompleteDto1();
        RuntimeException expected = new RuntimeException ("No existen promociones con este id");
        when(repository.findById(any())).thenReturn(Optional.empty());

        RuntimeException actual = assertThrows(RuntimeException.class, () -> service.update(completeDTO));
        assertEquals(actual.getMessage(), expected.getMessage());
    }

    @Test
    @DisplayName(value = "Test OK de eliminar un promoción por id")
    void eliminarPrmocionPorIdTestOK(){
        Long id = 1L;
        Promocion argumentSut = PromocionUtils.promo1();
        ResponseDeleteDto expected = new ResponseDeleteDto("Promoción eliminada correctamente");

        when(repository.findById(any())).thenReturn(Optional.of(argumentSut));
        repository.deleteById(1L);
        ResponseDeleteDto actual = service.delete(id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "Test lanzar EXCEPTION en eliminar por no encontrar una promoción asociado")
    void eliminarPromocionPorIdTestEXCEPTION(){
        Long id = 1L;
        RuntimeException expected = new RuntimeException ("No existen promociones con este id");
        when(repository.findById(any())).thenReturn(Optional.empty());

        RuntimeException actual = assertThrows(RuntimeException.class, () -> service.delete(id));
        assertEquals(actual.getMessage(), expected.getMessage());
    }
}
