package agencias.service.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "itinerario")
public class Itinerario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_itinerario")
    @Positive(message = "No puede ser un número negativo")
    private Long idItinerario;

    @Column(name = "ciudad_origen")
    @NotBlank(message = "Debe incluir una ciudad")
    private String ciudadOrigen;

    @Column(name = "pais_origen")
    @NotBlank(message = "Debe incluir un pais")
    private String paisOrigen;

    @Column(name = "ciudad_destino")
    @NotBlank(message = "Debe incluir una ciudad")
    private String ciudadDestino;

    @Column(name = "pais_destino")
    @NotBlank(message = "Debe incluir un pais")
    private String paisDestino;

    @OneToMany(mappedBy = "itinerario")
    private List<Vuelo> listaVuelos;

    @ManyToOne
    @JoinColumn(name = "fk_reporte", referencedColumnName = "idReporte")
    private Reporte reporte;
}
