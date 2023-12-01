package agencias.service.models.dto.Request;

import agencias.service.models.entity.Itinerario;
import agencias.service.models.entity.Reserva;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReporteRequestDTO {

    private Integer cant_ventas;
    private List<PagoRequestDTO> listaPagos;
    private List<ReservaRequestDTO> listaReservas;
    private List<ItinerarioRequestDto> listaItinerarios;
}
