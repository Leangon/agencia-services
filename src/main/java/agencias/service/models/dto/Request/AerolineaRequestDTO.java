package agencias.service.models.dto.Request;

import agencias.service.models.entity.Promocion;
import agencias.service.models.entity.Vuelo;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AerolineaRequestDTO {

    @NotEmpty(message = "Razon social no puede estar vacio")
    @Size(min = 1, max = 30, message = "Razon social debe tener entre 1 y 30 caracteres")
    @NotBlank(message= "No se permite Razon Social sin datos")
    private String razonSocial;

    @NotEmpty(message="El cuit no puede estar vacio")
    @Size(min=11,max=11, message="El cuit debe tener 11 caracteres obligatoriamente")
    @Pattern(regexp ="^[0-9]+$" , message= "El cuit solo puede contener caracteres numericos entre 0 y 9")
    @NotBlank(message ="No se permite cuit sin datos")
    private String cuit;

    /*private PromocionRequestDto promocion;

    private List<VueloRequestDTO> listaVuelos;*/
}
