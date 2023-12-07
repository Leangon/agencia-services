package agencias.service.models.entity;

import agencias.service.models.enums.ERol;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message ="Debe indicarse el nombre del usuario")
    @Enumerated(EnumType.STRING)
    private ERol name;
}