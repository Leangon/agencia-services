package agencias.service.controllerTest;

import agencias.service.controllers.RolController;
import agencias.service.models.dto.Request.RolRequestDTO;
import agencias.service.models.dto.Response.RolResponseDTO;
import agencias.service.service.RolService;
import agencias.service.utils.RolUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RolTest {

    @Mock
    RolService service;

    @InjectMocks
    RolController controller;

    @Test
    void crearRolTestOK(){
        RolRequestDTO argumentSut = RolUtils.rolDto();
        RolResponseDTO respuesta = new RolResponseDTO("Rol guardado con éxito");
        ResponseEntity<?> expected = new ResponseEntity<>(respuesta, HttpStatus.CREATED);

        when(service.save(argumentSut)).thenReturn(respuesta);
        ResponseEntity<?> actual = controller.save(argumentSut);

        assertEquals(expected, actual);
    }
}
