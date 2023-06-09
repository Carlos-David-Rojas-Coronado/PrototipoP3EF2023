/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Se agrega todo el codigo para la parte del modelo del mantenimiento de lineas.
//Victor Josué Jerez Mijangos 9959-21-2081

package Depotivo.Modelo;

import Seguridad.Modelo.*;
import Depotivo.Controlador.clsTipoPuesto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoTipoPuesto {

    private static final String SQL_SELECT = "SELECT ID_TIPO_PUESTO, NOMBRE_PUESTO, SALARIO FROM tbl_tipo_puesto";
    private static final String SQL_INSERT = "INSERT INTO tbl_tipo_puesto(NOMBRE_PUESTO, SALARIO) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_tipo_puesto SET NOMBRE_PUESTO=?, SALARIO=? WHERE ID_TIPO_PUESTO = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_tipo_puesto WHERE ID_TIPO_PUESTO=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT ID_TIPO_PUESTO, NOMBRE_PUESTO, SALARIOS FROM tbl_tipo_puesto WHERE NOBRE_PUESTO = ?";
    private static final String SQL_SELECT_ID = "SELECT ID_TIPO_PUESTO, NOMBRE_PUESTO, SALARIOS FROM tbl_tipo_puesto WHERE ID_TIPO_PUESTO = ?";    

    public List<clsTipoPuesto> consultaPuesto() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsTipoPuesto> puesto = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_TIPO_PUESTO");
                String nombre = rs.getString("NOMBRE_PUESTO");
                int salarios = rs.getInt("SALARIO");

                clsTipoPuesto Puesto = new clsTipoPuesto();
                Puesto.setIdTipo(id);
                Puesto.setNombrePuesto(nombre);
                Puesto.setSalarios(salarios);
                
                puesto.add(Puesto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return puesto;
    }

    public int ingresaPuesto(clsTipoPuesto puesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, puesto.getNombrePuesto());
            stmt.setInt(2, puesto.getSalarios());

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

    public int actualizaPuesto(clsTipoPuesto puesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, puesto.getNombrePuesto());
            stmt.setDouble(2, puesto.getSalarios());
            stmt.setInt(3, puesto.getIdTipo());
            

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

    public int borrarPuesto(clsTipoPuesto puesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, puesto.getIdTipo());
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

    public clsTipoPuesto consultaPuestosPorNombre(clsTipoPuesto puestos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + puestos);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, puestos.getNombrePuesto());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_TIPO_PUESTO");
                String nombre = rs.getString("NOMBRE_PUESTO");
                int salarios = rs.getInt("SALARIO");

                //aplicacion = new clsAplicacion();
                puestos.setIdTipo(id);
                puestos.setNombrePuesto(nombre);
                puestos.setSalarios(salarios);
                System.out.println(" registro consultado: " + puestos);                
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
        return puestos;
    }
    public clsTipoPuesto consultaPuestosPorId(clsTipoPuesto puestos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + puestos);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, puestos.getIdTipo());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_TIPO_PUESTO");
                String nombre = rs.getString("NOMBRE_PUESTO");
                int salarios = rs.getInt("SALARIO");

                //aplicacion = new clsAplicacion();
                puestos.setIdTipo(id);
                puestos.setNombrePuesto(nombre);
                puestos.setSalarios(salarios);
                System.out.println(" registro consultado: " + puestos);                
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
        return puestos;
    }    
}
