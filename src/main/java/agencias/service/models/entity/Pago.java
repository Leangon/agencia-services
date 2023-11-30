package agencias.service.models.entity;

import agencias.service.models.enums.TipoPago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.boot.model.internal.BinderHelper;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pago")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdPago;
    private Integer num_transaccion;
    private TipoPago tipoPago;
    private LocalDate fecha_pago;
    private Double monto;
    @OneToMany(mappedBy = "pago", cascade = CascadeType.ALL)
    private List<Reserva> reserva;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="fk_reporte", nullable = false)
    private Reporte reporte;

}
