package agencias.service.models.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItineriarioRequestDto {

    private String ciudadOrigen;
    private String paisOrigen;
    private String ciudadDestino;
    private String paisDestino;
}
