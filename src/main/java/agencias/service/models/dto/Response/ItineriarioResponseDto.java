package agencias.service.models.dto.Response;

import agencias.service.models.dto.Request.ItineriarioRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItineriarioResponseDto {

    private ItineriarioRequestDto itineriarioDto;
    private String message;
}
