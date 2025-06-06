package dao;

import dao.entities.Calificacion;
import dao.entities.Modulo;
import dao.utils.DriverHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CalificacionJdbcDao {

    private static String SQL_INSERT_CALIFICACION = "INSERT INTO ad_centro_fp.calificacion" +
            " (ALUMNO_matricula, MODULO_cod_modulo,nota) VALUES (?,?,?)";

    /**
     * Crea una calificacion en BBDD
     * @param calificacion
     * @throws Exception
     */
    public void create(Calificacion calificacion) throws Exception {
        Modulo modulo = null;
        try(Connection conn = DriverHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_INSERT_CALIFICACION)) {
            ps.setString(1, calificacion.getCodMatricula());
            ps.setString(2, calificacion.getCodModulo());
            ps.setDouble(3, calificacion.getNota());

            ps.executeUpdate();
        }
    }
}
