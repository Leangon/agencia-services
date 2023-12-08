package agencias.service.servicesTest;

import agencias.service.exceptions.ReservaNotFoundException;
import agencias.service.models.dto.Response.ReporteResponseDTO;
import agencias.service.models.dto.Response.ReservasByUserResponseDTO;
import agencias.service.models.entity.Reserva;
import agencias.service.models.entity.Usuario;
import agencias.service.repository.ReservaRepository;
import agencias.service.repository.UsuarioRepository;
import agencias.service.service.impl.ReservaServiceImpl;
import agencias.service.utils.ReservaUtils;
import agencias.service.utils.UsuarioUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ReservaServiceTest {

    @Mock
    ReservaRepository repository;

    @Mock
    UsuarioRepository userRepository;

    @InjectMocks
    ReservaServiceImpl service;

    @Test
    void reservaGenerarReporteTest(){
        LocalDate date1 = LocalDate.of(2023, 10, 10);
        LocalDate date2 = LocalDate.of(2023, 12, 31);
        int vuelosVendidos = 2;
        Double ingresosGenerados = 2000D;
        Map<String, Integer> destinosPopulares = new HashMap<>();
        destinosPopulares.put("Rio Janeiro", 1);
        destinosPopulares.put("Paris", 1);
        List<Reserva> listaReservas = ReservaUtils.listaReservas();
        ReporteResponseDTO expected = new ReporteResponseDTO(vuelosVendidos, ingresosGenerados, destinosPopulares);

        when(repository.findAll()).thenReturn(listaReservas);

        ReporteResponseDTO actual = service.generarReporte(date1, date2);

        assertEquals(expected, actual);
    }

    @Test
    void reservaGenerarReportePorFechaTest(){
        LocalDate date = LocalDate.of(2023, 10, 12);
        int vuelosVendidos = 1;
        Double ingresosGenerados = 1000D;
        Map<String, Integer> destinosPopulares = new HashMap<>();
        destinosPopulares.put("Paris", 1);
        List<Reserva> listaReservas = ReservaUtils.listaReservas();
        ReporteResponseDTO expected = new ReporteResponseDTO(vuelosVendidos, ingresosGenerados, destinosPopulares);

        when(repository.findAll()).thenReturn(listaReservas);

        ReporteResponseDTO actual = service.generarReporteUnaFecha(date);

        assertEquals(expected, actual);
    }

    @Test
    void reservasByUsuario(){
        Usuario usuario = UsuarioUtils.usuario1();
        List<Reserva> lista = ReservaUtils.listaReservas();
        ReservasByUserResponseDTO expected = new ReservasByUserResponseDTO(
                "Reservas efectuadas por " + usuario.getNombre() + " " + usuario.getApellido() + ": ",
        ReservaUtils.listaReservasByDto());

        when(userRepository.findById(any())).thenReturn(Optional.of(usuario));
        when(repository.findReservaByIdUsuario(any())).thenReturn(lista);

        ReservasByUserResponseDTO actual = service.reservasByUsuario(usuario.getIdUsuario());

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test buscar reservas by usuario por id lanza EXCEPTION")
    void reservasByUsuarioTestEXCEPTION(){
        Long id = 1L;
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        ReservaNotFoundException expected = new ReservaNotFoundException("No existen usuarios con ese id");

        ReservaNotFoundException actual = assertThrows(ReservaNotFoundException.class, () -> service.reservasByUsuario(id));
        assertEquals(actual.getMessage(), expected.getMessage());
    }
}
