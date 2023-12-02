package agencias.service.controllers;

import agencias.service.models.dto.Request.VueloRequestDTO;
import agencias.service.service.VueloService;
import agencias.service.service.impl.VueloServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vuelo")
public class VueloController {

    private VueloService vueloService;

    public VueloController(VueloServiceImpl vueloService){
        this.vueloService = vueloService;
    }

    @GetMapping("/vuelo")
    public ResponseEntity<?> listarVuelos(){
        return new ResponseEntity<>(vueloService.mostrarVuelos(), HttpStatus.OK);
    }

    @PostMapping("/vuelo")
    public ResponseEntity<?> guardarVuelo(@RequestBody VueloRequestDTO vueloRequestDTO){
            return new ResponseEntity<>(vueloService.crearVuelo(vueloRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/vuelo/{idVuelo}")
    public ResponseEntity<?> traerVuelo(@PathVariable Long idVuelo){
        return new ResponseEntity<>(vueloService.vueloPorId(idVuelo), HttpStatus.OK);
    }

    @PutMapping("/vuelo/{idVuelo}")
    public ResponseEntity<?> modificarVuelo(@PathVariable Long idVuelo){
        return new ResponseEntity<>(vueloService.editarVuelo(idVuelo), HttpStatus.OK);
    }

    @DeleteMapping("/vuelo/{idVuelo}")
    public ResponseEntity<?> eliminarVuelo(@PathVariable Long idVuelo){
        return new ResponseEntity<>(vueloService.eliminarVueloPorId(idVuelo), HttpStatus.OK);
    }

}
