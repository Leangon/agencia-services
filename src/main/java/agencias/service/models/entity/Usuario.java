package agencias.service.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @NotEmpty(message = "El nombre no puede estar vacio")
    @Size(min = 4, max = 12, message = "El tamaño del nombre debe ser entre 4 y 12 caracteres")
    @Column(name = "nombre")
    private String nombre;

    @NotEmpty(message = "El apellido no puede estar vacio")
    @Size(min = 4, max = 12, message = "El tamaño del apellido debe ser entre 4 y 12 caracteres")
    @Column(name = "apellido")
    private String apellido;

    @NotEmpty(message = "El DNI es requerido")
    @Column(name = "dni", unique = true)
    private Long dni;

    @NotEmpty
    @Column(name = "telefono", unique = true)
    private Long telefono;

    @NotNull(message = "El email es requerido")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "La fecha de nacimiento es requerido")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

}
