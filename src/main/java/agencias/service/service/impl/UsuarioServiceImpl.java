package agencias.service.service.impl;

import agencias.service.exceptions.CustomException;
import agencias.service.models.dto.Request.UsuarioRequestDTO;
import agencias.service.models.dto.Response.UsuarioResponseDTO;
import agencias.service.models.entity.Mensaje;
import agencias.service.models.entity.Usuario;
import agencias.service.repository.UsuarioRepository;
import agencias.service.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UsuarioResponseDTO createUsuario(UsuarioRequestDTO usuarioRequestDTO) throws CustomException {
        try {
            Optional<Usuario> usuarioOptional = usuarioRepository.findByDni(usuarioRequestDTO.getDni());
            if (usuarioOptional.isPresent()){
                throw new CustomException (HttpStatus.OK, "El Usuario con DNI: " + usuarioRequestDTO.getDni() + " ya existe");
            }
            Usuario usuario = new Usuario();
            usuario.setNombre(usuarioRequestDTO.getNombre());
            usuario.setApellido(usuarioRequestDTO.getApellido());
            usuario.setDni(usuarioRequestDTO.getDni());
            usuario.setTelefono(usuarioRequestDTO.getTelefono());
            usuario.setEmail(usuarioRequestDTO.getEmail());
            usuario.setFechaNacimiento(usuarioRequestDTO.getFechaNacimiento());

            Usuario usuarioPersist = usuarioRepository.save(usuario);
            return mapToUsuarioResponseDto(usuarioPersist);

        } catch (Exception e){
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardad usuario" + e.getMessage());
        }
    }

    @Override
    public UsuarioResponseDTO getUsuarioById(Long id) throws CustomException {
        return null;
    }

    @Override
    public Mensaje deleteUsuarioById(Long id) throws CustomException {
        return null;
    }

    @Override
    public UsuarioResponseDTO updateUsuario(UsuarioRequestDTO usuarioRequestDTO) throws CustomException {
        return null;
    }

    @Override
    public List<UsuarioResponseDTO> usuarioList() {
        return null;
    }

    @Override
    public UsuarioResponseDTO mapToUsuarioResponseDto(Usuario usuario) {
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();

        usuarioResponseDTO.setNombre(usuario.getNombre());
        usuarioResponseDTO.setApellido(usuario.getApellido());
        usuarioResponseDTO.setEmail(usuario.getEmail());
        return usuarioResponseDTO;
    }
}
