package agencias.service.models.dto.Response;

import agencias.service.models.dto.Request.ReservaRequestDTO;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {

    private String nombre;
    private String apellido;
    private Long dni;
    private Long telefono;
    private String email;
    private LocalDate fechaNacimiento;
    private List<ReservaRequestDTO> listaReservas;
}
