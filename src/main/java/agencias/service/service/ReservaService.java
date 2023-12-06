package agencias.service.service;

import agencias.service.models.dto.Response.ReporteResponseDTO;

import java.time.LocalDate;

public interface ReservaService {
    ReporteResponseDTO generarReporte(LocalDate date1, LocalDate date2);
    ReporteResponseDTO generarReporteUnaFecha(LocalDate fecha);
}
