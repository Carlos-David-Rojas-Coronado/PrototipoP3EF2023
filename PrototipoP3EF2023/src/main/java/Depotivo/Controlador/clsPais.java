/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Depotivo.Controlador;
import java.util.List;
import Depotivo.Modelo.daoPais;
/**
 *
 * @author visitante
 */
public class clsPais {
    private int IdPais;
    private String NombrePais;

    public clsPais() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdPais() {
        return IdPais;
    }

    public void setIdPais(int IdPais) {
        this.IdPais = IdPais;
    }

    public String getNombrePais() {
        return NombrePais;
    }
    
    public String setNombrePais(String NombrePais){
        this.NombrePais = NombrePais;
        return null;
    }
    
    public clsPais(int IdPais, String NombrePais) {
        this.IdPais = IdPais;
        this.NombrePais = NombrePais;
    }

    public clsPais(int IdPais) {
        this.IdPais = IdPais;
    }

    public clsPais getBuscarInformacionPaisPorId(clsPais Paices)
    {
        daoPais daopaices = new daoPais();
        return daopaices.consultaPaicesPorId(Paices);
    }
    public List<clsPais> getListadoPaices()
    {
        daoPais daopaices = new daoPais();
        List<clsPais> listadoPaices = daopaices.consultaPaices();
        return listadoPaices;
    }
    public int setBorrarPaices(clsPais Paices)
    {
        daoPais daopaices = new daoPais();
        return daopaices.borrarPaices(Paices);
    }
    public int setIngresarPaices(clsPais Paices)
    {
        daoPais daopaices = new daoPais();
        return daopaices.ingresaPaices(Paices);
    }              
    public int setModificarPaices(clsPais Paices)
    {
        daoPais daomovimientos = new daoPais();
        return daomovimientos.actualizaPaices(Paices);
    }

    public void add(List<clsPais> Paices) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
