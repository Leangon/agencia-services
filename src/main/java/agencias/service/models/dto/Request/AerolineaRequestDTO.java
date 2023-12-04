package agencias.service.models.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AerolineaRequestDTO {

    private String razonSocial;

    private String cuit;

    /*private PromocionRequestDto promocion;

    private List<VueloRequestDTO> listaVuelos;*/
}
