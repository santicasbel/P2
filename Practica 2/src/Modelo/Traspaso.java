/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Javier Argente Micó
 */
public class Traspaso {

    private static int contador = 1;

    private int id_traspaso;
    private String nombre;
    private String demarcacion;
    private String fecha;
    private String equipo_origen;
    private String equipo_destino;
    private int importe;

    public Traspaso(Jugador j, Equipo equipo_origen, Equipo equipo_destino) {

        this.id_traspaso = contador;
        this.nombre = j.getNombre();
        this.demarcacion = j.getDemarcacion();
        this.importe = j.getClausula();
        this.equipo_origen = equipo_origen.getNombre();
        this.equipo_destino = equipo_destino.getNombre();

        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);

        this.fecha = dia + "/" + (mes + 1) + "/" + año;

        this.contador += 1;

    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEquipo_origen() {
        return equipo_origen;
    }

    public String getEquipo_destino() {
        return equipo_destino;
    }

    public int getImporte() {
        return importe;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setEquipo_origen(String equipo_origen) {
        this.equipo_origen = equipo_origen;
    }

    public void setEquipo_destino(String equipo_destino) {
        this.equipo_destino = equipo_destino;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {

        String id = String.format("%03d", this.id_traspaso);

        String s = id + "\t" + this.nombre + " (" + this.demarcacion + ")" + this.equipo_origen + " -> " + this.equipo_destino + "  Clausula pagada:" + this.importe + "\n";

        return s;

    }

}
