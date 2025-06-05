package service.dto;

import java.util.List;
import java.util.Objects;

public class EstudianteDTO {

    private String nombre;
    private int edad;
    private String matricula;
    private String ciclo;
    private List<ModuloDTO> modulos;
    private boolean activo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public List<ModuloDTO> getModulos() {
        return modulos;
    }

    public void setModulos(List<ModuloDTO> modulos) {
        this.modulos = modulos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstudianteDTO that = (EstudianteDTO) o;
        return edad == that.edad && activo == that.activo && Objects.equals(nombre, that.nombre) && Objects.equals(matricula, that.matricula) && Objects.equals(ciclo, that.ciclo) && Objects.equals(modulos, that.modulos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, matricula, ciclo, modulos, activo);
    }

    @Override
    public String toString() {
        return "EstudianteDTO{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", matricula='" + matricula + '\'' +
                ", ciclo='" + ciclo + '\'' +
                ", modulos=" + modulos +
                ", activo=" + activo +
                '}';
    }
}


