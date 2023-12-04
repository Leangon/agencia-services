package agencias.service.models.entity;

import agencias.service.models.enums.TipoPago;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reservas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;

    @NotNull(message = "Debe incluir un medio de pago")
    @Column(name = "medio_pago")
    @Enumerated(EnumType.STRING)
    private TipoPago tipoPago;

    @NotNull(message = "Debe incluir una fecha de reserva")
    @Column(name = "fecha_reserva")
    private LocalDate fechaReserva;

    @NotNull(message = "Debe tener un pago asociado")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="fk_pago", referencedColumnName = "IdPago")
    private Pago pago;

    @NotNull(message = "Debe tener un vuelo asociado")
    @ManyToOne
    @JoinColumn(name = "fk_vuelo", referencedColumnName = "id_vuelo")
    private Vuelo vuelo;

    @NotEmpty(message = "Debe tener tickets asociados")
    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    List<Ticket> tickets;

    @NotNull(message = "Debe tener un usuario asociado")
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

}
