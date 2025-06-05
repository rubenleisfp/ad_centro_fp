package app;

import dao.entities.Calificacion;
import dao.entities.Modulo;
import service.CentroFPServicio;
import service.api.ApiCallException;
import service.api.CalificacionesApiCaller;
import service.api.CalificacionesApiCallerImpl;
import service.dto.RecordDTO;

import java.io.IOException;
import java.util.List;

public class AppCentroFP {

    CentroFPServicio centroFPServicio  = new CentroFPServicio();

    public static void main(String[] args) {
        AppCentroFP appCentroFP = new AppCentroFP();
        RecordDTO recordDTO = appCentroFP.proceso();
        System.out.println(recordDTO);

    }

    public RecordDTO proceso() {
        try {
            RecordDTO recordDTO = centroFPServicio.getRecordDto();
            List<Calificacion> calificaciones = centroFPServicio.getCalifcacionesFromRecordDto(recordDTO);
            for (Calificacion calificacion : calificaciones) {
                System.out.println(calificacion);
            }


        } catch (ApiCallException e) {
            System.out.println(e.getResponseBody());
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
