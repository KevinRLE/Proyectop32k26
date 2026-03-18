package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.Conexion;
import Controlador.AsignacionAplicacionUsuario;

//Angoly Camila Araujo Mayen 9959-24-17623

public class AsignacionAplicacionUsuarioDAO {

    // CONSULTAS SQL 
    private static final String SQL_SELECT =
            "SELECT Usucodigo, Aplcodigo, APLUins, APLUsel, APLUupd, APLUdel, APLUrep FROM asignacionaplicacionusuarios";

    private static final String SQL_INSERT =
            "INSERT INTO asignacionaplicacionusuarios(Usucodigo, Aplcodigo, APLUins, APLUsel, APLUupd, APLUdel, APLUrep) VALUES(?,?,?,?,?,?,?)";

    private static final String SQL_UPDATE =
            "UPDATE asignacionaplicacionusuarios SET APLUins=?, APLUsel=?, APLUupd=?, APLUdel=?, APLUrep=? WHERE Usucodigo=? AND Aplcodigo=?";

    private static final String SQL_DELETE =
            "DELETE FROM asignacionaplicacionusuarios WHERE Usucodigo=? AND Aplcodigo=?";

    private static final String SQL_QUERY =
            "SELECT Usucodigo, Aplcodigo, APLUins, APLUsel, APLUupd, APLUdel, APLUrep FROM asignacionaplicacionusuarios WHERE Usucodigo=? AND Aplcodigo=?";


    // SELECT
    public List<AsignacionAplicacionUsuario> select() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<AsignacionAplicacionUsuario> asignaciones = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                AsignacionAplicacionUsuario asignacion = new AsignacionAplicacionUsuario();

                asignacion.setUsucodigo(rs.getInt("Usucodigo"));
                asignacion.setAplcodigo(rs.getInt("Aplcodigo"));
                asignacion.setApluins(rs.getString("APLUins"));
                asignacion.setAplusel(rs.getString("APLUsel"));
                asignacion.setApluupd(rs.getString("APLUupd"));
                asignacion.setApludel(rs.getString("APLUdel"));
                asignacion.setAplurep(rs.getString("APLUrep"));

                asignaciones.add(asignacion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return asignaciones;
    }


    // INSERT
    public int insert(AsignacionAplicacionUsuario asignacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setInt(1, asignacion.getUsucodigo());
            stmt.setInt(2, asignacion.getAplcodigo());
            stmt.setString(3, asignacion.getApluins());
            stmt.setString(4, asignacion.getAplusel());
            stmt.setString(5, asignacion.getApluupd());
            stmt.setString(6, asignacion.getApludel());
            stmt.setString(7, asignacion.getAplurep());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }


    // UPDATE
    public int update(AsignacionAplicacionUsuario asignacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, asignacion.getApluins());
            stmt.setString(2, asignacion.getAplusel());
            stmt.setString(3, asignacion.getApluupd());
            stmt.setString(4, asignacion.getApludel());
            stmt.setString(5, asignacion.getAplurep());

            stmt.setInt(6, asignacion.getUsucodigo());
            stmt.setInt(7, asignacion.getAplcodigo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }


    // DELETE
    public int delete(AsignacionAplicacionUsuario asignacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, asignacion.getUsucodigo());
            stmt.setInt(2, asignacion.getAplcodigo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }


    // QUERY
    public AsignacionAplicacionUsuario query(AsignacionAplicacionUsuario asignacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);

            stmt.setInt(1, asignacion.getUsucodigo());
            stmt.setInt(2, asignacion.getAplcodigo());

            rs = stmt.executeQuery();

            if (rs.next()) {

                asignacion.setApluins(rs.getString("APLUins"));
                asignacion.setAplusel(rs.getString("APLUsel"));
                asignacion.setApluupd(rs.getString("APLUupd"));
                asignacion.setApludel(rs.getString("APLUdel"));
                asignacion.setAplurep(rs.getString("APLUrep"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return asignacion;
    }
}