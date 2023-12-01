package agencias.service.repository;

import agencias.service.models.entity.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AerolineaRepository extends JpaRepository<Aerolinea,Long> {

}
