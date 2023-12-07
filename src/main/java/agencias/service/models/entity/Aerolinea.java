package agencias.service.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

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
    @Size(min = 1, max = 30, message = "Razon social debe tener entre 1 y 30 caracteres")
    @Column(name = "razon_social")
    private String razonSocial;

    @NotEmpty(message="El cuit no puede estar vacio")
    @Size(min=11, message="El cuit debe tener 11 caracteres")
    @Column(name = "cuit")
    private String cuit;




    public boolean equalsAerolinea(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aerolinea aerolinea = (Aerolinea) o;
        return Objects.equals(razonSocial, aerolinea.razonSocial) && Objects.equals(cuit, aerolinea.cuit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aerolinea aerolinea = (Aerolinea) o;
        return Objects.equals(idAerolinea, aerolinea.idAerolinea) && Objects.equals(razonSocial, aerolinea.razonSocial) && Objects.equals(cuit, aerolinea.cuit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAerolinea, razonSocial, cuit);
    }

}
