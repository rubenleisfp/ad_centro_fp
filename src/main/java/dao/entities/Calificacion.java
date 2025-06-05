package dao.entities;

import java.util.Objects;

public class Calificacion {

    private String codMatricula;
    private String codModulo;
    private double nota;

    public String getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    public String getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(String codModulo) {
        this.codModulo = codModulo;
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
        Calificacion that = (Calificacion) o;
        return Double.compare(nota, that.nota) == 0 && Objects.equals(codMatricula, that.codMatricula) && Objects.equals(codModulo, that.codModulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codMatricula, codModulo, nota);
    }

    @Override
    public String toString() {
        return "Calificacion{" +
                "codMatricula='" + codMatricula + '\'' +
                ", codModulo='" + codModulo + '\'' +
                ", nota=" + nota +
                '}';
    }
}
