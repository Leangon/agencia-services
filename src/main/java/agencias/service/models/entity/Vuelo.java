package agencias.service.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vuelo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vuelo")
    private Long idVuelo;

    @NotBlank(message = "No puede quedar vacío el numero de vuelo")
    @Column(name = "num_vuelo", unique = true)
    private int numVuelo;

    @Min(0)
    @Column(name = "cant_pasajeros")
    private int cantAsientos;

    @NotBlank(message = "El vuelo debe indicar si tiene disponibilidad de pasajeros o no")
    @Column(name = "disponibilidad")
    private boolean disponibilidad;

    @NotBlank(message = "El vuelo debe de tener una fecha")
    @Column(name = "fecha")
    private LocalDate fecha;

    @Embedded
    private Itinerario itinerario;

    @NotNull(message = "Debe tener una aerolínea asociada")
    @ManyToOne
    @JoinColumn(name = "fk_aerolinea", referencedColumnName = "id_aerolinea")
    private Aerolinea aerolinea;
}
