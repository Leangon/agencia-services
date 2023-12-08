package agencias.service.models.dto.Request;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    private String nombre;
    private String apellido;
    private Long dni;
    private Long telefono;
    private String email;
    private LocalDate fechaNacimiento;
    private String username;
    private String password;
    private List<ReservaRequestDTO> listaReservas;
}
