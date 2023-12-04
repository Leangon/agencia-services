package agencias.service.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="aerolineas")
public class Aerolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_aerolinea")
    private Long idAerolinea;

    @NotEmpty(message = "Razon social no puede estar vacio")
    @Size(min = 4, max = 12, message = "Razon social debe tener entre 5 y 30 caracteres")
    @Column(name = "razon_social")
    private String razonSocial;

    @NotEmpty(message="El cuit no puede estar vacio")
    @Column(name = "cuit")
    private String cuit;
/*
    @OneToOne(mappedBy = "aerolinea")
    private Promocion promocion;

    @NotEmpty(message = "Debe tener vuelos asociados")
    @OneToMany(mappedBy = "aerolinea")
    private List<Vuelo> listaVuelos;
*/
}
