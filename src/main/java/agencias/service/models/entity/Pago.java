package agencias.service.models.entity;

import agencias.service.models.enums.TipoPago;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.boot.model.internal.BinderHelper;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pago")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdPago;

    @Positive(message = "Debe ser un número positivo")
    private Integer num_transaccion;

    @Positive(message = "Debe ser un número positivo")
    private Double monto;

    @NotNull(message = "Debe tener una fecha de pago")
    LocalDate fecha_pago;

    @NotNull(message = "Debe incluir una reserva asociada")
    @OneToOne(mappedBy = "pago", cascade = CascadeType.ALL)
    private Reserva reserva;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="fk_reporte", nullable = false)
    private Reporte reporte;
}
