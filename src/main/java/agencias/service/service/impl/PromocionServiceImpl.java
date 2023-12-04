package agencias.service.service.impl;

import agencias.service.models.dto.Request.PromocionCompleteDTO;
import agencias.service.models.dto.Request.PromocionRequestDto;
import agencias.service.models.dto.Response.PromocionResponseDto;
import agencias.service.models.dto.Response.ResponseDeleteDto;
import agencias.service.models.entity.Promocion;
import agencias.service.repository.PromocionRepository;
import agencias.service.service.PromocionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PromocionServiceImpl implements PromocionService {

    PromocionRepository repository;

    public PromocionServiceImpl(PromocionRepository repository) {
        this.repository = repository;
    }

    @Override
    public PromocionResponseDto save(PromocionRequestDto promocionDto) {
        ModelMapper mapper = new ModelMapper();
        Promocion promocion = mapper.map(promocionDto, Promocion.class);
        Promocion guardado = repository.save(promocion);
        PromocionRequestDto response = mapper.map(guardado, PromocionRequestDto.class);
        return new PromocionResponseDto(response, "La promoción fue guardado correctamente");
    }

    @Override
    public List<PromocionRequestDto> findAll() {
        List<Promocion> lista = repository.findAll();
        if(lista.isEmpty()) {
            throw new RuntimeException("No se han encontrado promociones");
        }
        ModelMapper mapper = new ModelMapper();
        return lista.stream()
                .map(p -> mapper.map(p, PromocionRequestDto.class))
                .toList();
    }

    @Override
    public PromocionResponseDto findById(Long id) {
        Promocion result = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existen promociones con este id"));
        ModelMapper mapper = new ModelMapper();
        PromocionRequestDto response = mapper.map(result, PromocionRequestDto.class);
        return new PromocionResponseDto(response, "Se ha encontrado una promoción");
    }

    @Override
    public PromocionResponseDto update(PromocionCompleteDTO promocionDto) {
        ModelMapper mapper = new ModelMapper();
        Promocion promocion = mapper.map(promocionDto, Promocion.class);
        Optional<Promocion> encontrado = repository.findById(promocion.getIdPromocion());
        PromocionResponseDto response = new PromocionResponseDto();

        if(encontrado.isPresent()){
            Promocion modificado = encontrado.get();
            modificado.setVuelo(promocion.getVuelo());
            modificado.setDescuentoPromocional(promocion.getDescuentoPromocional());
            modificado.setAerolinea(promocion.getAerolinea());
            modificado.setUsuario(promocion.getUsuario());

            Promocion p = repository.save(modificado);
            PromocionRequestDto promo = mapper.map(p, PromocionRequestDto.class);
            response.setPromocionDto(promo);
            response.setMessage("Promoción modificada correctamente");
        }else{
            throw new RuntimeException("No existen promociones con este id");
        }
        return response;
    }

    @Override
    public ResponseDeleteDto delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existen promociones con este id"));
        repository.deleteById(id);
        return new ResponseDeleteDto("Promoción eliminada correctamente");
    }
}
