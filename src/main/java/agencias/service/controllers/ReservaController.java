package agencias.service.controllers;

import agencias.service.models.dto.Response.ReporteResponseDTO;
import agencias.service.service.ReservaService;
import agencias.service.service.impl.ReservaServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
@RestController
@RequestMapping("/api")
@Validated
public class ReservaController {
    ReservaService reservaServ;

    public ReservaController(ReservaServiceImpl reservaServ) {
        this.reservaServ = reservaServ;
    }

//creacion de reportes cantidad de reservas entre fechas

    @GetMapping("/reporte")
    public  ResponseEntity<?> generarReporte(
                                             @NotNull(message = "Debe indicarse una fecha") @RequestParam
                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate since,
                                             @NotNull(message = "Debe indicarse una fecha") @RequestParam
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to){



        return new ResponseEntity<> (reservaServ.generarReporte(since, to), HttpStatus.OK );
    }

    @GetMapping("/reporte/{fecha}")
    public ResponseEntity<?>reporteParaUnaFecha(@NotNull(message = "Debe indicarse una fecha")
                                                    @PathVariable(name = "fecha")
                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha){
        return new ResponseEntity<> ( reservaServ.generarReporteUnaFecha ( fecha ), HttpStatus.OK );
    }




}
