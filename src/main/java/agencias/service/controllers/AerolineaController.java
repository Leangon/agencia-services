package agencias.service.controllers;


import agencias.service.models.dto.Request.AerolineaRequestDTO;
import agencias.service.models.dto.Response.AerolineaResponseDTO;
import agencias.service.models.entity.Aerolinea;
import agencias.service.service.AerolineaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app")
public class AerolineaController {
        private final AerolineaService aerolineaService;

        public AerolineaController(AerolineaService aerolineaService) {
            this.aerolineaService = aerolineaService;
        }

@GetMapping("/listado")
        public ResponseEntity<?> listarAerolinea() {
         return new ResponseEntity<> ( aerolineaService.listarAerolinea(), HttpStatus.OK );
    }

@GetMapping("/obtenerporid/{id}")
    public ResponseEntity<?> obtenerAerolinea(@PathVariable Long id){
        return new ResponseEntity<> (aerolineaService.obtenerAerolinea(id),HttpStatus.OK);
}
@PostMapping("/guardar")
    public ResponseEntity<?> guardarAerolinea(AerolineaRequestDTO aerolinea){
         return new ResponseEntity<>(aerolineaService.guardarAerolinea(aerolinea),HttpStatus.OK) ;
}
@DeleteMapping("/borrar({id}")
    public ResponseEntity<?> borrarAerolinea(@PathVariable long id){
            return new ResponseEntity<>(aerolineaService.borrarAerolinea(id),HttpStatus.OK);
}

        }



