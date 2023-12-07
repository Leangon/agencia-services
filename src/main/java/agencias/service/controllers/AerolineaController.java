package agencias.service.controllers;


import agencias.service.models.dto.Request.AerolineaRequestDTO;
import agencias.service.models.dto.Response.AerolineaResponseDTO;
import agencias.service.models.entity.Aerolinea;
import agencias.service.service.AerolineaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
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
//"/obtenerporid/{id:[0-9]+}"
    public ResponseEntity<?> traerAerolineaPorId(@PathVariable @Positive(message = "Id debe ser positivo") Long id){
        return new ResponseEntity<> (aerolineaService.traerAerolineaPorId(id),HttpStatus.OK);
}
@PostMapping("/guardar")
    public ResponseEntity<?> guardarAerolinea(@RequestBody @Valid AerolineaRequestDTO aerolinea){
         return new ResponseEntity<>(aerolineaService.guardarAerolinea(aerolinea),HttpStatus.OK) ;
}

@PutMapping("/editar/{id}")
    public ResponseEntity<?> editarAerolinea(@PathVariable  @Positive(message = "Id debe ser positivo") Long id,@RequestBody @Valid AerolineaRequestDTO aerolineaRequest){
        return new ResponseEntity<>(aerolineaService.editarAerolinea(id,aerolineaRequest),HttpStatus.OK) ;
    }

@DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarAerolinea(@PathVariable @Positive(message = "Id debe ser positivo") Long id){
            return new ResponseEntity<>(aerolineaService.borrarAerolinea(id),HttpStatus.OK);
}

        }



