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

    public int getGastos_generales() {
        return gastos_generales;
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
    
    //Funcion para eliminar un jugador del equipo que realiza la llamada de la funcion, se le pasa el id del jugador que se desea eliminar
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
    
    //Funcion para listar la informacion de los jugadores del equipo
    public String listar_jugadores(){
        
        String item;
        
        item = "\n" + this.nombre + ":" + "\n";
        
        for (int i = 0; i < this.jugadores.size(); i++) {
            
            item += "\t" + this.jugadores.get(i).toString();
            
        }
        
        return item;
        
    }
    
    //Funcion para encontrar y devolver un jugador del equipo que realiza la llamada de la funcion, se le pasa el id del jugador que se desea obtener
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
    
    //Funcion para modificar la demarcacion de un jugador del equipo que realiza la llamada de la funcion, se le pasa el id del jugador que se desea modificar y su nueva demarcacion
    public void modificar_jugador(int id_jugador_modificable, String nueva_demarcacion){
        
        int i = 0;
        boolean encontrado = false;
        
        while(i < this.jugadores.size() && encontrado == false){
            
            if(this.jugadores.get(i).getId_jugador() == id_jugador_modificable){
                
                encontrado = true;
                this.jugadores.get(i).setDemarcacion(nueva_demarcacion);
                
            }
            
            i++;
            
        }
        
        System.out.println("Se ha realizado la modificacion con exito\n");
        
    }
    
    //Funcion para comprobar si el equipo que realiza la llamada de la funcion tiene suficiente caja actual para hacer frente a todos sus gastos
    public void fair_play(){
        
        int total = 0;
        
        total += this.getGastos_generales();
        
        for(int i = 0; i < this.jugadores.size(); i++){
            
            total += (this.jugadores.get(i).getSalario_anual() * 2);
            
        }
        
        if (this.getCaja_actual() >= total)
            System.out.println("El equipo cumple el fair play\n");
        else
            System.out.println("El equipo no cumple el fair play\n");
        
    }
    
    //Funcion para verificar si el equipo que realiza la llamada tiene los jugadores minimos para poder registrarse en la liga
    public void verificar_demarcaciones(){
        
        int porteros = 0;
        int defensas = 0;
        int medios = 0;
        int delanteros = 0;
        
        for(int i = 0; i < this.jugadores.size(); i++){
            
            if("Portero".equals(this.jugadores.get(i).getDemarcacion()))
                porteros += 1;
            if("Delantero".equals(this.jugadores.get(i).getDemarcacion()))
                delanteros += 1;
            if("Defensa".equals(this.jugadores.get(i).getDemarcacion()))
                defensas += 1;
            if("Medio".equals(this.jugadores.get(i).getDemarcacion()))
                medios += 1;
            
        }
        
        System.out.println("El equipo " + this.nombre + "tiene:\n" + "\t- " + porteros + " porteros\n" + "\t- " + defensas + " defensas\n" 
                           + "\t- " + medios + " medios\n" + "\t- " + delanteros + " delanteros\n\n");
        
        if(porteros >= 2 && defensas >= 4 && medios >= 4 && delanteros >= 3)
           System.out.println("El equipo si cumple los requisitos de las demarcaciones\n");
        else
           System.out.println("El equipo no cumple los requisitos de las demarcaciones\n");
        
    }
    
    @Override
    public String toString() {

        String id = String.format("%03d", this.id_equipo);
        
        String s = id + "\t" + this.nombre + "\t" + " - Abonados:" + this.abonados + "\t" + " - Caja Actual:" + this.caja_actual + " \n"
                   + "Gaston generales: " + this.gastos_generales + "\n\n";

        return s;

    }
    
}
