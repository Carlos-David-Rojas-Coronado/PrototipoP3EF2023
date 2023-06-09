/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Se agrega todo el codigo para la parte del controlador del mantenimiento de lineas
//Victor Josué Jerez Mijangos 9959-21-2081

package Inventarios.Controlador;
import java.util.List;
import Inventarios.Modelo.daoTipoPuesto;
/**
 *
 * @author visitante
 */
public class clsTipoPuesto {
    private int IdLineas;
    private String NombreLineas;
    private double PreciosLineas;
    private String EstatusLineas;

    public int getIdLineas() {
        return IdLineas;
    }

    public void setIdLineas(int IdLineas) {
        this.IdLineas = IdLineas;
    }

    public String getNombreLineas() {
        return NombreLineas;
    }

    public void setNombreLineas(String NombreLineas) {
        this.NombreLineas = NombreLineas;
    }

    public double getPreciosLineas() {
        return PreciosLineas;
    }

    public void setPreciosLineas(double PreciosLineas) {
        this.PreciosLineas = PreciosLineas;
    }

    public String getEstatusLineas() {
        return EstatusLineas;
    }

    public void setEstatusLineas(String EstatusLineas) {
        this.EstatusLineas = EstatusLineas;
    }

    public clsTipoPuesto(int IdLineas, String NombreLineas, double PreciosLineas) {
        this.IdLineas = IdLineas;
        this.NombreLineas = NombreLineas;
        this.PreciosLineas = PreciosLineas;
    }

    public clsTipoPuesto(int IdLineas, String NombreLineas, double PreciosLineas, String EstatusLineas) {
        this.IdLineas = IdLineas;
        this.NombreLineas = NombreLineas;
        this.PreciosLineas = PreciosLineas;
        this.EstatusLineas = EstatusLineas;
    }

    public clsTipoPuesto(int IdLineas, String NombreLineas) {
        this.IdLineas = IdLineas;
        this.NombreLineas = NombreLineas;
    }

    public clsTipoPuesto(int IdLineas) {
        this.IdLineas = IdLineas;
    }

    public clsTipoPuesto() {
    }

    //Metodos de acceso a la capa controlador
    public clsTipoPuesto getBuscarInformacionLineasPorNombre(clsTipoPuesto Lineas)
    {
        daoTipoPuesto daolineas = new daoTipoPuesto();
        return daolineas.consultaLineasPorNombre(Lineas);
    }
    public clsTipoPuesto getBuscarInformacionLineasPorId(clsTipoPuesto Lineas)
    {
        daoTipoPuesto daolineas = new daoTipoPuesto();
        return daolineas.consultaLineasPorId(Lineas);
    }
    public List<clsTipoPuesto> getListadoLineas()
    {
        daoTipoPuesto daolineas = new daoTipoPuesto();
        List<clsTipoPuesto> listadoLineas = daolineas.consultaLineas();
        return listadoLineas;
    }
    public int setBorrarLineas(clsTipoPuesto Lineas)
    {
        daoTipoPuesto daolineas = new daoTipoPuesto();
        return daolineas.borrarLineas(Lineas);
    }
    public int setIngresarLineas(clsTipoPuesto Lineas)
    {
        daoTipoPuesto daolineas = new daoTipoPuesto();
        return daolineas.ingresaLineas(Lineas);
    }              
    public int setModificarLineas(clsTipoPuesto Lineas)
    {
        daoTipoPuesto daolineas = new daoTipoPuesto();
        return daolineas.actualizaLineas(Lineas);
    }

    public void add(List<clsTipoPuesto> Lineas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
