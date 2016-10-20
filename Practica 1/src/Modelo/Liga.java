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

    public String listar_datos_equipos() {

        String item = "\n";

        for (int i = 0; i < this.equipos.size(); i++) {

            item += this.equipos.get(i).toString();

        }

        return item;
        

    }

    public String listar_jugadores() {

        String jugadores = "";
        for (int i = 0; i < this.equipos.size(); i++) {

            e = equipos.get(i);

            jugadores = jugadores + e.listar_jugadores();

        }
        return jugadores;
    }

    public String listar_jugadores(int id) {

        e = equipos.get(id - 1);
        
        String jugadores = e.listar_jugadores();
        
           return jugadores;
    }

    public String traspasos_realizados() {

        this.ordenar(traspasos);

        String item = "\n";

        for (int i = 0; i < this.traspasos.size(); i++) {

            item += this.traspasos.get(i).toString();

        }

        return item;
    }

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

    public void nuevo_equipo(String nombre, int caja_actual, int abonados, int gastos_generales) {

        Equipo e_aux = new Equipo(nombre, caja_actual, abonados, gastos_generales);

        this.setEquipos(e_aux);

        System.out.println("\nEquipo registrado correctamente\n");

    }

    public void nuevo_jugador(String nombre, String demarcacion, int clausula, int id_equipo, int sueldo_anual) {

        Jugador j_aux = new Jugador(nombre, demarcacion, clausula, sueldo_anual);

        this.equipos.get(id_equipo - 1).setJugadores(j_aux);

        System.out.println("\nJugador registrado correctamente\n");

    }
    
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
    
    public void modificar_jugador(int id_equipo_modificacion, int id_jugador_modificable, String nueva_demarcacion){
        
        Equipo e1 = equipos.get(id_equipo_modificacion - 1);

        e1.modificar_jugador(id_jugador_modificable, nueva_demarcacion);
    }
    
    public void fair_play(int id_equipo_fair_play){
        
        Equipo e1 = equipos.get(id_equipo_fair_play - 1);
        
        e1.fair_play();
        
    }

}
