package agencias.service.exceptions;

import agencias.service.models.dto.Response.ErrorAerolineaDTO;
import agencias.service.models.dto.Response.ErrorAerolineaDTOHash;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;

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
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> fallaValidacion(MethodArgumentNotValidException ex){

        HashMap<String,String> errores= new HashMap<>();
        ex.getFieldErrors().forEach(field -> errores.put(field.getField(),field.getDefaultMessage()));

        return new ResponseEntity<>(new ErrorAerolineaDTOHash(400,errores), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)//handler para capturar la validacion de id en uri
    public ResponseEntity<?> fallaPathVariable(MethodArgumentTypeMismatchException ex){
        ErrorAerolineaDTO error= new ErrorAerolineaDTO(400,ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

}
