package agencias.service.models.entity;

import agencias.service.models.enums.Clase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Long idTicket;

    @Positive(message = "Debe ser un numero positivo")
    @Column(name = "num_asiento")
    private int numAsiento;

    @NotNull(message = "Debe incluir una clase")
    @Enumerated(EnumType.STRING)
    @Column(name = "clase")
    private Clase clase;

    @NotNull(message = "Debe incluir un pasajero")
    @Embedded
    private Pasajero pasajero;

    @Positive(message = "Debe ser un numero positivo")
    @Column(name = "precio")
    private double precio;

    @ManyToOne
    @JoinColumn(name = "fk_vuelo", referencedColumnName = "id_vuelo")
    private Vuelo vuelo;

    @ManyToOne
    @JoinColumn(name = "fk_reserva", referencedColumnName = "id_reserva")
    private Reserva reserva;
}
