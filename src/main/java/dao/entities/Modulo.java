package dao.entities;

import java.util.Objects;

public class Modulo {

    private String codigo;
    private String nombre;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modulo modulo = (Modulo) o;
        return Objects.equals(codigo, modulo.codigo) && Objects.equals(nombre, modulo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre);
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "codigoMatricula='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
