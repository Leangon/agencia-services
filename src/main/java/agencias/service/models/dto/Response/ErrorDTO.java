package agencias.service.models.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class ErrorDTO {
    private int status;
    private String message;


}
