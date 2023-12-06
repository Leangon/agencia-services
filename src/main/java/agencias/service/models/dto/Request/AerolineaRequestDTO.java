package agencias.service.models.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AerolineaRequestDTO {

    @NotBlank(message = "debe tener una razon social")
    private String razonSocial;

    @NotBlank(message = "debe tener un cuit")
    private String cuit;
}
