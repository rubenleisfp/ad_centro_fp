package service.dto;

import java.util.List;

public class RecordDTO {

    List<EstudianteDTO> estudiantes;

    public List<EstudianteDTO> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteDTO> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Record{" +
                "estudiantes=" + estudiantes +
                '}';
    }
}
