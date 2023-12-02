package agencias.service.service.impl;

import agencias.service.models.dto.Request.PagoRequestDTO;
import agencias.service.models.dto.Response.PagoResponseDTO;
import agencias.service.models.dto.Response.ResponseDeleteDto;
import agencias.service.models.entity.Pago;
import agencias.service.models.entity.Reserva;
import agencias.service.repository.PagoRepository;
import agencias.service.service.PagoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PagoServiceImpl implements PagoService {

    private PagoRepository pagoRepo;

    public PagoServiceImpl(PagoRepository pagoRepo) {
        this.pagoRepo = pagoRepo;
    }

    @Override
    public List<PagoResponseDTO> listarPagos() {
        List<Pago> listPago = pagoRepo.findAll ();
        ModelMapper mapper = new ModelMapper ();
        List<PagoResponseDTO> pagoDtoList = new ArrayList<> ();
        listPago.stream ().forEach ( p -> pagoDtoList.add(mapper.map(p, PagoResponseDTO.class)) );


        return pagoDtoList;
    }

    @Override
    public PagoResponseDTO crearPago(PagoRequestDTO pago) {
        ModelMapper mapper = new ModelMapper ();
        Pago pagoClass = mapper.map(pago, Pago.class);

       //pagoClass.getReserva ().forEach ( i -> i.setPago ( pagoClass ) );
        //PENDIENTE determinar el monto de pago


        Pago pagoPersist = pagoRepo.save(pagoClass);
        PagoResponseDTO pagoDto = new PagoResponseDTO ();
        pagoDto.setPago ( mapper.map(pagoPersist, PagoRequestDTO.class) );
        pagoDto.setMensaje ( "Se registro el pago correctamente" );

        return pagoDto;
    }

    @Override
    public PagoResponseDTO traerPagoPorId(Long idPago) {
        ModelMapper mapper = new ModelMapper ();
        Pago pago = pagoRepo.findById ( idPago ).orElseThrow ( ()-> {
            throw new RuntimeException ( "No existe el pago que desea buscar" );
        });

        PagoResponseDTO pagoDto = new PagoResponseDTO ();
        pagoDto.setPago ( mapper.map(pago,PagoRequestDTO.class) );
        pagoDto.setMensaje ( "se logro encontrar el pago buscado" );


        return pagoDto;
    }

    @Override
    public PagoResponseDTO editarPago(PagoRequestDTO pago) {

        return null;
    }

    @Override
    public ResponseDeleteDto borrarPago(Long idPago) {
        Pago pago = pagoRepo.findById ( idPago ).orElseThrow ( ()-> {
            throw new RuntimeException ( "No existe el pago que desea eliminar" );
        });

        pagoRepo.deleteById ( idPago );
        ResponseDeleteDto res = new ResponseDeleteDto ();
        res.setMensaje ( " El pago se elimino correctamente" );

        return res;
    }
}
