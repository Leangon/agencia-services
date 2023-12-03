package agencias.service.utils;

import agencias.service.models.dto.Request.AerolineaRequestDTO;
import agencias.service.models.dto.Request.TicketCompleteDTO;
import agencias.service.models.dto.Request.TicketRequestDTO;
import agencias.service.models.dto.Request.VueloRequestDTO;
import agencias.service.models.dto.Response.TicketResponseDTO;
import agencias.service.models.entity.*;
import agencias.service.models.enums.Clase;
import java.time.LocalDate;
import java.util.List;

public class TicketUtils {

    public static TicketRequestDTO ticketDto1() {
        TicketRequestDTO ticketDto = new TicketRequestDTO();
        Itinerario itinerario = new Itinerario("buenos aires", "argentina"
                , "madrid", "españa", "10AM", "20PM");
        AerolineaRequestDTO aerolinea = new AerolineaRequestDTO();
        aerolinea.setRazonSocial("Latam S.A");
        ticketDto.setClase(Clase.BUSINESS);
        ticketDto.setPrecio(85000.0);
        ticketDto.setNumAsiento(125);
        ticketDto.setPasajero(new Pasajero("juan Perez", "35120475", 39));
        ticketDto.setVuelo(new VueloRequestDTO(1124, 250, true, LocalDate.now(),
                itinerario, null, null, null, aerolinea));
        return ticketDto;
    }

    public static TicketRequestDTO ticketDto2() {
        TicketRequestDTO ticket = new TicketRequestDTO();
        Itinerario itinerario = new Itinerario("buenos aires", "argentina"
                , "Paris", "Francia", "8AM", "19PM");
        AerolineaRequestDTO aerolinea = new AerolineaRequestDTO();
        aerolinea.setRazonSocial("Iberia SA");
        VueloRequestDTO vuelo = new VueloRequestDTO();
        vuelo.setNumVuelo(1543);
        vuelo.setCantPasajeros(300);
        vuelo.setDisponibilidad(true);
        vuelo.setFecha(LocalDate.now());
        vuelo.setItinerario(itinerario);
        vuelo.setAerolinea(aerolinea);
        ticket.setClase(Clase.ECONOMIC);
        ticket.setPrecio(110000.0);
        ticket.setNumAsiento(57);
        ticket.setPasajero(new Pasajero("Carla Sanchez", "34102369", 37));
        ticket.setVuelo(vuelo);
        return ticket;
    }

    public static Ticket ticket1() {
        Ticket ticket = new Ticket();
        Itinerario itinerario = new Itinerario("buenos aires", "argentina"
                , "madrid", "españa", "10AM", "20PM");
        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setRazonSocial("Latam S.A");
        Vuelo vuelo = new Vuelo();
        vuelo.setNumVuelo(1124);
        vuelo.setCantPasajeros(250);
        vuelo.setDisponibilidad(true);
        vuelo.setFecha(LocalDate.now());
        vuelo.setItinerario(itinerario);
        vuelo.setAerolinea(aerolinea);
        ticket.setClase(Clase.BUSINESS);
        ticket.setPrecio(85000.0);
        ticket.setNumAsiento(125);
        ticket.setPasajero(new Pasajero("juan Perez", "35120475", 39));
        ticket.setVuelo(vuelo);
        return ticket;
    }

    public static Ticket ticket2() {
        Ticket ticket = new Ticket();
        Itinerario itinerario = new Itinerario("buenos aires", "argentina"
                , "Paris", "Francia", "8AM", "19PM");
        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setRazonSocial("Iberia SA");
        Vuelo vuelo = new Vuelo();
        vuelo.setNumVuelo(1543);
        vuelo.setCantPasajeros(300);
        vuelo.setDisponibilidad(true);
        vuelo.setFecha(LocalDate.now());
        vuelo.setItinerario(itinerario);
        vuelo.setAerolinea(aerolinea);
        ticket.setClase(Clase.ECONOMIC);
        ticket.setPrecio(110000.0);
        ticket.setNumAsiento(57);
        ticket.setPasajero(new Pasajero("Carla Sanchez", "34102369", 37));
        ticket.setVuelo(vuelo);
        return ticket;
    }
    public static Ticket ticket1modificado() {
        Ticket ticket = new Ticket();
        Itinerario itinerario = new Itinerario("buenos aires", "argentina"
                , "madrid", "españa", "10AM", "20PM");
        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setRazonSocial("Avianca S.A");
        Vuelo vuelo = new Vuelo();
        vuelo.setNumVuelo(1125);
        vuelo.setCantPasajeros(259);
        vuelo.setDisponibilidad(true);
        vuelo.setFecha(LocalDate.now());
        vuelo.setItinerario(itinerario);
        vuelo.setAerolinea(aerolinea);
        ticket.setClase(Clase.ECONOMIC);
        ticket.setPrecio(76000.0);
        ticket.setNumAsiento(111);
        ticket.setPasajero(new Pasajero("Carlos Perez", "35120475", 40));
        ticket.setVuelo(vuelo);
        return ticket;
    }

    public static TicketRequestDTO ticketDto1modificado() {
        TicketRequestDTO ticket = new TicketRequestDTO();
        Itinerario itinerario = new Itinerario("buenos aires", "argentina"
                , "madrid", "españa", "10AM", "20PM");
        AerolineaRequestDTO aerolinea = new AerolineaRequestDTO();
        aerolinea.setRazonSocial("Avianca S.A");
        VueloRequestDTO vuelo = new VueloRequestDTO();
        vuelo.setNumVuelo(1125);
        vuelo.setCantPasajeros(259);
        vuelo.setDisponibilidad(true);
        vuelo.setFecha(LocalDate.now());
        vuelo.setItinerario(itinerario);
        vuelo.setAerolinea(aerolinea);
        ticket.setClase(Clase.ECONOMIC);
        ticket.setPrecio(76000.0);
        ticket.setNumAsiento(111);
        ticket.setPasajero(new Pasajero("Carlos Perez", "35120475", 40));
        ticket.setVuelo(vuelo);
        return ticket;
    }

    public static TicketCompleteDTO ticketCompleteDto1() {
        TicketCompleteDTO ticketDto = new TicketCompleteDTO();
        Itinerario itinerario = new Itinerario("buenos aires", "argentina"
                , "madrid", "españa", "10AM", "20PM");
        AerolineaRequestDTO aerolinea = new AerolineaRequestDTO();
        aerolinea.setRazonSocial("Latam S.A");
        ticketDto.setIdTicket(1L);
        ticketDto.setClase(Clase.BUSINESS);
        ticketDto.setPrecio(85000.0);
        ticketDto.setNumAsiento(125);
        ticketDto.setPasajero(new Pasajero("juan Perez", "35120475", 39));
        ticketDto.setVuelo(new VueloRequestDTO(1124, 250, true, LocalDate.now(),
                itinerario, null, null, null, aerolinea));
        return ticketDto;
    }
    public static List<Ticket> listaTickets(){
       return List.of(ticket1(), ticket2());
    }

    public static List<TicketRequestDTO> listaTicketsDto(){
        return List.of(ticketDto1(), ticketDto2());
    }

}