package service;

import dao.CalificacionJdbcDao;
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

public class CentroFPService {

    CalificacionesApiCaller calificacionesApiCaller = new CalificacionesApiCallerImpl("https://api.jsonbin.io/v3/b/684069908960c979a5a53c21");
    ModuloJdbcDao moduloJdbcDao = new ModuloJdbcDao();
    CalificacionJdbcDao calificacionJdbcDao = new CalificacionJdbcDao();

    /**
     * Obtiene un record del API de DAM con la informacion de las calificaciones de su modulos
     * @return
     * @throws ApiCallException
     * @throws IOException
     * @throws InterruptedException
     */
    public RecordDTO getRecordDto() throws ApiCallException, IOException, InterruptedException {
        return  calificacionesApiCaller.getRecord();
    }

    /**
     * Obtiene un modulo de BBDD a partir de su nombre
     * @param nombre
     * @return
     * @throws Exception
     */
    public Modulo getModuloFromName(String nombre) throws Exception {
        return moduloJdbcDao.getModuloFromName(nombre);
    }

    /**
     * A partir de un record obtenido del API de DAM, obtenemos una lista de Calificaciones
     * que nos servira para volcar en BBDD del centro
     * @param recordDTO
     * @return
     * @throws Exception
     */
    public List<Calificacion> getCalificacionesFromRecordDto(RecordDTO recordDTO) throws Exception {
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

    /**
     * Vuelca las calificaciones de DAM en la BBDD del centro
     *
     * @param calificacions
     */
    public void volcarCalificacionesDamEnCentro(List<Calificacion> calificacions) throws Exception {
        for (Calificacion calificacion : calificacions) {
            calificacionJdbcDao.create(calificacion);
        }
    }

    /**
     * 1.- Obtiene del API la información de las calificaciones de DAM (RecordDTO)
     * 2.- Transforma este RecordDTO en Calificaciones
     * 3.- Vuelca las calificaciones a la BBDD
     */
    public void procesarCalificaciones() throws Exception {
        RecordDTO recordDTO = this.getRecordDto();
        List<Calificacion> calificaciones= this.getCalificacionesFromRecordDto(recordDTO);
        this.volcarCalificacionesDamEnCentro(calificaciones);
    }
}
