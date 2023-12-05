package agencias.service.exceptions;

import agencias.service.models.dto.Response.ErrorAerolineaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(AerolineaNotFoundException.class)
    public ResponseEntity<?> aerolineaNotFound(AerolineaNotFoundException ex){
        ErrorAerolineaDTO error= new ErrorAerolineaDTO(404,ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(AerolineaFoundException.class)
    public ResponseEntity<?> aerolineaFound(AerolineaFoundException ex){
        ErrorAerolineaDTO error= new ErrorAerolineaDTO(400,ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(AerolineaDBException.class)
    public ResponseEntity<?> aerolineaDB(AerolineaDBException ex){
        ErrorAerolineaDTO error= new ErrorAerolineaDTO(400,ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }


}
