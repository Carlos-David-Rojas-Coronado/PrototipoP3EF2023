/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Depotivo.Modelo;

import  Seguridad.Modelo.*;
import Depotivo.Controlador.clsEquipo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoEquipo {

    private static final String SQL_SELECT = "SELECT ID_EQUIPO, NOMBRE_EQUIPO, ID_ENTRENADOR_FK, ID_TIPO_DEPORTE_FK,  FROM tbl_equipo";
    private static final String SQL_INSERT = "INSERT INTO tbl_equipo(NOMNRE_EQUIPO, ID_EQUIPO, ID_ENTRENADOR_FK, ID_TIPO_DEPORTE_FK) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_equipo SET NOMBRE_EQUIPO=?, ID_ENTRENADOR_FK=?, ID_TIPO_DEPORTE_FK=?, WHERE ID_EQUIPO = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_equipo WHERE ID_EQUIPO=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT ID_EQUIPO, NOMBRE_EQUIPO, ID_ENTRENADOR_FK, ID_TIPO_DEPORTE_FK, FROM tbl_equipo WHERE NOMBRE_EQUIPO = ?";
    private static final String SQL_SELECT_ID = "SELECT ID_EQUIPO, NOMBRE_EQUIPO, ID_ENTRENADOR_FK, ID_TIPO_DEPORTE_FK FROM tbl_equipo WHERE ID_EQUIPO = ?";    

    public List<clsEquipo> consultaEquipos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsEquipo> equipos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_EQUIPO");
                String nombre = rs.getString("NOMBRE_EQUIPO");
                int entrenador = rs.getInt("ID_EMTRENADOR_FK");
                int deporte = rs.getInt("ID_TIPO_DEPORTE_FK");
                clsEquipo Equipos = new clsEquipo();
                Equipos.setIdEquipos(id);
                Equipos.setNombreEquipos(nombre);
                Equipos.setIdEntrenadores(entrenador);
                Equipos.setIdDeportes(deporte);
                
                equipos.add(Equipos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return equipos;
    }

    public int ingresaEquipos(clsEquipo equipos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, equipos.getNombreEquipos());
            stmt.setInt(2, equipos.getIdEntrenadores());
            stmt.setDouble(3, equipos.getIdDeportes());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaEquipos(clsEquipo equipos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, equipos.getNombreEquipos());
            stmt.setInt(2, equipos.getIdEntrenadores());
            stmt.setDouble(3, equipos.getIdDeportes());
            stmt.setInt(5, equipos.getIdEquipos());
            

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarEquipos(clsEquipo equipos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, equipos.getIdEquipos());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsEquipo consultaEquiposPorNombre(clsEquipo equipos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + equipos);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, equipos.getNombreEquipos());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_EQUIPO");
                String nombre = rs.getString("NOMBRE_EQUIPO");
                int entrenador = rs.getInt("ID_ENTRENADOR_FK");
                int deporte = rs.getInt("ID_TIPO_DEPORTE_FK");

                //aplicacion = new clsAplicacion();
                equipos.setIdEquipos(id);
                equipos.setNombreEquipos(nombre);
                equipos.setIdEntrenadores(entrenador);
                equipos.setIdDeportes(deporte);
                System.out.println(" registro consultado: " + equipos);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return equipos;
    }
    public clsEquipo consultaEquiposPorId(clsEquipo equipos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + equipos);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, equipos.getIdEquipos());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_EQUIPO");
                String nombre = rs.getString("NOMBRE_EQUIPO");
                int entrenadores = rs.getInt("ID_ENTRENADOR_FK");
                int deportes = rs.getInt("ID_TIPO_DEPORTE_FK");

                //aplicacion = new clsAplicacion();
                equipos.setIdEquipos(id);
                equipos.setNombreEquipos(nombre);
                equipos.setIdEntrenadores(entrenadores);
                equipos.setIdDeportes(deportes);
                System.out.println(" registro consultado: " + equipos);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return equipos;
    }    
}
