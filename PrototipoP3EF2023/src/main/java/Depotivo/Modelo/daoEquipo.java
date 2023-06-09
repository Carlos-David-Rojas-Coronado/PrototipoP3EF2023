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
    private static final String SQL_SELECT_ID = "SELECT marCodigo, marNombre, marExistencias, marPrecios FROM tbl_marcas WHERE ID_EQUIPO = ?";    

    public List<clsEquipo> consultaMarcas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsEquipo> marcas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("marCodigo");
                String nombre = rs.getString("marNombre");
                int existencias = rs.getInt("marExistencias");
                double precio = rs.getDouble("marPrecios");
                String estatus = rs.getString("marEstatus");
                clsEquipo Marcas = new clsEquipo();
                Marcas.setIdMarcas(id);
                Marcas.setNombreMarcas(nombre);
                Marcas.setExistenciasMarcas(existencias);
                Marcas.setPreciosMarcas(precio);
                Marcas.setEstatusMarcas(estatus);
                
                marcas.add(Marcas);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return marcas;
    }

    public int ingresaMarcas(clsEquipo marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, marcas.getNombreMarcas());
            stmt.setInt(2, marcas.getExistenciasMarcas());
            stmt.setDouble(3, marcas.getPreciosMarcas());
            stmt.setString(4, marcas.getEstatusMarcas());

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

    public int actualizaMarcas(clsEquipo marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, marcas.getNombreMarcas());
            stmt.setInt(2, marcas.getExistenciasMarcas());
            stmt.setDouble(3, marcas.getPreciosMarcas());
            stmt.setString(4, marcas.getEstatusMarcas());
            stmt.setInt(5, marcas.getIdMarcas());
            

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

    public int borrarMarcas(clsEquipo marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, marcas.getIdMarcas());
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

    public clsEquipo consultaMarcasPorNombre(clsEquipo marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + marcas);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, marcas.getNombreMarcas());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("marCodigo");
                String nombre = rs.getString("marNombre");
                int existencias = rs.getInt("marExistencias");
                double precios = rs.getDouble("marPrecios");
                String estatus = rs.getString("marEstatus");

                //aplicacion = new clsAplicacion();
                marcas.setIdMarcas(id);
                marcas.setNombreMarcas(nombre);
                marcas.setExistenciasMarcas(existencias);
                marcas.setPreciosMarcas(precios);
                marcas.setEstatusMarcas(estatus);
                System.out.println(" registro consultado: " + marcas);                
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
        return marcas;
    }
    public clsEquipo consultaMarcasPorId(clsEquipo marcas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + marcas);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, marcas.getIdMarcas());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("marCodigo");
                String nombre = rs.getString("marNombre");
                int existencias = rs.getInt("marExistencias");
                double precios = rs.getDouble("marPrecios");
                String estatus = rs.getString("marEstatus");

                //aplicacion = new clsAplicacion();
                marcas.setIdMarcas(id);
                marcas.setNombreMarcas(nombre);
                marcas.setExistenciasMarcas(existencias);
                marcas.setPreciosMarcas(precios);
                marcas.setEstatusMarcas(estatus);
                System.out.println(" registro consultado: " + marcas);                
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
        return marcas;
    }    
}
