package agencias.service.exceptions;

import agencias.service.models.dto.Response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(AerolineaNotFoundException.class)
    public ResponseEntity<?> aerolineaNotFound(AerolineaNotFoundException ex){
        ErrorDTO error= new ErrorDTO(404,ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TicketGenericException.class)
    public ResponseEntity<?> ticketGenericException(TicketGenericException ex){
        ErrorDTO error= new ErrorDTO(404,ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VueloGenericException.class)
    public ResponseEntity<?> vueloGenericException(VueloGenericException ex){
        ErrorDTO error= new ErrorDTO(404,ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RolGenericException.class)
    public ResponseEntity<?> rolGenericException(RolGenericException ex){
        ErrorDTO error= new ErrorDTO(404,ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> fallaValidacion(MethodArgumentTypeMismatchException ex){
        ErrorDTO error = new ErrorDTO(400, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



}

