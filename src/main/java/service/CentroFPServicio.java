package service;

import dao.ModuloJdbcDao;
import dao.entities.Calificacion;
import dao.entities.Modulo;
import service.api.ApiCallException;
import service.api.CalificacionesApiCaller;
import service.api.CalificacionesApiCallerImpl;
import service.dto.EstudianteDTO;
import service.dto.ModuloDTO;
import service.dto.RecordDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CentroFPServicio {

    CalificacionesApiCaller calificacionesApiCaller = new CalificacionesApiCallerImpl("https://api.jsonbin.io/v3/b/684069908960c979a5a53c21");
    ModuloJdbcDao moduloJdbcDao = new ModuloJdbcDao();

    public RecordDTO getRecordDto() throws ApiCallException, IOException, InterruptedException {
        return  calificacionesApiCaller.getRecord();
    }

    public Modulo getModuloFromName(String nombre) throws Exception {
        return moduloJdbcDao.getModuloFromName(nombre);
    }

    public List<Calificacion> getCalifcacionesFromRecordDto(RecordDTO recordDTO) throws Exception {
        List<Calificacion> calificaciones = new ArrayList<>();
        List<EstudianteDTO> estudianteDTOS = recordDTO.getEstudiantes();

        for (EstudianteDTO estudianteDTO : estudianteDTOS) {
            
        }
        for (EstudianteDTO estudianteDTO : estudianteDTOS) {
            List<ModuloDTO> modulosDTO = estudianteDTO.getModulos();
            for (ModuloDTO moduloDTO : modulosDTO) {
                Modulo modulo = getModuloFromName(moduloDTO.getNombre());

                Calificacion calificacion = new Calificacion();
                calificacion.setCodMatricula(estudianteDTO.getMatricula());
                calificacion.setCodModulo(modulo.getCodigo());
                calificacion.setNota(moduloDTO.getNota());

                calificaciones.add(calificacion);
            }
        }
        return calificaciones;
    }
}
