package agencias.service.models.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromocionCompleteDTO {

    private Long idPromocion;
    private int descuentoPromocional;
    private UsuarioRequestDTO usuario;
    private AerolineaRequestDTO aerolinea;
    private VueloRequestDTO vuelo;
}
