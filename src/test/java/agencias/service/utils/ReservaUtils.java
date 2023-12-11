package agencias.service.utils;

import agencias.service.models.dto.Request.ReservaRequestDTO;
import agencias.service.models.dto.Request.ReservasByUserRequestDTO;
import agencias.service.models.dto.Request.TicketDTO;
import agencias.service.models.dto.Request.TicketRequestDTO;
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
                tickets, 90000D, usuario);
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
                tickets, 153000D, usuario);
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
        ticket.setPrecio(9000D);
        ticket.setClase(Clase.BUSINESS);
        ticket.setPrecio(1000);
        List<Ticket> tickets = List.of(ticket);
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(2L);
        usuario.setNombre("Ana");
        usuario.setApellido("Romero");
        return new Reserva(1L, TipoPago.TARJETA_CREDITO, LocalDate.now(), vuelo,
                tickets, 115500D, usuario);
    }

    public static ReservaRequestDTO reservaDto1(){
        Vuelo vuelo = new Vuelo();
        vuelo.setIdVuelo(1L);
        vuelo.setNumVuelo(123);
        vuelo.setFecha(LocalDate.parse("2023-12-21"));
        Itinerario itinerario = new Itinerario();
        itinerario.setCiudadOrigen("Montevideo");
        itinerario.setCiudadDestino("Londres");
        vuelo.setItinerario(itinerario);
        TicketRequestDTO ticket = new TicketRequestDTO();
        ticket.setNumAsiento(65);
        ticket.setPrecio(90000D);
        ticket.setClase(Clase.ECONOMIC);
        List<TicketRequestDTO> tickets = List.of(ticket);
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L);
        usuario.setNombre("Juan");
        usuario.setApellido("Silva");
        return new ReservaRequestDTO(ticket.getNumAsiento(), ticket.getClase(), LocalDate.now(), ticket.getPrecio(),
                TipoPago.PAGO_ONLINE, vuelo.getIdVuelo(), usuario.getIdUsuario() ,tickets);
    }

    public static ReservasByUserRequestDTO reservaByDto2(){
        Vuelo vuelo = new Vuelo();
        vuelo.setNumVuelo(5236);
        vuelo.setFecha(LocalDate.parse("2024-03-09"));
        Itinerario itinerario = new Itinerario();
        itinerario.setCiudadOrigen("Madrid");
        itinerario.setCiudadDestino("Paris");
        vuelo.setItinerario(itinerario);
        TicketDTO ticket = new TicketDTO();
        ticket.setNumAsiento(128);
        ticket.setClase(Clase.BUSINESS);
        ticket.setPrecio(1000);
        List<TicketDTO> tickets = List.of(ticket);
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(2L);
        usuario.setNombre("Ana");
        usuario.setApellido("Romero");
        return new ReservasByUserRequestDTO(LocalDate.of(2023, 10, 12),usuario, TipoPago.TARJETA_CREDITO,
                vuelo, tickets);
    }

    public static ReservasByUserRequestDTO reservaByDto3(){
        Vuelo vuelo = new Vuelo();
        vuelo.setNumVuelo(1235);
        vuelo.setFecha(LocalDate.parse("2023-06-27"));
        Itinerario itinerario = new Itinerario();
        itinerario.setCiudadOrigen("Buenos aires");
        itinerario.setCiudadDestino("Rio Janeiro");
        vuelo.setItinerario(itinerario);
        TicketDTO ticket = new TicketDTO();
        ticket.setNumAsiento(101);
        ticket.setClase(Clase.BUSINESS);
        ticket.setPrecio(1000);
        List<TicketDTO> tickets = List.of(ticket);
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(2L);
        usuario.setNombre("Ana");
        usuario.setApellido("Romero");
        return new ReservasByUserRequestDTO(LocalDate.now(), usuario, TipoPago.TARJETA_CREDITO,  vuelo,
                tickets);
    }
    
    public static List<Reserva> listaReservas(){
       return List.of(reserva2(), reserva3());
    }

    public static List<ReservasByUserRequestDTO> listaReservasByDto(){
        return List.of(reservaByDto2(),reservaByDto3());
    }
}
