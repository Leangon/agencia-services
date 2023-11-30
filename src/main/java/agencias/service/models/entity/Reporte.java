package agencias.service.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "reporte")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReporte;
    private Integer cant_ventas;
    private Double ingresos_generados;

    @OneToMany(mappedBy = "reporte", cascade = CascadeType.ALL)
    private List<Pago> listaPagos;


}
