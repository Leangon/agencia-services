package agencias.service.utils;

import agencias.service.models.entity.Usuario;

import java.time.LocalDate;

public class UsuarioUtils {

    public static Usuario usuario1(){
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L);
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setDni(31540692L);
        usuario.setEmail("jPerez@Gmail.com");
        usuario.setFechaNacimiento(LocalDate.of(1984, 8, 4));
        usuario.setTelefono(1150478963L);

        return usuario;
    }
}
