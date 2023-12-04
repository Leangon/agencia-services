package agencias.service.service;

import agencias.service.models.dto.Request.PromocionCompleteDTO;
import agencias.service.models.dto.Request.PromocionRequestDto;
import agencias.service.models.dto.Response.PromocionResponseDto;
import agencias.service.models.dto.Response.ResponseDeleteDto;

import java.util.List;

public interface PromocionService {

    PromocionResponseDto save(PromocionRequestDto promocionDto);

    List<PromocionRequestDto> findAll();

    PromocionResponseDto findById(Long id);

    PromocionResponseDto update(PromocionCompleteDTO promocionDto);

    ResponseDeleteDto delete(Long id);
}
