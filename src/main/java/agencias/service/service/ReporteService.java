package agencias.service.service;

import agencias.service.models.dto.Request.ReporteRequestDTO;
import agencias.service.models.dto.Response.ReporteResponseDTO;
import agencias.service.models.dto.Response.ResponseDeleteDto;

import java.util.List;

public interface ReporteService {
    public ReporteResponseDTO crearReporte(ReporteRequestDTO reporte);
    public List<ReporteResponseDTO> listarReporte();
    public ReporteResponseDTO traerReportePorId(Long idReporte);
    public ResponseDeleteDto eliminarReporte(Long idReporte);
}
