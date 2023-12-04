package agencias.service.models.dto.Request;

import agencias.service.models.entity.Promocion;
import agencias.service.models.entity.Reserva;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    private String nombre;
    private String apellido;
    private Long dni;
    private Long telefono;
    private String email;
    private LocalDate fechaNacimiento;

}
