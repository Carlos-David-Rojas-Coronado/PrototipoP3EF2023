/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Se agrega todo el codigo para la parte del controlador del mantenimiento de lineas
//Victor Josué Jerez Mijangos 9959-21-2081

package Depotivo.Controlador;
import java.util.List;
import Depotivo.Modelo.daoTipoPuesto;
/**
 *
 * @author visitante
 */
public class clsTipoPuesto {
    private int IdTipo;
    private String NombrePuesto;
    private int Salario;

    public clsTipoPuesto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdTipo() {
        return IdTipo;
    }

    public void setIdTipo(int IdPuesto) {
        this.IdTipo = IdPuesto;
    }

    public String getNombrePuesto() {
        return NombrePuesto;
    }

    public void setNombrePuesto(String NombrePuesto) {
        this.NombrePuesto = NombrePuesto;
    }

    public int getSalarios() {
        return Salario;
    }

    public void setSalarios(int Salarios) {
        this.Salario = Salarios;
    }

    public clsTipoPuesto(int IdPuesto, String NombrePuesto, int Salarios) {
        this.IdTipo = IdPuesto;
        this.NombrePuesto = NombrePuesto;
        this.Salario = Salarios;
    }

    public clsTipoPuesto(int IdTipo, String NombrePuesto) {
        this.IdTipo = IdTipo;
        this.NombrePuesto = NombrePuesto;
    }

    public clsTipoPuesto(int IdTipo) {
        this.IdTipo = IdTipo;
    }

    //Metodos de acceso a la capa controlador
    public clsTipoPuesto getBuscarInformacionPuestoPorNombre(clsTipoPuesto Puesto)
    {
        daoTipoPuesto daopuesto = new daoTipoPuesto();
        return daopuesto.consultaPuestosPorNombre(Puesto);
    }
    public clsTipoPuesto getBuscarInformacionPuestosPorId(clsTipoPuesto puesto)
    {
        daoTipoPuesto daolineas = new daoTipoPuesto();
        return daolineas.consultaPuestosPorId(puesto);
    }
    public List<clsTipoPuesto> getListadoPuestos()
    {
        daoTipoPuesto daotipo = new daoTipoPuesto();
        List<clsTipoPuesto> listadoPuestos = daotipo.consultaPuesto();
        return listadoPuestos;
    }
    public int setBorrarPuestos(clsTipoPuesto Puestos)
    {
        daoTipoPuesto daopuesto = new daoTipoPuesto();
        return daopuesto.borrarPuesto(Puestos);
    }
    public int setIngresarPuestos(clsTipoPuesto Puestos)
    {
        daoTipoPuesto daolineas = new daoTipoPuesto();
        return daolineas.ingresaPuesto(Puestos);
    }              
    public int setModificarPuestos(clsTipoPuesto Puestos)
    {
        daoTipoPuesto daolineas = new daoTipoPuesto();
        return daolineas.actualizaPuesto(Puestos);
    }

    public void add(List<clsTipoPuesto> Puestos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
