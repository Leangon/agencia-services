package agencias.service.servicesTest;

import agencias.service.models.dto.Request.VueloRequestDTO;
import agencias.service.models.dto.Response.VueloResponseDTO;
import agencias.service.models.entity.Vuelo;
import agencias.service.repository.VueloRepository;
import agencias.service.service.impl.VueloServiceImpl;
import agencias.service.utils.VueloUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class VueloServiceTest {

    @Mock
    VueloRepository repository;

    @InjectMocks
    VueloServiceImpl service;

    @Test
    @DisplayName("Test guardar vuelo camino feliz")
    void guardarVueloTestOk(){
        VueloRequestDTO vueloDto = VueloUtils.vueloDTO();
        Vuelo argumentSut = VueloUtils.vuelo1();
        VueloResponseDTO expected = new VueloResponseDTO(VueloUtils.vueloDTO(), "Vuelo Guardado Correctamente!");

        when(repository.save(any())).thenReturn(argumentSut);
        VueloResponseDTO actual = service.crearVuelo(vueloDto);

        assertEquals(expected.getMensaje(), actual.getMensaje());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test listar vuelos camino feliz")
    void listarVuelosTestOk(){
        List<Vuelo> argumentSut = VueloUtils.ListaVuelos();
        List<VueloResponseDTO> expected = VueloUtils.listarVuelosDTO();

        when(repository.findAll()).thenReturn(argumentSut);
        List<VueloResponseDTO> actual = service.mostrarVuelos();

        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0), actual.get(0));
    }

}
