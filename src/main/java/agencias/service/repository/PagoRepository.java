package agencias.service.repository;

import agencias.service.models.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago,Long> {
}
