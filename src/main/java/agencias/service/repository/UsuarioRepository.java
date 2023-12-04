package agencias.service.repository;

import agencias.service.models.dto.Response.UsuarioResponseDTO;
import agencias.service.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByDni(Long dni);

}
