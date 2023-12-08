package agencias.service.controllers;

import agencias.service.models.dto.Request.RolRequestDTO;
import agencias.service.service.RolService;
import agencias.service.service.impl.RolServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rol")
@Validated
public class RolController {

    RolService service;

    public RolController(RolServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody RolRequestDTO rolDto){
        return new ResponseEntity<>(service.save(rolDto), HttpStatus.CREATED);
    }

    @PutMapping("/{idRol}/{idUsuario}")
    public ResponseEntity<?> asignarRol(@PathVariable @Positive Long idRol,
                                        @PathVariable @Positive Long idUsuario){
        return new ResponseEntity<>(service.asignarRol(idRol, idUsuario), HttpStatus.OK);
    }
}
