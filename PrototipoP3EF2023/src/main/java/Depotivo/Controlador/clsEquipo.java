/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Depotivo.Controlador;
import java.util.List;
import Depotivo.Modelo.daoEquipo;
/**
 *
 * @author visitante
 */
public class clsEquipo {
    private int IdEquipos;
    private String NombreEquipos;
    private int IdEntrenador;
    private int IdDeporte;

    public int getIdEquipos() {
        return IdEquipos;
    }

    public void setIdEquipos(int IdEquipos) {
        this.IdEquipos = IdEquipos;
    }

    public String getNombreEquipos() {
        return NombreEquipos;
    }

    public void setNombreEquipos(String NombreEquipos) {
        this.NombreEquipos = NombreEquipos;
    }

    public int getIdEntrenadores() {
        return IdEntrenador;
    }

    public void setIdEntrenadores (int IdEntrenadores) {
        this.IdEntrenador = IdEntrenadores;
    }

    public int getIdDeportes() {
        return IdDeporte;
    }

    public void setIdDeportes(int IdDeportes) {
        this.IdDeporte = IdDeportes;
    }

    public clsEquipo(int IdEquipo, String NombreEquipo, int IdEntrenadores, int IdDeportes) {
        this.IdEquipos = IdEquipo;
        this.NombreEquipos = NombreEquipo;
        this.IdEntrenador = IdEntrenadores;
        this.IdDeporte = IdDeportes;
    }

    public clsEquipo(int IdEquipos, String NombreEquipos, int ExistenciasMarcas) {
        this.IdEquipos = IdEquipos;
        this.NombreEquipos = NombreEquipos;
        this.IdEntrenador = ExistenciasMarcas;
    }

    public clsEquipo(int IdEquipos, String NombreEquipos) {
        this.IdEquipos = IdEquipos;
        this.NombreEquipos = NombreEquipos;
    }

    public clsEquipo(int IdEquipos) {
        this.IdEquipos = IdEquipos;
    }

    public clsEquipo() {
    }

    
    
    //Metodos de acceso a la capa controlador
    public clsEquipo getBuscarInformacionEquiposPorNombre(clsEquipo Equipos)
    {
        daoEquipo daoequipos = new daoEquipo();
        return daoequipos.consultaEquiposPorNombre(Equipos);
    }
    public clsEquipo getBuscarInformacionEquiposPorId(clsEquipo Equipos)
    {
        daoEquipo daoequipos = new daoEquipo();
        return daoequipos.consultaEquiposPorId(Equipos);
    }
    public List<clsEquipo> getListadoEquipos()
    {
        daoEquipo daoequipos = new daoEquipo();
        List<clsEquipo> listadoEquipos = daoequipos.consultaEquipos();
        return listadoEquipos;
    }
    public int setBorrarEquipos(clsEquipo Equipos)
    {
        daoEquipo daoequipos = new daoEquipo();
        return daoequipos.borrarEquipos(Equipos);
    }
    public int setIngresarEquipos(clsEquipo Equipos)
    {
        daoEquipo daoequipos = new daoEquipo();
        return daoequipos.ingresaEquipos(Equipos);
    }              
    public int setModificarEquipos(clsEquipo Equipos)
    {
        daoEquipo daoequipos = new daoEquipo();
        return daoequipos.actualizaEquipos(Equipos);
    }

    public void add(List<clsEquipo> equipos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
