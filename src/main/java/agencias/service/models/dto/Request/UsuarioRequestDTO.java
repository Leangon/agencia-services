package agencias.service.models.dto.Request;


import jakarta.validation.constraints.*;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {
    @NotBlank(message="Debe tener un nombre")
    @NotEmpty(message="Debe tener un nombre")
    private String nombre;
    @NotBlank(message="Debe tener un apellido")
    @NotEmpty(message="Debe tener un apellido")
    private String apellido;
    @NotEmpty(message="Debe tener un DNI")
    @NotBlank(message="Debe tener un DNI")
    @Pattern(regexp ="^[0-9]+$" , message= "El DNI solo puede contener caracteres numericos entre 0 y 9")
    @Min(value= 1,message="El DNI debe ser mayor a 0")
    @Size(max=8, message="El DNI debe tener 8 digitos como máximo")
    private Long dni;
    @NotEmpty(message="Debe tener un número de teléfono")
    @NotBlank(message="Debe tener un número de teléfono")
    private Long telefono;
    @NotBlank(message="Debe tener un email")
    @NotEmpty(message="Debe tener un email")
    //@Email(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "El email no es válido")
    private String email;
    @PastOrPresent(message="Debe ser una fecha válida")
    private LocalDate fechaNacimiento;
    private String username;
    private String password;
    private List<ReservaRequestDTO> listaReservas;
}
