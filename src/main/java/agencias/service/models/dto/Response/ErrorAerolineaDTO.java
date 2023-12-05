package agencias.service.models.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorAerolineaDTO {
    private int status;
    private String message;


}
