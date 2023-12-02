package agencias.service.models.dto.Response;

import agencias.service.models.dto.Request.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VueloResponseDTO {

    private VueloRequestDTO vuelo;
    private String mensaje;

}
