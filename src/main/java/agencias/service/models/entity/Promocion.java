package agencias.service.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "promociones")
public class Promocion {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_promocion")
   @Positive(message = "No puede ser un número negativo")
   private Long idPromocion;

   @Column(name = "descuento_promocional")
   @Positive(message = "No puede ser un número negativo")
   private int descuentoPromocional;
}