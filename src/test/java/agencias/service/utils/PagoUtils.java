package agencias.service.utils;

import agencias.service.models.dto.Request.PagoRequestDTO;
import agencias.service.models.dto.Response.PagoResponseDTO;
import agencias.service.models.entity.Pago;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PagoUtils {

    public static PagoRequestDTO pagoDto1(){
        PagoRequestDTO p = new PagoRequestDTO();
        p.setIdPago(1L);
        p.setFecha_pago(LocalDate.parse("2023-11-30"));
        p.setNum_transaccion(121);
        p.setMonto(150000.0);
        p.setReservaDto(null);
        p.setReporteDto(null);
        return p;
    }

    public static PagoRequestDTO pagoDto2(){
        PagoRequestDTO p = new PagoRequestDTO();
        p.setFecha_pago(LocalDate.parse("2023-12-01"));
        p.setNum_transaccion(356);
        p.setMonto(123000.0);
        p.setReservaDto(null);
        p.setReporteDto(null);
        return p;
    }

    public static List<PagoRequestDTO> pagoListDto(){
        return List.of(pagoDto1(), pagoDto2());
    }

    public static List<PagoResponseDTO> pagoListResponseDto(){
        List<PagoResponseDTO> p = new ArrayList<>();
        PagoResponseDTO pagoResponseDto1 = new PagoResponseDTO();
        pagoResponseDto1.setPago(pagoDto1());
        PagoResponseDTO pagoResponseDto2 = new PagoResponseDTO();
        pagoResponseDto2.setPago(pagoDto2());
        p.add(pagoResponseDto1);
        p.add(pagoResponseDto2);
        return p;
    }

    public static Pago pago1(){
        Pago p = new Pago();
        p.setIdPago(1L);
        p.setFecha_pago(LocalDate.parse("2023-11-30"));
        p.setNum_transaccion(121);
        p.setMonto(150000.0);
        p.setReserva(null);
        return p;
    }

    public static Pago pago2(){
        Pago p = new Pago();
        p.setFecha_pago(LocalDate.parse("2023-12-01"));
        p.setNum_transaccion(356);
        p.setMonto(123000.0);
        p.setReserva(null);
        return p;
    }

    public static List<Pago> listaPagos(){
        return List.of(pago1(),pago2());
    }

}
