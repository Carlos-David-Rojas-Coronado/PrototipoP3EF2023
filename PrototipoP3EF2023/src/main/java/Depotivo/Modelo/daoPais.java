/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Depotivo.Modelo;

import Seguridad.Modelo.*;
import Depotivo.Controlador.clsPais;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoPais {

    private static final String SQL_SELECT = "SELECT IdPais, Nombrepais, FROM tbl_paices";
    private static final String SQL_INSERT = "INSERT INTO tbl_paices(IdPais, NombrePais) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_paices SET NombrePais=? WHERE IdPais = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_Paices WHERE IdPais=?";
   // private static final String SQL_SELECT_EFECTO = "SELECT IdPais FROM tbl_movimientos WHERE NombrePais = ?";
    private static final String SQL_SELECT_ID = "SELECT IdPais, NombrePais FROM tbl_paices WHERE IdPais = ?";    

    public List<clsPais> consultaPaices() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsPais> paices = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IdPais");
                String nombre = rs.getString("NombrePais");
                clsPais Paices = new clsPais();
                Paices.setIdPais(id);
                Paices.setNombrePais(nombre);
                
                paices.add(Paices);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return paices;
    }

    public int ingresaPaices(clsPais paices) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(0, paices.getIdPais());
            stmt.setString(1, paices.getNombrePais());

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

    public int actualizaPaices(clsPais paices) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, paices.getNombrePais());
            stmt.setInt(2, paices.getIdPais());
            

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

    public int borrarPaices(clsPais paices) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, paices.getIdPais());
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

    public clsPais consultaPaicesPorId(clsPais paices) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_SELECT_EFECTO + " objeto recibido: " + movimientos);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, paices.getIdPais());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IdPais");
                String nombre = rs.getString("NombrePais");

                //aplicacion = new clsAplicacion();
                paices.setIdPais(id);
                paices.setNombrePais(nombre);
                System.out.println(" registro consultado: " + paices);                
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
        return paices;
    }    
}
