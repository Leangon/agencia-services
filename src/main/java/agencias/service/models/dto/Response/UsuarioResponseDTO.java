package agencias.service.models.dto.Response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {

    private String nombre;
    private String apellido;
    private String email;

}
