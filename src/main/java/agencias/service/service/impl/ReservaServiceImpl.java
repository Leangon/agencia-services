package agencias.service.service.impl;

import agencias.service.exceptions.ReservaNotFoundException;
import agencias.service.models.dto.Response.ReporteResponseDTO;
import agencias.service.models.entity.Reserva;
import agencias.service.models.entity.Ticket;
import agencias.service.repository.ReservaRepository;
import agencias.service.service.ReservaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

@Service
public class ReservaServiceImpl implements ReservaService {

    ReservaRepository reservaRepo;

    public ReservaServiceImpl(ReservaRepository reservaRepo) {
        this.reservaRepo = reservaRepo;
    }

    @Override
    public ReporteResponseDTO generarReporte(LocalDate date1, LocalDate date2) {
        List<Reserva> resultRepo = reservaRepo.findAll ();
        List<Reserva>result = new ArrayList<> ();
        for(Reserva res: resultRepo){
            if(res.getFechaReserva ().isAfter ( date1 ) && res.getFechaReserva ().isBefore ( date2 )){
                result.add(res);
            }
        }

   if(result.isEmpty ()){
            throw new ReservaNotFoundException ( "No existen reservas para el rango de fechas seleccionadas" );
        }
        ReporteResponseDTO reporte = new ReporteResponseDTO ();

        int cantidadReservas = result.size ();
        Double ingresosTotales = 0.00;


        //contar cuantas veces repite el destino
        Map<String,Integer> contadorDestinos = new HashMap<> ();

        String destino = null;
        //tomo de la lista que se filtro la fecha los tickets para calcular los ingresos generados y destinos
        for(Reserva reserva: result){
              destino = reserva.getVuelo ().getItinerario ().getCiudadDestino ();
              contadorDestinos.put(destino, contadorDestinos.getOrDefault (destino,0 ) + 1);
            for (Ticket ticket : reserva.getTickets ( )) {
               ingresosTotales +=  ticket.getPrecio ();

            }

        }

        reporte.setNumeroVuelosVendidos ( cantidadReservas );
        reporte.setIngresosGenerados ( ingresosTotales );
        reporte.setDestinosPopulares ( contadorDestinos );





        return reporte;
    }
}
