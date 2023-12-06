package agencias.service.service.impl;

import agencias.service.exceptions.VueloGenericException;
import agencias.service.models.dto.Request.VueloRequestDTO;
import agencias.service.models.dto.Response.ResponseDeleteDto;
import agencias.service.models.dto.Response.VueloResponseDTO;
import agencias.service.models.entity.Vuelo;
import agencias.service.repository.VueloRepository;
import agencias.service.service.VueloService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VueloServiceImpl implements VueloService {

    VueloRepository vueloRepository;

    public VueloServiceImpl(VueloRepository vueloRepository){
        this.vueloRepository = vueloRepository;
    }

    @Override
    public List<VueloRequestDTO> mostrarVuelos() {
        List<Vuelo> listaVuelos = vueloRepository.findAll();

        ModelMapper modelMapper = new ModelMapper();
        List<VueloRequestDTO> vuelosDtoList = new ArrayList<>();

        listaVuelos.forEach(vuelo -> vuelosDtoList.add(modelMapper.map(vuelo, VueloRequestDTO.class)));

        return vuelosDtoList;
    }

    @Override
    public VueloResponseDTO crearVuelo(VueloRequestDTO vueloRequestDTO) {
        ModelMapper modelMapper = new ModelMapper();

        Vuelo nuevoVuelo = modelMapper.map(vueloRequestDTO, Vuelo.class);
        Vuelo vueloPersist = vueloRepository.save(nuevoVuelo);

        VueloRequestDTO dto = modelMapper.map(vueloPersist, VueloRequestDTO.class);
        return new VueloResponseDTO(dto, "Vuelo Guardado Correctamente!");
    }

    @Override
    public VueloResponseDTO vueloPorId(Long idVuelo) {
        ModelMapper modelMapper = new ModelMapper();

        Vuelo vuelo = vueloRepository.findById(idVuelo).orElseThrow( () -> new VueloGenericException("No existe vuelo con ese id!"));

        VueloRequestDTO response = modelMapper.map(vuelo, VueloRequestDTO.class);
        VueloResponseDTO vueloResponseDTO = new VueloResponseDTO();
        vueloResponseDTO.setMensaje("Vuelo encontrado!");
        vueloResponseDTO.setVueloDto(response);

        return vueloResponseDTO;
    }

    @Override
    public VueloResponseDTO editarVuelo(Long idVuelo, VueloRequestDTO vueloRequestDTO) {
        Vuelo vueloExistente = vueloRepository.findById(idVuelo).orElseThrow(() -> new VueloGenericException("No se encontró el vuelo a modificar"));

        ModelMapper modelMapper = new ModelMapper();

        Vuelo vueloEditado = modelMapper.map(vueloRequestDTO, Vuelo.class);
        //Vuelo vueloPersis = modelMapper.map(vueloRepository.findById(idVuelo), Vuelo.class);

        vueloExistente.setNumVuelo(vueloEditado.getNumVuelo());
        vueloExistente.setCantAsientos(vueloEditado.getCantAsientos());
        vueloExistente.setDisponibilidad(vueloEditado.isDisponibilidad());
        vueloExistente.setFecha(vueloEditado.getFecha());
        vueloExistente.setAerolinea(vueloEditado.getAerolinea());
        vueloExistente.setItinerario(vueloEditado.getItinerario());

        Vuelo v =vueloRepository.save(vueloExistente);
        VueloRequestDTO response = modelMapper.map(v, VueloRequestDTO.class);
        return new VueloResponseDTO(response, "Vuelo modificado correctamente.");
    }

    @Override
    public ResponseDeleteDto eliminarVueloPorId(Long idVuelo) {
        vueloRepository.findById(idVuelo).orElseThrow(() -> new VueloGenericException("No encontramos el vuelo a eliminar!"));
        vueloRepository.deleteById(idVuelo);
        return new ResponseDeleteDto("Vuelo eliminado correctamente!");
    }


}
