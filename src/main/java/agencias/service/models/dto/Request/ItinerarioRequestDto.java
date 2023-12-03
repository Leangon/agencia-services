package agencias.service.models.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItinerarioRequestDto {

    private String ciudadOrigen;
    private String paisOrigen;
    private String ciudadDestino;
    private String paisDestino;
    private List<VueloRequestDTO> listaVuelos;
}