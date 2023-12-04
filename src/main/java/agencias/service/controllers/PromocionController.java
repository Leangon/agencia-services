package agencias.service.controllers;

import agencias.service.models.dto.Request.PromocionCompleteDTO;
import agencias.service.models.dto.Request.PromocionRequestDto;
import agencias.service.service.PromocionService;
import agencias.service.service.impl.PromocionServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/promocion")
@Validated
public class PromocionController {

    PromocionService service;

    public PromocionController(PromocionServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody PromocionRequestDto promocionDto){
        return new ResponseEntity<>(service.save(promocionDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?>findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?>findById(@PathVariable @Positive(message = "debe ser un numero positivo")
                                     Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?>update(@Valid @RequestBody PromocionCompleteDTO promocionDto){
        return new ResponseEntity<>(service.update(promocionDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable @Positive(message = "debe ser un numero positivo")
                                   Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
