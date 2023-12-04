package agencias.service.utils;

import agencias.service.models.dto.Request.*;
import agencias.service.models.entity.Aerolinea;
import agencias.service.models.entity.Promocion;
import agencias.service.models.entity.Usuario;
import agencias.service.models.entity.Vuelo;

import java.time.LocalDate;
import java.util.List;

public class PromocionUtils {

    public static PromocionRequestDto promoDto1(){
        PromocionRequestDto dto = new PromocionRequestDto();
        UsuarioRequestDTO usuario = new UsuarioRequestDTO();
        AerolineaRequestDTO aereo = new AerolineaRequestDTO();
        VueloRequestDTO vuelo = new VueloRequestDTO();
        vuelo.setNumVuelo(1256);
        vuelo.setFecha(LocalDate.now());
        aereo.setRazonSocial("Latam SA");
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        dto.setDescuentoPromocional(25);
        dto.setUsuario(usuario);
        dto.setAerolinea(aereo);
        dto.setVuelo(vuelo);
        return dto;
    }

    public static PromocionRequestDto promoDto2(){
        PromocionRequestDto promo = new PromocionRequestDto();
        UsuarioRequestDTO usuario = new UsuarioRequestDTO();
        AerolineaRequestDTO aereo = new AerolineaRequestDTO();
        VueloRequestDTO vuelo = new VueloRequestDTO();
        vuelo.setNumVuelo(1325);
        vuelo.setFecha(LocalDate.now());
        aereo.setRazonSocial("Avianca SA");
        usuario.setNombre("Pedro");
        usuario.setApellido("Farias");
        promo.setDescuentoPromocional(30);
        promo.setUsuario(usuario);
        promo.setAerolinea(aereo);
        promo.setVuelo(vuelo);
        return promo;
    }

    public static Promocion promo1(){
        Promocion promo = new Promocion();
        Usuario usuario = new Usuario();
        Aerolinea aereo = new Aerolinea();
        Vuelo vuelo = new Vuelo();
        vuelo.setNumVuelo(1256);
        vuelo.setFecha(LocalDate.now());
        aereo.setRazonSocial("Latam SA");
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        promo.setDescuentoPromocional(25);
        promo.setUsuario(usuario);
        promo.setAerolinea(aereo);
        promo.setVuelo(vuelo);
        return promo;
    }

    public static Promocion promo2(){
        Promocion promo = new Promocion();
        Usuario usuario = new Usuario();
        Aerolinea aereo = new Aerolinea();
        Vuelo vuelo = new Vuelo();
        vuelo.setNumVuelo(1325);
        vuelo.setFecha(LocalDate.now());
        aereo.setRazonSocial("Avianca SA");
        usuario.setNombre("Pedro");
        usuario.setApellido("Farias");
        promo.setDescuentoPromocional(30);
        promo.setUsuario(usuario);
        promo.setAerolinea(aereo);
        promo.setVuelo(vuelo);
        return promo;
    }

    public static Promocion promo1modificado(){
        Promocion promo = new Promocion();
        Usuario usuario = new Usuario();
        Aerolinea aereo = new Aerolinea();
        Vuelo vuelo = new Vuelo();
        vuelo.setNumVuelo(1359);
        vuelo.setFecha(LocalDate.now());
        aereo.setRazonSocial("Iberia SA");
        usuario.setNombre("Ana");
        usuario.setApellido("Sosa");
        promo.setDescuentoPromocional(30);
        promo.setUsuario(usuario);
        promo.setAerolinea(aereo);
        promo.setVuelo(vuelo);
        return promo;
    }

    public static PromocionRequestDto promo1modificadoDto(){
        PromocionRequestDto promo = new PromocionRequestDto();
        UsuarioRequestDTO usuario = new UsuarioRequestDTO();
        AerolineaRequestDTO aereo = new AerolineaRequestDTO();
        VueloRequestDTO vuelo = new VueloRequestDTO();
        vuelo.setNumVuelo(1359);
        vuelo.setFecha(LocalDate.now());
        aereo.setRazonSocial("Iberia SA");
        usuario.setNombre("Ana");
        usuario.setApellido("Sosa");
        promo.setDescuentoPromocional(30);
        promo.setUsuario(usuario);
        promo.setAerolinea(aereo);
        promo.setVuelo(vuelo);
        return promo;
    }

    public static PromocionCompleteDTO promocionCompleteDto1(){
        PromocionCompleteDTO dto = new PromocionCompleteDTO();
        UsuarioRequestDTO usuario = new UsuarioRequestDTO();
        AerolineaRequestDTO aereo = new AerolineaRequestDTO();
        VueloRequestDTO vuelo = new VueloRequestDTO();
        vuelo.setNumVuelo(1256);
        vuelo.setFecha(LocalDate.now());
        aereo.setRazonSocial("Latam SA");
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        dto.setIdPromocion(1L);
        dto.setDescuentoPromocional(25);
        dto.setUsuario(usuario);
        dto.setAerolinea(aereo);
        dto.setVuelo(vuelo);
        return dto;
    }

    public static List<Promocion> listaPromociones() {
      return List.of(promo1(), promo2());
    }

    public static List<PromocionRequestDto> listaPromocionesDto() {
        return List.of(promoDto1(), promoDto2());
    }
}
