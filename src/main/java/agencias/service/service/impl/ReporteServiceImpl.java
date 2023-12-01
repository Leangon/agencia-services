package agencias.service.service.impl;

import agencias.service.models.dto.Request.ReporteRequestDTO;
import agencias.service.models.dto.Response.ReporteResponseDTO;
import agencias.service.models.dto.Response.ResponseDeleteDto;
import agencias.service.models.entity.Reporte;
import agencias.service.repository.ReporteRepository;
import agencias.service.service.ReporteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReporteServiceImpl implements ReporteService {

    private ReporteRepository reporteRepo;

    public ReporteServiceImpl(ReporteRepository reporteRepo) {
        this.reporteRepo = reporteRepo;
    }

    @Override
    public ReporteResponseDTO crearReporte(ReporteRequestDTO reporte) {
        ModelMapper mapper = new ModelMapper ();
        Reporte repor = mapper.map(reporte, Reporte.class);
        Reporte repoPersist = reporteRepo.save ( repor );
        ReporteResponseDTO repoDto = new ReporteResponseDTO ();
        repoDto.setReporteDto ( mapper.map(repoPersist, ReporteRequestDTO.class ));
        repoDto.setMensaje ( "Se creo el reporte existosamente" );


        return repoDto;
    }

    @Override
    public List<ReporteResponseDTO> listarReporte() {
        List<Reporte> listReporte = reporteRepo.findAll ();
        ModelMapper mapper = new ModelMapper ();
        List<ReporteResponseDTO> listReporteDto = new ArrayList<> (  );
        listReporte.stream ().forEach ( r -> listReporteDto.add(mapper.map ( listReporte, ReporteResponseDTO.class )) );

        return listReporteDto;
    }

    @Override
    public ReporteResponseDTO traerReportePorId(Long idReporte) {
        ModelMapper mapper = new ModelMapper ();
        Reporte reporte =reporteRepo.findById ( idReporte ).orElseThrow ( ()-> {
            throw new RuntimeException ( "No existe el reporte que desea buscar" );
        });

        ReporteResponseDTO repoDto = new ReporteResponseDTO ();
        repoDto.setReporteDto ( mapper.map(reporte, ReporteRequestDTO.class) );
        repoDto.setMensaje ( "se obtuvo el reporte requerido" );

        return repoDto;
    }

    @Override
    public ResponseDeleteDto eliminarReporte(Long idReporte) {

        Reporte reporte =reporteRepo.findById ( idReporte ).orElseThrow ( ()-> {
            throw new RuntimeException ( "No existe el reporte que desea eliminar" );
        });
        reporteRepo.deleteById ( idReporte );

        ResponseDeleteDto repoDto = new ResponseDeleteDto  ();

        repoDto.setMensaje ( "se elimimino Correctamente el reporte" );

        return repoDto;


    }
}
