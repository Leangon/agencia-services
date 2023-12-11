package agencias.service.controllers;

import agencias.service.models.dto.Request.TicketCompleteDTO;
import agencias.service.models.dto.Request.TicketDTO;
import agencias.service.service.TicketService;
import agencias.service.service.impl.TicketServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket")
@Validated
public class TicketController {

    TicketService service;

    public TicketController(TicketServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?>save(@Valid @RequestBody TicketDTO ticketDto){
        return new ResponseEntity<>(service.save(ticketDto), HttpStatus.OK);
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
    public ResponseEntity<?>update(@Valid @RequestBody TicketCompleteDTO ticketDto){
        return new ResponseEntity<>(service.update(ticketDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable @Positive(message = "debe ser un numero positivo")
                                              Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}

