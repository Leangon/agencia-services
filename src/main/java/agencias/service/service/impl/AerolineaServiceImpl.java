package agencias.service.service.impl;

import agencias.service.models.dto.Request.AerolineaRequestDTO;
import agencias.service.models.dto.Response.AerolineaResponseDTO;
import agencias.service.models.entity.Aerolinea;
import agencias.service.repository.AerolineaRepository;
import agencias.service.service.AerolineaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AerolineaServiceImpl  implements AerolineaService {
    private final AerolineaRepository repoLinea;
    private final ModelMapper mapper;
    public AerolineaServiceImpl (AerolineaRepository repoLinea){
        this.repoLinea=repoLinea;
        mapper=new ModelMapper();
    }
    @Override
    public AerolineaResponseDTO guardarAerolinea(AerolineaRequestDTO aerolinea) {
        /*Aca con mapper convierto aerolinea en una clase y la guardo en aerolineaClass */
        Aerolinea aerolineaClass = mapper.map(aerolinea,Aerolinea.class);
        /* hacer el save de instancia aerolineaClass*/
        Aerolinea aerolineaGuardada = repoLinea.save(aerolineaClass);
        /*Aca instancio un Dto responseDTO y con mapper otra vez convierto a la clase AerolineaResponseDTO*/
        AerolineaResponseDTO responseDTO = mapper.map(aerolineaGuardada, AerolineaResponseDTO.class);

        /* hago el set del message del DTO de respuesta*/
        responseDTO.setMessage("Se guardo Aerolinea correctamente");
        return responseDTO;


    }

    @Override
    public AerolineaResponseDTO borrarAerolinea(Long idAerolinea) {
        Aerolinea aerolinea= repoLinea.findById(idAerolinea).orElseThrow ( ()-> {
            throw new RuntimeException ( "No existe la Aerolinea que desea eliminar" );
        });
        String nombreAerolineaEliminada = aerolinea.getRazonSocial(); // Obtén el nombre de la aerolínea eliminada
        /*hacer el delete de la aerolinea*/

        repoLinea.deleteById(idAerolinea);
        AerolineaResponseDTO lineaDto = new AerolineaResponseDTO();
        /* aca quiero mostrar los datos de la aerolinea que se borro pero solo pude mostrar la razonSocial*/
        lineaDto.setMessage(nombreAerolineaEliminada + " Se elimino correctamente ");
        return lineaDto;

    }

    @Override
    public AerolineaResponseDTO traerAerolineaPorId(Long idAerolinea) {
        Aerolinea aerolinea = repoLinea.findById(idAerolinea)
                .orElseThrow(() -> new RuntimeException("No existe la Aerolínea que desea buscar"));

        AerolineaResponseDTO lineaDto = mapper.map(aerolinea, AerolineaResponseDTO.class);
        lineaDto.setMessage("Se encontró la Aerolínea buscada");
        return lineaDto;
    }


    @Override
    public List<AerolineaResponseDTO> listarAerolinea() {

         List<Aerolinea> listaAerolineas=repoLinea.findAll();
         List<AerolineaResponseDTO> lineaDtoList= new ArrayList<>();
         listaAerolineas.stream().forEach(a-> lineaDtoList.add(mapper.map(a,AerolineaResponseDTO.class)));
         /*aca tengo el problema que por cada uno me envia el message en null y no quiero que se muestre el message*/
         return lineaDtoList;

    }

}
