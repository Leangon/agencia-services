package agencias.service.models.dto.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@ToString
public class ReporteResponseDTO {


    private int numeroVuelosVendidos;
    private Double ingresosGenerados;
    private Map<String,Integer> destinosPopulares;


}
