package agencias.service.models.dto.Request;

import agencias.service.models.entity.Aerolinea;
import agencias.service.models.entity.Usuario;
import agencias.service.models.entity.Vuelo;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromocionRequestDto {

    private int descuentoPromocional;
    private UsuarioRequestDTO usuario;
    private AerolineaRequestDTO aerolinea;
    private VueloRequestDTO vuelo;
}
