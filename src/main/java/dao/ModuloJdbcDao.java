package dao;




import dao.entities.Modulo;
import dao.utils.DriverHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModuloJdbcDao {

    private static String SQL_SELECT_COD_MODULO_FROM_NAME = "SELECT * from modulo where nombre = ?";



    public  Modulo getModuloFromName(String nombreModulo) throws Exception {
        Modulo modulo = null;
        try(Connection conn = DriverHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_SELECT_COD_MODULO_FROM_NAME)) {
            ps.setString(1, nombreModulo);


            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                modulo = mapResultSet(rs);

            }
        }
        return modulo;
    }



    /**
     * Transformar una fila en un comment
     * @param rs
     * @return
     */
    private Modulo mapResultSet(ResultSet rs) throws SQLException {
        Modulo comment = new Modulo();
        comment.setCodigo(rs.getString("cod_modulo"));
        comment.setNombre(rs.getString("nombre"));
        return comment;
    }



}
