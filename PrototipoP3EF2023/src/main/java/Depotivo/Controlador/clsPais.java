/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Se agrega TODO el codigo para la parte del controlador del mantenimiento de movimientos
//Victor Josué Jerez Mijangos 9959-21-2081
package Inventarios.Controlador;
import java.util.List;
import Inventarios.Modelo.daoPais;
/**
 *
 * @author visitante
 */
public class clsPais {
    private int IdMovimiento;
    private String DescripcionMovimiento;
    private String EfectoMovimiento;
    private String EstatusMovimiento;

    public int getIdMovimiento() {
        return IdMovimiento;
    }

    public void setIdMovimiento(int IdMovimiento) {
        this.IdMovimiento = IdMovimiento;
    }

    public String getDescripcionMovimiento() {
        return DescripcionMovimiento;
    }

    public void setDescripcionMovimiento(String DescripcionMovimiento) {
        this.DescripcionMovimiento = DescripcionMovimiento;
    }

    public String getEfectoMovimiento() {
        return EfectoMovimiento;
    }

    public void setEfectoMovimiento(String EfectoMovimiento) {
        this.EfectoMovimiento = EfectoMovimiento;
    }

    public String getEstatusMovimiento() {
        return EstatusMovimiento;
    }

    public void setEstatusMovimiento(String EstatusMovimiento) {
        this.EstatusMovimiento = EstatusMovimiento;
    }

    public clsPais(int IdMovimiento, String DescripcionMovimiento, String EfectoMovimiento) {
        this.IdMovimiento = IdMovimiento;
        this.DescripcionMovimiento = DescripcionMovimiento;
        this.EfectoMovimiento = EfectoMovimiento;
    }

    public clsPais(int IdMovimiento, String DescripcionMovimiento, String EfectoMovimiento, String EstatusMovimiento) {
        this.IdMovimiento = IdMovimiento;
        this.DescripcionMovimiento = DescripcionMovimiento;
        this.EfectoMovimiento = EfectoMovimiento;
        this.EstatusMovimiento = EstatusMovimiento;
    }

    public clsPais(int IdMovimiento, String DescripcionMovimiento) {
        this.IdMovimiento = IdMovimiento;
        this.DescripcionMovimiento = DescripcionMovimiento;
    }

    public clsPais(int IdMovimiento) {
        this.IdMovimiento = IdMovimiento;
    }

    public clsPais() {
    }

    //Metodos de acceso a la capa controlador
    /*public clsPais getBuscarInformacionMovimientoPorEfecto(clsPais Movimientos)
    {
        daoPais daomovimientos = new daoPais();
        return daomovimientos.consultaMovimientosPorEfecto(Movimientos);
    }*/
    public clsPais getBuscarInformacionMovimientosPorId(clsPais Movimientos)
    {
        daoPais daomovimientos = new daoPais();
        return daomovimientos.consultaMovimientosPorId(Movimientos);
    }
    public List<clsPais> getListadoMovimientos()
    {
        daoPais daomovimientos = new daoPais();
        List<clsPais> listadoMovimientos = daomovimientos.consultaMovimientos();
        return listadoMovimientos;
    }
    public int setBorrarMovimientos(clsPais Movimientos)
    {
        daoPais daomovimientos = new daoPais();
        return daomovimientos.borrarMovimientos(Movimientos);
    }
    public int setIngresarMovimientos(clsPais Movimientos)
    {
        daoPais daomovimientos = new daoPais();
        return daomovimientos.ingresaMovimientos(Movimientos);
    }              
    public int setModificarMovimientos(clsPais Movimientos)
    {
        daoPais daomovimientos = new daoPais();
        return daomovimientos.actualizaMovimientos(Movimientos);
    }

    public void add(List<clsPais> Movimientos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
