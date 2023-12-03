package agencias.service.service.impl;

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

    private final VueloRepository vueloRepository;

    public VueloServiceImpl(VueloRepository vueloRepository){
        this.vueloRepository = vueloRepository;
    }

    @Override
    public List<VueloResponseDTO> mostrarVuelos() {
        List<Vuelo> listaVuelos = vueloRepository.findAll();

        ModelMapper modelMapper = new ModelMapper();
        List<VueloResponseDTO> vuelosDtoList = new ArrayList<>();

        listaVuelos.forEach(vuelo -> vuelosDtoList.add(modelMapper.map(vuelo, VueloResponseDTO.class)));

        return vuelosDtoList;
    }

    @Override
    public VueloResponseDTO crearVuelo(VueloRequestDTO vueloRequestDTO) {
        ModelMapper modelMapper = new ModelMapper();

        Vuelo nuevoVuelo = modelMapper.map(vueloRequestDTO, Vuelo.class);
        Vuelo vueloPersist = vueloRepository.save(nuevoVuelo);

        VueloResponseDTO vueloDto = new VueloResponseDTO();
        vueloDto.setVuelo(modelMapper.map(vueloPersist, VueloRequestDTO.class));
        vueloDto.setMensaje("Vuelo Guardado Correctamente!");

        return vueloDto;
    }

    @Override
    public VueloResponseDTO vueloPorId(Long idVuelo) {
        ModelMapper modelMapper = new ModelMapper();

        Vuelo vuelo = vueloRepository.findById(idVuelo).orElseThrow( () -> new RuntimeException("No existe vuelo con ese id!"));

        VueloResponseDTO vueloResponseDTO = new VueloResponseDTO();
        vueloResponseDTO.setVuelo(modelMapper.map(vuelo, VueloRequestDTO.class));
        vueloResponseDTO.setMensaje("Vuelo encontrado!");

        return vueloResponseDTO;
    }

    @Override
    public ResponseDeleteDto eliminarVueloPorId(Long idVuelo) {
        Vuelo vuelo = vueloRepository.findById(idVuelo).orElseThrow(() -> new RuntimeException("No encontramos el vuelo a eliminar!"));

        vueloRepository.deleteById(idVuelo);

        return new ResponseDeleteDto("Vuelo eliminado correctamente!");
    }

    @Override
    public VueloResponseDTO editarVuelo(Long idVuelo, VueloRequestDTO vueloRequestDTO) {
        Vuelo vueloExistente = vueloRepository.findById(idVuelo).orElseThrow(() -> new RuntimeException("No se encontró el vuelo a modificar"));

        ModelMapper modelMapper = new ModelMapper();

        Vuelo vueloEditado = modelMapper.map(vueloRequestDTO, Vuelo.class);
        Vuelo vueloPersis = modelMapper.map(vueloRepository.findById(idVuelo), Vuelo.class);

        vueloPersis.setNumVuelo(vueloEditado.getNumVuelo());
        vueloPersis.setCantPasajeros(vueloEditado.getCantPasajeros());
        vueloPersis.setDisponibilidad(vueloEditado.isDisponibilidad());
        vueloPersis.setFecha(vueloEditado.getFecha());
        vueloPersis.setHoraSalida(vueloEditado.getHoraSalida());
        vueloPersis.setHoraLLegada(vueloEditado.getHoraLLegada());
        vueloPersis.setListaReservas(vueloEditado.getListaReservas());
        vueloPersis.setListaTickets(vueloEditado.getListaTickets());
        vueloPersis.setListaPromociones(vueloEditado.getListaPromociones());
        vueloPersis.setAerolinea(vueloEditado.getAerolinea());
        vueloPersis.setItinerario(vueloEditado.getItinerario());

        vueloRepository.save(vueloPersis);

        return new VueloResponseDTO(vueloRequestDTO, "Vuelo editado y guardado correctamente!");

    }
}
