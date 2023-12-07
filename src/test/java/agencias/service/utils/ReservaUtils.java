package agencias.service.utils;

import agencias.service.models.entity.*;
import agencias.service.models.enums.Clase;
import agencias.service.models.enums.TipoPago;

import java.time.LocalDate;
import java.util.List;

public class ReservaUtils {

    public static Reserva reserva1(){
        Vuelo vuelo = new Vuelo();
        vuelo.setNumVuelo(123);
        vuelo.setFecha(LocalDate.parse("2023-12-21"));
        Itinerario itinerario = new Itinerario();
        itinerario.setCiudadOrigen("Montevideo");
        itinerario.setCiudadDestino("Londres");
        vuelo.setItinerario(itinerario);
        Ticket ticket = new Ticket();
        ticket.setNumAsiento(65);
        ticket.setClase(Clase.ECONOMIC);
        List<Ticket> tickets = List.of(ticket);
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L);
        usuario.setNombre("Juan");
        usuario.setApellido("Silva");
        return new Reserva(1L, TipoPago.PAGO_ONLINE, LocalDate.now(), vuelo,
                tickets, usuario);
    }

    public static Reserva reserva2(){
        Vuelo vuelo = new Vuelo();
        vuelo.setNumVuelo(5236);
        vuelo.setFecha(LocalDate.parse("2024-03-09"));
        Itinerario itinerario = new Itinerario();
        itinerario.setCiudadOrigen("Madrid");
        itinerario.setCiudadDestino("Paris");
        vuelo.setItinerario(itinerario);
        Ticket ticket = new Ticket();
        ticket.setNumAsiento(128);
        ticket.setClase(Clase.BUSINESS);
        ticket.setPrecio(1000);
        List<Ticket> tickets = List.of(ticket);
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(2L);
        usuario.setNombre("Ana");
        usuario.setApellido("Romero");
        return new Reserva(1L, TipoPago.TARJETA_CREDITO, LocalDate.of(2023, 10, 12), vuelo,
                tickets, usuario);
    }

    public static Reserva reserva3(){
        Vuelo vuelo = new Vuelo();
        vuelo.setNumVuelo(1235);
        vuelo.setFecha(LocalDate.parse("2023-06-27"));
        Itinerario itinerario = new Itinerario();
        itinerario.setCiudadOrigen("Buenos aires");
        itinerario.setCiudadDestino("Rio Janeiro");
        vuelo.setItinerario(itinerario);
        Ticket ticket = new Ticket();
        ticket.setNumAsiento(101);
        ticket.setClase(Clase.BUSINESS);
        ticket.setPrecio(1000);
        List<Ticket> tickets = List.of(ticket);
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(2L);
        usuario.setNombre("Ana");
        usuario.setApellido("Romero");
        return new Reserva(1L, TipoPago.TARJETA_CREDITO, LocalDate.now(), vuelo,
                tickets, usuario);
    }
    
    public static List<Reserva> listaReservas(){
       return List.of(reserva2(), reserva3());
    }
}
