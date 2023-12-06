package agencias.service.controllers;

import agencias.service.service.ReservaService;
import agencias.service.service.impl.ReservaServiceImpl;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reserva")
//@Validated
public class ReservaController {

    ReservaService service;

    public ReservaController(ReservaServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> reservasByUser(
            @PathVariable @Positive(message = "Debe ser un número positivo") Long id){
        return new ResponseEntity<>(service.reservasByUsuario(id), HttpStatus.OK);
    }
}
