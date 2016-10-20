/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Javier Argente Micó
 */
public class Equipo {
    
    private static int contador = 1;
    
    private int id_equipo;
    private String nombre;
    private int caja_actual;
    private int abonados;
    private int gastos_generales;
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    
    public Equipo(String nombre, int caja_actual, int abonados, int gastos_generales){
        
        this.id_equipo = contador;
        this.nombre = nombre;
        this.caja_actual = caja_actual;
        this.abonados = abonados;
        this.gastos_generales = gastos_generales;
        
        this.contador += 1;
        
    }

    public String getNombre() {
        return nombre;
    }

    public int getCaja_actual() {
        return caja_actual;
    }

    public int getAbonados() {
        return abonados;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCaja_actual(int caja_actual) {
        this.caja_actual += caja_actual;
    }

    public void setAbonados(int abonados) {
        this.abonados = abonados;
    }

    public void setJugadores(Jugador j) {
        this.jugadores.add(j);
    }
    
    public Jugador eliminar_jugador(int id){
        
        boolean encontrado = false;
        int i = 0;
        
        Jugador j_aux = null;
        
        while (i < this.jugadores.size() && encontrado == false) {
            
            j_aux = jugadores.get(i);
            
            if(j_aux.getId_jugador() == id){
                
                jugadores.remove(j_aux);
                encontrado = true;
                
            }
            
            i++;
            
        }
        
        return j_aux;
        
    }
    
    public String listar_jugadores(){
        
        String item;
        
        item = "\n" + this.nombre + ":" + "\n";
        
        for (int i = 0; i < this.jugadores.size(); i++) {
            
            item += "\t" + this.jugadores.get(i).toString();
            
        }
        
        return item;
        
    }
    
    public Jugador getJugador(int id_jugador){
        
        boolean encontrado = false;
        int i = 0;
        Jugador j_aux = null;
        
        while(i < jugadores.size() && encontrado == false){
            
            j_aux = jugadores.get(i);
            
            if(j_aux.getId_jugador() == id_jugador){
                
                encontrado = true;
                
            }
            
            i++;
            
        }
        
        return j_aux;
        
    }
    
    @Override
    public String toString() {

        String id = String.format("%03d", this.id_equipo);
        
        String s = id + "\t" + this.nombre + "\t" + " - Abonados:" + this.abonados + "\t" + " - Caja Actual:" + this.caja_actual + " \n"
                   + "Gaston generales: " + this.gastos_generales + "\n\n";

        return s;

    }
    
}
