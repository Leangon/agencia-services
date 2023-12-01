package agencias.service.models.entity;

import agencias.service.models.enums.Clase;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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

    @Column(name = "nro_asiento",unique = true)
    private Long nroAsiento;

    @Column(name = "clase")
    private Clase clase;

    @Column(name = "fecha_reserva")
    private LocalDate fechaReserva;

    @Column(name = "precio")
    private Double precio;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="fk_pago", referencedColumnName = "IdPago")
    private Pago pago;

}
