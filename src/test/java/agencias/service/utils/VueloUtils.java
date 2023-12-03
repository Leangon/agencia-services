package agencias.service.utils;

import agencias.service.models.dto.Request.VueloRequestDTO;
import agencias.service.models.dto.Response.VueloResponseDTO;
import agencias.service.models.entity.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VueloUtils {

    public static VueloRequestDTO vueloDTO(){
        VueloRequestDTO vuelo = new VueloRequestDTO();
        vuelo.setIdVuelo(1L);
        vuelo.setNumVuelo(134);
        vuelo.setCantPasajeros(87);
        vuelo.setDisponibilidad(true);
        vuelo.setFecha(LocalDate.of(2023,12,25));
        vuelo.setHoraSalida("23:00");
        vuelo.setHoraLLegada("04:30");
        vuelo.setListaReservas(null);
        vuelo.setListaTickets(null);
        vuelo.setAerolinea(null);
        vuelo.setItinerario(null);

        return vuelo;
    }

    public static VueloRequestDTO vueloDTO2(){
        VueloRequestDTO vuelo = new VueloRequestDTO();
        vuelo.setNumVuelo(654);
        vuelo.setCantPasajeros(264);
        vuelo.setDisponibilidad(false);
        vuelo.setFecha(LocalDate.of(2023,1,25));
        vuelo.setHoraSalida("12:00");
        vuelo.setHoraLLegada("16:30");
        vuelo.setListaReservas(null);
        vuelo.setListaTickets(null);
        vuelo.setAerolinea(null);
        vuelo.setItinerario(null);

        return vuelo;
    }

    public static List<VueloResponseDTO> listarVuelosDTO(){
        List<VueloResponseDTO> listaVuelos = new ArrayList<>();
        VueloResponseDTO vueloResponseDTO1 = new VueloResponseDTO();
        vueloResponseDTO1.setVuelo(vueloDTO());
        VueloResponseDTO vueloResponseDTO2 = new VueloResponseDTO();
        vueloResponseDTO2.setVuelo(vueloDTO2());

        listaVuelos.add(vueloResponseDTO1);
        listaVuelos.add(vueloResponseDTO2);

        return listaVuelos;
    }

    public static Vuelo vuelo1(){
        Vuelo vuelo = new Vuelo();
        vuelo.setIdVuelo(1L);
        vuelo.setNumVuelo(134);
        vuelo.setCantPasajeros(87);
        vuelo.setDisponibilidad(true);
        vuelo.setFecha(LocalDate.of(2023,12,25));
        vuelo.setHoraSalida("23:00");
        vuelo.setHoraLLegada("04:30");
        vuelo.setListaReservas(null);
        vuelo.setListaTickets(null);
        vuelo.setAerolinea(null);
        vuelo.setItinerario(null);
        return vuelo;
    }

    public static Vuelo vuelo2(){
        Vuelo vuelo = new Vuelo();
        vuelo.setIdVuelo(1L);
        vuelo.setNumVuelo(134);
        vuelo.setCantPasajeros(87);
        vuelo.setDisponibilidad(true);
        vuelo.setFecha(LocalDate.of(2023,12,25));
        vuelo.setHoraSalida("23:00");
        vuelo.setHoraLLegada("04:30");
        vuelo.setListaReservas(null);
        vuelo.setListaTickets(null);
        vuelo.setAerolinea(null);
        vuelo.setItinerario(null);
        return vuelo;
    }

    public static List<Vuelo> ListaVuelos(){
        return List.of(vuelo1(), vuelo2());
    }

}
