package agencias.service.controllers;

import agencias.service.models.dto.Request.ReporteRequestDTO;
import agencias.service.service.ReporteService;
import agencias.service.service.impl.ReporteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app")
public class ReporteController {
    /*
        @Autowired
    PagoServiceImpl pagoService;

    @GetMapping("/pago")
    public ResponseEntity<?> listarPagos(){
        return new ResponseEntity<> ( pagoService.listarPagos (), HttpStatus.OK );
    }
    @PostMapping("/pago")
    public ResponseEntity<?> guardarPago(@RequestBody PagoRequestDTO pagoDto){
        return new ResponseEntity<> ( pagoService.crearPago ( pagoDto ), HttpStatus.OK );
    }
    @GetMapping("/pago/{idPago}")
    public ResponseEntity<?>pagoPorId(@PathVariable Long idPago){
        return new ResponseEntity<> ( pagoService.traerPagoPorId ( idPago ), HttpStatus.OK );
    }
    @DeleteMapping("/borrarPago/{idPago}")
    public ResponseEntity<?> eliminarPago(@PathVariable long idPago){
        return new ResponseEntity<> ( pagoService.borrarPago ( idPago ), HttpStatus.OK );
    }

     */
      private ReporteService service;

      public ReporteController(ReporteServiceImpl service) {
            this.service = service;
      }
      @GetMapping("/reportes")
      public ResponseEntity<?> traerReportes(){
            return new ResponseEntity<> ( service.listarReporte (), HttpStatus.OK );
      }
      @PostMapping("/reporte")
      public ResponseEntity<?> crearReporte(@RequestBody ReporteRequestDTO reporteDto){
            return new ResponseEntity<> ( service.crearReporte (reporteDto ), HttpStatus.OK );
      }
      @GetMapping("/reporte/{idReporte}")
      public ResponseEntity<?> traerUnReporte(@PathVariable Long idReporte){
            return new ResponseEntity<> ( service.traerReportePorId ( idReporte ), HttpStatus.OK );
      }
      @DeleteMapping("/reporte/{idReporte}")
      public ResponseEntity<?> borrarReporte(@PathVariable Long idReporte){
            return new ResponseEntity<> ( service.eliminarReporte ( idReporte ), HttpStatus.OK );
      }

}
