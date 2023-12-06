package agencias.service.service;

import agencias.service.models.dto.Response.ReporteResponseDTO;
import agencias.service.models.dto.Response.ReservasByUserResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ReservaService {
    ReporteResponseDTO generarReporte(LocalDate date1, LocalDate date2);
    ReporteResponseDTO generarReporteUnaFecha(LocalDate fecha);

    ReservasByUserResponseDTO reservasByUsuario(Long id);
}
