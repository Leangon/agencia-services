package agencias.service.service;

import agencias.service.models.dto.Request.PagoRequestDTO;
import agencias.service.models.dto.Response.PagoResponseDTO;
import agencias.service.models.dto.Response.ResponseDeleteDto;

import java.util.List;

public interface PagoService {
    public List<PagoResponseDTO> listarPagos();
    public PagoResponseDTO crearPago(PagoRequestDTO pago);
    public PagoResponseDTO traerPagoPorId( Long idPago);
    public PagoResponseDTO editarPago(PagoRequestDTO pago);
    public ResponseDeleteDto borrarPago(Long idPago);


}
