package agencias.service.service;

import agencias.service.models.dto.Request.VueloRequestDTO;
import agencias.service.models.dto.Response.ResponseDeleteDto;
import agencias.service.models.dto.Response.VueloResponseDTO;

import java.util.List;
public interface VueloService {
    List<VueloResponseDTO> mostrarVuelos();

    VueloResponseDTO crearVuelo(VueloRequestDTO vueloRequestDTO);

    VueloResponseDTO vueloPorId(Long idVuelo);

    ResponseDeleteDto eliminarVueloPorId(Long idVuelo);

    VueloResponseDTO editarVuelo(Long idVuelo);
}
