package agencias.service.service.impl;

import agencias.service.models.dto.Response.ReservasByUserResponseDTO;
import agencias.service.models.entity.Reserva;
import agencias.service.models.entity.Usuario;
import agencias.service.models.entity.Vuelo;
import agencias.service.repository.ReservaRepository;
import agencias.service.repository.UsuarioRepository;
import agencias.service.service.ReservaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    ReservaRepository repository;

    UsuarioRepository usuarioRepository;

    public ReservaServiceImpl(ReservaRepository repository, UsuarioRepository userRepo) {
        this.repository = repository;
        this.usuarioRepository = userRepo;
    }

    @Override
    public ReservasByUserResponseDTO reservasByUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No existen usuarios con ese id"));
        List<Reserva> reservas = repository.findReservaByIdUsuario(id);
        return new ReservasByUserResponseDTO("Reservas efectuadas por " +
                usuario.getNombre() + usuario.getApellido() + ": \n", reservas);
    }
}
