package service.dto;

import java.util.Objects;

public class ModuloDTO {

    private String nombre;
    private double nota;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModuloDTO moduloDTO = (ModuloDTO) o;
        return Double.compare(nota, moduloDTO.nota) == 0 && Objects.equals(nombre, moduloDTO.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nota);
    }

    @Override
    public String toString() {
        return "ModuloDTO{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                '}';
    }
}
