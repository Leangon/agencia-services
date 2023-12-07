package agencias.service.models.dto.Response;

import agencias.service.models.dto.Request.UsuarioRequestDTO;
import agencias.service.models.dto.Request.VueloRequestDTO;
import agencias.service.models.enums.Clase;
import agencias.service.models.enums.TipoPago;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaResponseDTO {

    private Long nroAsiento;
    private Clase clase;
    private LocalDate fechaReserva;
    private Double precio;
    private TipoPago tipoPago;
    private VueloRequestDTO vuelo;
    private UsuarioRequestDTO usuario;

}
