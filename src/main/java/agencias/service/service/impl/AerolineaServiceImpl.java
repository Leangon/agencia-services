package agencias.service.service.impl;

import agencias.service.exceptions.AerolineaDBException;
import agencias.service.exceptions.AerolineaFoundException;
import agencias.service.exceptions.AerolineaNotFoundException;
import agencias.service.exceptions.VueloGenericException;
import agencias.service.models.dto.Request.AerolineaRequestDTO;
import agencias.service.models.dto.Request.VueloRequestDTO;
import agencias.service.models.dto.Response.AerolineaResponseDTO;
import agencias.service.models.dto.Response.ResponseDeleteDto;
import agencias.service.models.dto.Response.VueloResponseDTO;
import agencias.service.models.entity.Aerolinea;
import agencias.service.models.entity.Vuelo;
import agencias.service.repository.AerolineaRepository;
import agencias.service.service.AerolineaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AerolineaServiceImpl  implements AerolineaService {
    AerolineaRepository repoLinea;
    private final ModelMapper mapper;

    public AerolineaServiceImpl(AerolineaRepository repoLinea) {
        this.repoLinea = repoLinea;
        mapper = new ModelMapper();
    }

    @Override
    public AerolineaResponseDTO guardarAerolinea(AerolineaRequestDTO aerolinea) {
        /*Aca con mapper convierto aerolinea en una clase y la guardo en aerolineaClass */
        Aerolinea aerolineaClass = mapper.map(aerolinea, Aerolinea.class);
        /* hacer el save de instancia aerolineaClass*/
        Aerolinea aerolineaGuardada = repoLinea.save(aerolineaClass);
        /*Aca instancio un Dto responseDTO y con mapper otra vez convierto a la clase AerolineaResponseDTO*/

        /* retorno el DTO de respuesta y el mensaje correspondiente*/
        return new AerolineaResponseDTO(aerolinea.getRazonSocial(), aerolinea.getCuit(), " Se guardo correctamente");
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
    public ResponseDeleteDto borrarAerolinea(Long idAerolinea) {
        Aerolinea aerolinea = repoLinea.findById(idAerolinea).orElseThrow(() -> {
            throw new AerolineaNotFoundException("No existe la Aerolinea que desea eliminar");
        });
        String nombreAerolineaEliminada = aerolinea.getRazonSocial(); // Obtener el nombre de la aerolínea eliminada

        repoLinea.deleteById(idAerolinea);/*delete de la aerolinea*/
        /* aca quiero mostrar los datos de la aerolinea que se borro pero solo pude mostrar la razonSocial*/
        return new ResponseDeleteDto(nombreAerolineaEliminada + " Se elimino correctamente ");
    }

    @Override
    public AerolineaResponseDTO traerAerolineaPorId(Long idAerolinea) {
        Aerolinea aerolinea = repoLinea.findById(idAerolinea)
                .orElseThrow(() -> new AerolineaNotFoundException("No existe la Aerolínea que desea buscar"));

        return new AerolineaResponseDTO(aerolinea.getRazonSocial(), aerolinea.getCuit(), "Se encontro la aerolinea buscada");
    }

    @Override
    public List<AerolineaRequestDTO> listarAerolinea() {
    List<Aerolinea> aerolineas = repoLinea.findAll();

    if (aerolineas.isEmpty()){
        throw new AerolineaNotFoundException("No existen Aerolineas para listar");
    }

    ModelMapper modelMapper = new ModelMapper();
    List<AerolineaRequestDTO> responseDTOs = new ArrayList<>();

    for (Aerolinea aerolinea : aerolineas) {
        AerolineaRequestDTO responseDTO = modelMapper.map(aerolinea, AerolineaRequestDTO.class);
        responseDTOs.add(responseDTO);

        }
        return responseDTOs;

    }

    //Con este metodo obtengo una lista de aerolineas y comparo la que me llega con las del repositorio
/*    private boolean verificarExiste(Aerolinea aerolinea) {
        List<Aerolinea> listaEntidad = repoLinea.findAll();
        if(listaEntidad.isEmpty()){
            return false;
        }
        List<Aerolinea> listaBusqueda=listaEntidad.stream()
                .filter(aero ->aero.equalsAerolinea(aerolinea))
                .toList();
        return !listaBusqueda.isEmpty();
    }*/
}




