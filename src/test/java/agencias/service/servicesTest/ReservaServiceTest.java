package agencias.service.servicesTest;

import agencias.service.models.entity.Reserva;
import agencias.service.repository.ReservaRepository;
import agencias.service.utils.ReservaUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ReservaServiceTest {

    @Autowired
    ReservaRepository repository;


    @Test
    //@Rollback(false)
    void findAllSinServicesTest(){

        List<Reserva> reservasUser = ReservaUtils.listaReservas();

        repository.findReservaByIdUsuario(1L);

        Object [] esperados = new List[]{reservasUser};
        Object [] encontrados = new List[]{repository.findReservaByIdUsuario(1L)};

        assertAll(
                () -> assertNotNull(encontrados),
                () -> assertArrayEquals(esperados, encontrados),
                () -> assertEquals(1, encontrados.length)
        );
    }
}
