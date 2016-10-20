/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Javier Argente Micó
 */
public class Jugador {
    
    private static int contador = 1;
    
    private int id_jugador;
    private String nombre;
    private String demarcacion;
    private int clausula;
    private int salario_anual;
    
    public Jugador(String nombre, String demarcacion, int clausula, int salario_anual){
        
        this.id_jugador = contador;
        this.nombre = nombre;
        this.demarcacion = demarcacion;
        this.clausula = clausula;
        this.salario_anual = salario_anual;
        
        this.contador += 1;
        
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDemarcacion(String demarcacion) {
        this.demarcacion = demarcacion;
    }

    public void setClausula(int clausula) {
        this.clausula = clausula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDemarcacion() {
        return demarcacion;
    }

    public int getClausula() {
        return clausula;
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public int getSalario_anual() {
        return salario_anual;
    }
    
    @Override
    public String toString() {

        String id = String.format("%03d", this.id_jugador);
        
        String s = id + "\t" + this.nombre + " (" + this.demarcacion + ")" + "\n";

        return s;

    }
}
