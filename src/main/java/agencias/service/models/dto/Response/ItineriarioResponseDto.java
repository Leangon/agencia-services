package agencias.service.models.dto.Response;

import agencias.service.models.dto.Request.ItinerarioRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItineriarioResponseDto {

    private ItinerarioRequestDto itineriarioDto;
    private String message;
}
