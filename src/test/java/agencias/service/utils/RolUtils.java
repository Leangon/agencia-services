package agencias.service.utils;

import agencias.service.models.dto.Request.RolRequestDTO;
import agencias.service.models.entity.Rol;
import agencias.service.models.enums.ERol;

import java.util.List;

public class RolUtils {

    public static Rol rol1(){
        Rol rol = new Rol();
        rol.setName(ERol.USER);
        return rol;
    }

    public static Rol rol2(){
        Rol rol = new Rol();
        rol.setName(ERol.ADMIN);
        return rol;
    }

    public static RolRequestDTO rolDto(){
        RolRequestDTO rol = new RolRequestDTO();
        rol.setName(ERol.AGENTE_VENTAS);
        return rol;
    }

    public static RolRequestDTO rolDto2(){
        RolRequestDTO rol = new RolRequestDTO();
        rol.setName(ERol.ADMIN);
        return rol;
    }

    public static List<Rol> listaRoles(){
        return List.of(rol1(),rol2());
    }
}
