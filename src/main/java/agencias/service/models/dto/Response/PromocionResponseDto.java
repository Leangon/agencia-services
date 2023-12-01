package agencias.service.models.dto.Response;

import agencias.service.models.dto.Request.PromocionRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromocionResponseDto {

    private PromocionRequestDto promocionDto;
    private String message;
}
