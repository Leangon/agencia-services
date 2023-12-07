package agencias.service.service.impl;

import agencias.service.exceptions.AerolineaDBException;
import agencias.service.exceptions.AerolineaFoundException;
import agencias.service.exceptions.AerolineaNotFoundException;
import agencias.service.models.dto.Request.AerolineaRequestDTO;
import agencias.service.models.dto.Response.AerolineaResponseDTO;
import agencias.service.models.entity.Aerolinea;
import agencias.service.repository.AerolineaRepository;
import agencias.service.service.AerolineaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AerolineaServiceImpl  implements AerolineaService {
    private final AerolineaRepository repoLinea;
    private final ModelMapper mapper;

    public AerolineaServiceImpl(AerolineaRepository repoLinea) {
        this.repoLinea = repoLinea;
        mapper = new ModelMapper();
    }

    @Override
    public AerolineaResponseDTO guardarAerolinea(AerolineaRequestDTO aerolinea) {
        Aerolinea aerolineaClass = mapper.map(aerolinea, Aerolinea.class);
        if(verificarExiste(aerolineaClass)){
            throw new AerolineaFoundException("La aerolinea que intenta guardar ya existe.");
        }
        Aerolinea aerolineaGuardada = repoLinea.save(aerolineaClass);
        if(aerolineaGuardada == null){
            throw new AerolineaDBException("No se puedo guardar la aerolinea .");
        }
        /* convierto a aerolineaGuardada a la clase AerolineaResponseDTO*/
        AerolineaResponseDTO responseDTO = mapper.map(aerolineaGuardada, AerolineaResponseDTO.class);
        responseDTO.setMessage("La aerolinea "+aerolineaGuardada.getRazonSocial()+" se guardo correctamente");
        return responseDTO;


    }

    @Override
    public AerolineaResponseDTO editarAerolinea(Long id, AerolineaRequestDTO aerolineaRequest) {
   // Verificar si la aerolínea existe en el repositorio
    Aerolinea AerolineaGuardada = repoLinea.findById(id)
                                   .orElseThrow(() -> {
                                      throw new AerolineaNotFoundException("No existe la Aerolinea que desea modificar");
                                    });
     // Actualizar los atributos de la aerolínea con los valores del AerolineaRequestDTO
    AerolineaGuardada.setRazonSocial(aerolineaRequest.getRazonSocial());
    AerolineaGuardada.setCuit(aerolineaRequest.getCuit());
    // Guardar la aerolínea actualizada en el repositorio
    repoLinea.save(AerolineaGuardada);
    // Crear y mapear la respuesta DTO
    AerolineaResponseDTO responseDTO = mapper.map(AerolineaGuardada, AerolineaResponseDTO.class);
    responseDTO.setMessage("La aerolinea " + AerolineaGuardada.getIdAerolinea() + " se modificó correctamente.");
    return responseDTO;
    }


    @Override
    public AerolineaResponseDTO borrarAerolinea(Long idAerolinea) {
        Aerolinea aerolinea = repoLinea.findById(idAerolinea).orElseThrow(() -> {
            throw new AerolineaNotFoundException("No existe la Aerolinea que desea eliminar");
        });
        String nombreAerolineaEliminada = aerolinea.getRazonSocial(); // Obtener el nombre de la aerolínea eliminada
        repoLinea.deleteById(idAerolinea);
        AerolineaResponseDTO lineaDto = new AerolineaResponseDTO();
        /* aca quiero mostrar los datos de la aerolinea que se borro pero solo pude mostrar la razonSocial*/
        lineaDto.setMessage("La aerolinea " + nombreAerolineaEliminada + " se eliminó correctamente ");
        return lineaDto;

    }

    @Override
    public AerolineaResponseDTO traerAerolineaPorId(Long idAerolinea) {
        Aerolinea aerolinea = repoLinea.findById(idAerolinea)
                .orElseThrow(() -> new AerolineaNotFoundException("No existe la Aerolínea que desea buscar"));

        AerolineaResponseDTO lineaDto = mapper.map(aerolinea, AerolineaResponseDTO.class);
        lineaDto.setMessage("Se encontró la Aerolínea buscada");
        return lineaDto;
    }


    @Override
    public List<AerolineaResponseDTO> listarAerolinea() {
        List<Aerolinea> aerolineas = repoLinea.findAll();

        if (aerolineas.isEmpty()) {
            throw new AerolineaNotFoundException("No existen Aerolineas para listar");
        }
        ModelMapper modelMapper = new ModelMapper();
        List<AerolineaResponseDTO> responseDTOs = new ArrayList<>();
        for (Aerolinea aerolinea : aerolineas) {
            AerolineaResponseDTO responseDTO = modelMapper.map(aerolinea, AerolineaResponseDTO.class);
            responseDTOs.add(responseDTO);
        }
        return responseDTOs;
    }


    //Con este metodo obtengo una lista de aerolineas y comparo la que me llega con las del repositorio
    private boolean verificarExiste(Aerolinea aerolinea) {
        List<Aerolinea> listaEntidad = repoLinea.findAll();
        if(listaEntidad.isEmpty()){
            return false;
        }
        List<Aerolinea> listaBusqueda=listaEntidad.stream()
                .filter(aero ->aero.equalsAerolinea(aerolinea))
                .toList();
        return !listaBusqueda.isEmpty();
    }
}




