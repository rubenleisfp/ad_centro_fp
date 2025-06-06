package app;

import dao.entities.Calificacion;
import service.CentroFPService;
import service.api.ApiCallException;
import service.dto.RecordDTO;

import java.io.IOException;
import java.util.List;

public class AppCentroFP {

    CentroFPService centroFPServicio  = new CentroFPService();

    public static void main(String[] args) {
        AppCentroFP appCentroFP = new AppCentroFP();
        appCentroFP.proceso();
    }

    public void proceso() {
        try {
           centroFPServicio.procesarCalificaciones();


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

    }
}
