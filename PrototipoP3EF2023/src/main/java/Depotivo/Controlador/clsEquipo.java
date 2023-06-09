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
    private int IdMarcas;
    private String NombreMarcas;
    private int ExistenciasMarcas;
    private double PreciosMarcas;
    private String EstatusMarcas;

    public int getIdMarcas() {
        return IdMarcas;
    }

    public void setIdMarcas(int IdMarcas) {
        this.IdMarcas = IdMarcas;
    }

    public String getNombreMarcas() {
        return NombreMarcas;
    }

    public void setNombreMarcas(String NombreMarcas) {
        this.NombreMarcas = NombreMarcas;
    }

    public int getExistenciasMarcas() {
        return ExistenciasMarcas;
    }

    public void setExistenciasMarcas(int ExistenciasMarcas) {
        this.ExistenciasMarcas = ExistenciasMarcas;
    }

    public double getPreciosMarcas() {
        return PreciosMarcas;
    }

    public void setPreciosMarcas(double PreciosMarcas) {
        this.PreciosMarcas = PreciosMarcas;
    }

    public String getEstatusMarcas() {
        return EstatusMarcas;
    }

    public void setEstatusMarcas(String EstatusMarcas) {
        this.EstatusMarcas = EstatusMarcas;
    }

    public clsEquipo(int IdMarcas, String NombreMarcas, int ExistenciasMarcas, double PreciosMarcas) {
        this.IdMarcas = IdMarcas;
        this.NombreMarcas = NombreMarcas;
        this.ExistenciasMarcas = ExistenciasMarcas;
        this.PreciosMarcas = PreciosMarcas;
    }

    public clsEquipo(int IdMarcas, String NombreMarcas, int ExistenciasMarcas, double PreciosMarcas, String EstatusMarcas) {
        this.IdMarcas = IdMarcas;
        this.NombreMarcas = NombreMarcas;
        this.ExistenciasMarcas = ExistenciasMarcas;
        this.PreciosMarcas = PreciosMarcas;
        this.EstatusMarcas = EstatusMarcas;
    }

    public clsEquipo(int IdMarcas, String NombreMarcas, int ExistenciasMarcas) {
        this.IdMarcas = IdMarcas;
        this.NombreMarcas = NombreMarcas;
        this.ExistenciasMarcas = ExistenciasMarcas;
    }

    public clsEquipo(int IdMarcas, String NombreMarcas) {
        this.IdMarcas = IdMarcas;
        this.NombreMarcas = NombreMarcas;
    }

    public clsEquipo(int IdMarcas) {
        this.IdMarcas = IdMarcas;
    }

    public clsEquipo() {
    }

    
    
    //Metodos de acceso a la capa controlador
    public clsEquipo getBuscarInformacionMarcasPorNombre(clsEquipo Marcas)
    {
        daoEquipo daomarcas = new daoEquipo();
        return daomarcas.consultaMarcasPorNombre(Marcas);
    }
    public clsEquipo getBuscarInformacionMarcasPorId(clsEquipo Marcas)
    {
        daoEquipo daomarcas = new daoEquipo();
        return daomarcas.consultaMarcasPorId(Marcas);
    }
    public List<clsEquipo> getListadoMarcas()
    {
        daoEquipo daomarcas = new daoEquipo();
        List<clsEquipo> listadoMarcas = daomarcas.consultaMarcas();
        return listadoMarcas;
    }
    public int setBorrarMarcas(clsEquipo Marcas)
    {
        daoEquipo daomarcas = new daoEquipo();
        return daomarcas.borrarMarcas(Marcas);
    }
    public int setIngresarMarcas(clsEquipo Marcas)
    {
        daoEquipo daomarcas = new daoEquipo();
        return daomarcas.ingresaMarcas(Marcas);
    }              
    public int setModificarMarcas(clsEquipo Marcas)
    {
        daoEquipo daomarcas = new daoEquipo();
        return daomarcas.actualizaMarcas(Marcas);
    }

    public void add(List<clsEquipo> Marcas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
