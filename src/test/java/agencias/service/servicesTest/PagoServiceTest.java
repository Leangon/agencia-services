package agencias.service.servicesTest;

import agencias.service.models.dto.Request.PagoRequestDTO;
import agencias.service.models.dto.Response.PagoResponseDTO;
import agencias.service.models.dto.Response.ResponseDeleteDto;
import agencias.service.models.entity.Pago;
import agencias.service.repository.PagoRepository;
import agencias.service.service.impl.PagoServiceImpl;
import agencias.service.utils.PagoUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PagoServiceTest {

    @Mock
    PagoRepository repository;

    @InjectMocks
    PagoServiceImpl service;

    @Test
    @DisplayName(value = "Test OK para guardar pago")
    void guardarPagoTestOK(){
        PagoRequestDTO pagoDto = PagoUtils.pagoDto1();
        Pago argumentSut = PagoUtils.pago1();
        PagoResponseDTO expected = new PagoResponseDTO(PagoUtils.pagoDto1(), "Se registro el pago correctamente");

        when(repository.save(any())).thenReturn(argumentSut);
        PagoResponseDTO actual = service.crearPago(pagoDto);

        assertEquals(expected.getMensaje(), actual.getMensaje());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "Test OK para listar pagos")
    void listarPagoTestOK(){
        List<Pago> argumentSut = PagoUtils.listaPagos();
        List<PagoResponseDTO> expected = PagoUtils.pagoListResponseDto();

        when(repository.findAll()).thenReturn(argumentSut);
        List<PagoResponseDTO> actual = service.listarPagos();

        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0), actual.get(0));
    }

    @Test
    @DisplayName(value = "Test OK de buscar un pago por id")
    void pagoPorIdTestOK(){
        Long id = 1L;
        Pago argumentSut = PagoUtils.pago1();
        PagoResponseDTO expected = new PagoResponseDTO(PagoUtils.pagoDto1(), "se logro encontrar el pago buscado");

        when(repository.findById(any())).thenReturn(Optional.of(argumentSut));
        PagoResponseDTO actual = service.traerPagoPorId(id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "Test lanzar EXCEPTION por no encontrar pago asociado con el id")
    void pagoPorIdTestEXCEPTION(){
        Long id = 1L;
        RuntimeException expected = new RuntimeException ( "No existe el pago que desea buscar" );
        when(repository.findById(any())).thenReturn(Optional.empty());

        RuntimeException actual = assertThrows(RuntimeException.class, () -> service.traerPagoPorId(id));
        assertEquals(actual.getMessage(), expected.getMessage());
    }

    @Test
    @DisplayName(value = "Test OK de eliminar un pago por id")
    void eliminarPagoPorIdTestOK(){
        Long id = 1L;
        Pago argumentSut = PagoUtils.pago1();
        ResponseDeleteDto expected = new ResponseDeleteDto("El pago se elimino correctamente");

        when(repository.findById(any())).thenReturn(Optional.of(argumentSut));
        repository.deleteById(1L);
        ResponseDeleteDto actual = service.borrarPago(id);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "Test lanzar EXCEPTION en eliminar por id por no encontrar pago asociado")
    void eliminarPagoPorIdTestEXCEPTION(){
        Long id = 1L;
        RuntimeException expected = new RuntimeException ( "No existe el pago que desea eliminar" );
        when(repository.findById(any())).thenReturn(Optional.empty());

        RuntimeException actual = assertThrows(RuntimeException.class, () -> service.borrarPago(id));
        assertEquals(actual.getMessage(), expected.getMessage());
    }
}
