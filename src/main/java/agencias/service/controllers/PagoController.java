package agencias.service.controllers;

import agencias.service.models.dto.Request.PagoRequestDTO;
import agencias.service.service.PagoService;
import agencias.service.service.impl.PagoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app")
public class PagoController {

    private PagoService pagoService;

    public PagoController(PagoServiceImpl pagoService) {
        this.pagoService = pagoService;
    }

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




}
