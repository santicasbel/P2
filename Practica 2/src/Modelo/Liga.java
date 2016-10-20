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
public class Liga {

    private ArrayList<Equipo> equipos = new ArrayList<Equipo>();
    private ArrayList<Traspaso> traspasos = new ArrayList<Traspaso>();

    private Equipo e;

    public Liga() {
    }

    public void setEquipos(Equipo e) {
        this.equipos.add(e);
    }

    public void setTraspasos(Traspaso t) {
        this.traspasos.add(t);
    }

    //Funcion para listas los datos generales de los equipos
    public String listar_datos_equipos() {

        String item = "\n";

        for (int i = 0; i < this.equipos.size(); i++) {

            item += this.equipos.get(i).toString();

        }

        return item;
        

    }

    //Funcion para listar los jugadores de cada uno de los equipos
    public String listar_jugadores() {

        String jugadores = "";
        for (int i = 0; i < this.equipos.size(); i++) {

            e = equipos.get(i);

            jugadores = jugadores + e.listar_jugadores();

        }
        return jugadores;
    }

    //Funcion para listar los jugadores de un quipo concreto
    public String listar_jugadores(int id) {

        e = equipos.get(id - 1);
        
        String jugadores = e.listar_jugadores();
        
           return jugadores;
    }

    //Funcion para ordenar y mostrar los traspasos de manera descendente en funcion de la clausula
    public String traspasos_realizados() {

        this.ordenar(traspasos);

        String item = "\n";

        for (int i = 0; i < this.traspasos.size(); i++) {

            item += this.traspasos.get(i).toString();

        }

        return item;
    }

    //Funcion para ordenar el ArrayList de traspasos
    public void ordenar(ArrayList<Traspaso> traspasos) {

        for (int i = 0; i < (traspasos.size() - 1); i++) {
            for (int j = i + 1; j < traspasos.size(); j++) {
                if (traspasos.get(i).getImporte() < traspasos.get(j).getImporte()) {

                    Traspaso t_aux = traspasos.get(i);
                    traspasos.set(i, traspasos.get(j));
                    traspasos.set(j, t_aux);

                }
            }
        }
    }

    //Funcion para registrar un nuevo equipo, donde se le pasa el nombre, caja, abonados y gastos generales del equipo
    public void nuevo_equipo(String nombre, int caja_actual, int abonados, int gastos_generales) {

        Equipo e_aux = new Equipo(nombre, caja_actual, abonados, gastos_generales);

        this.setEquipos(e_aux);

        System.out.println("\nEquipo registrado correctamente\n");

    }

    //Funcion para registrar un nuevo jugador, donde se le pasa el nombre, demarcacion, clausula, equipo al que va ha pertenecer y sueldo del jugador
    public void nuevo_jugador(String nombre, String demarcacion, int clausula, int id_equipo, int sueldo_anual) {

        if(demarcacion.equals("Delantero") || demarcacion.equals("Defensa") || demarcacion.equals("Medio") || demarcacion.equals("Portero")){
            
            Jugador j_aux = new Jugador(nombre, demarcacion, clausula, sueldo_anual);

            this.equipos.get(id_equipo - 1).setJugadores(j_aux);

            System.out.println("\nJugador registrado correctamente\n");
            
        }
        
        else
            System.out.println("\nDemarcacion del jugador incorrecta\n");

    }
    
    //Funcion para realizar y registrar un traspaso, donde se le pasa el id del equipo origen y destino del traspaso asi como el id del jugador a traspasar
    public void traspaso(int id_origen, int id_jugador, int id_destino){
        
        Equipo e1 = equipos.get(id_origen - 1);
        Equipo e2 = equipos.get(id_destino - 1);
        
        Jugador j = e1.getJugador(id_jugador);
        int c_aux = j.getClausula();
        
        Traspaso t_aux = null;
        
        if(e2.getCaja_actual() >= j.getClausula()){
            
            e1.setCaja_actual(c_aux);
            e2.setCaja_actual(- c_aux);
            
            e2.setJugadores(j);
            e1.eliminar_jugador(id_jugador);
            
            t_aux = new Traspaso(j, e1, e2);
            traspasos.add(t_aux);
            
            System.out.println("Se ha realizado el traspaso con exito\n");
            
        }
        else{
            
            System.out.println("El equipo no dispone del dinero suficiente para la compra del jugador\n");
            
        }
        
    }
    
    //Funcion para modificar la demarcacion de un jugador de un equipo concreto, donde se le pasa el id del equipo al que pertenece el jugador, el id del jugador y su nueva demarcacion
    public void modificar_jugador(int id_equipo_modificacion, int id_jugador_modificable, String nueva_demarcacion){
        
        if(nueva_demarcacion.equals("Delantero") || nueva_demarcacion.equals("Defensa") || nueva_demarcacion.equals("Medio") || nueva_demarcacion.equals("Portero")){
            
            Equipo e1 = equipos.get(id_equipo_modificacion - 1);

            e1.modificar_jugador(id_jugador_modificable, nueva_demarcacion);
            
        }
        
        else
            System.out.println("La nueva demarcacion no es correcta\n");
        
    }
    
    //Funcion para comprobar si un equipo es capaz de soportar todos los gastos que tiene con su caja actual, se le pasa el id del equipo que se desea evaluar
    public void fair_play(int id_equipo_fair_play){
        
        Equipo e1 = equipos.get(id_equipo_fair_play - 1);
        
        e1.fair_play();
        
    }
    
    //Funcion para verificar si un equipo tiene la cantidad de jugadores necesarios para poder registrarse en la liga, se le pasa el id del equipo que se desea evaluar 
    public void verificar_demarcaciones(int id_equipo_demarcaciones){
        
        Equipo e1 = this.equipos.get(id_equipo_demarcaciones - 1);
        
        e1.verificar_demarcaciones();
        
    }

}
