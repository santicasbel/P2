/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Liga;
import Modelo.Traspaso;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Javier Argente Micó
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException {

        Equipo equipo1 = new Equipo("Valencia", 30000000, 100000, 100000);
        Equipo equipo2 = new Equipo("Barcelona", 120000000, 500000, 100000);
        Equipo equipo3 = new Equipo("Real Madrid", 100000000, 400000, 50000000);

        Jugador j1 = new Jugador("Leo Messi", "Delantero", 100000000, 30000000);
        Jugador j2 = new Jugador("Ter Stegen", "Portero", 20000000, 10000000);
        Jugador j3 = new Jugador("Pique", "Defensa", 40000000, 15000000);
        Jugador j4 = new Jugador("Busquets", "Medio", 60000000, 20000000);

        Jugador j5 = new Jugador("Cristiano Ronaldo", "Delantero", 90000000, 50000000);
        Jugador j6 = new Jugador("Keylor Navas", "Portero", 30000000, 40000000);
        Jugador j7 = new Jugador("Sergio Ramos", "Defensa", 40000000, 15000000);
        Jugador j8 = new Jugador("Modric", "Medio", 70000000, 20000000);

        Jugador j9 = new Jugador("Rodrigo", "Delantero", 20000000, 100000);
        Jugador j10 = new Jugador("Diego Alves", "Portero", 30000000, 100000);
        Jugador j11 = new Jugador("Mustafi", "Defensa", 40000000, 100000);
        Jugador j12 = new Jugador("Javi Fuego", "Medio", 20000000, 100000);
        Jugador j13 = new Jugador("Javi Fuego", "Delantero", 20000000, 100000);
        Jugador j14 = new Jugador("Javi Fuego", "Delantero", 20000000, 100000);
        Jugador j15 = new Jugador("Javi Fuego", "Portero", 20000000, 100000);
        Jugador j16 = new Jugador("Javi Fuego", "Defensa", 20000000, 100000);
        Jugador j17 = new Jugador("Javi Fuego", "Defensa", 20000000, 100000);
        Jugador j18 = new Jugador("Javi Fuego", "Defensa", 20000000, 100000);
        Jugador j19 = new Jugador("Javi Fuego", "Medio", 20000000, 100000);
        Jugador j20 = new Jugador("Javi Fuego", "Medio", 20000000, 100000);
        Jugador j21 = new Jugador("Javi Fuego", "Medio", 20000000, 100000);
        
        //Traspaso t1 = new Traspaso(j1, equipo2, equipo1);
        //Traspaso t2 = new Traspaso(j9, equipo1, equipo2);
        //Traspaso t3 = new Traspaso(j5, equipo3, equipo1);

        equipo1.setJugadores(j9);
        equipo1.setJugadores(j10);
        equipo1.setJugadores(j11);
        equipo1.setJugadores(j12);
        equipo1.setJugadores(j13);
        equipo1.setJugadores(j14);
        equipo1.setJugadores(j15);
        equipo1.setJugadores(j16);
        equipo1.setJugadores(j17);
        equipo1.setJugadores(j18);
        equipo1.setJugadores(j19);
        equipo1.setJugadores(j20);
        equipo1.setJugadores(j21);

        equipo2.setJugadores(j1);
        equipo2.setJugadores(j2);
        equipo2.setJugadores(j3);
        equipo2.setJugadores(j4);

        equipo3.setJugadores(j5);
        equipo3.setJugadores(j6);
        equipo3.setJugadores(j7);
        equipo3.setJugadores(j8);

        Liga liga = new Liga();
        
        liga.setEquipos(equipo1);
        liga.setEquipos(equipo2);
        liga.setEquipos(equipo3);
        
        //liga.setTraspasos(t2);
        //liga.setTraspasos(t1);
        //liga.setTraspasos(t3);

        String eleccion = null;
        
        do {
            try{
            System.out.println("1. Registrar un nuevo equipo" + "\n" + "2. Registrar un nuevo jugador " + "\n" + "3. Registrar un traspaso de jugador " + "\n"
                    + "4. Listar en pantalla los datos básicos de los equipos registrados" + "\n" + "5. Listar los jugadores de cada equipo" + "\n"
                    + "6. Mostrar los traspasos realizados" + "\n" + "7. Modificar demarcacion" + "\n" + "8. Fair Play" + "\n" + "9. Verificar demarcaciones de un equipo" + "\n" + "10. Salir del programa" + "\n");

            Scanner entradaEscaner = new Scanner(System.in);

            String entradaTeclado = entradaEscaner.nextLine();
            
            eleccion = entradaTeclado;
            
            switch(eleccion){
                
                case "1":
                    System.out.println("\nIntroduce el nombre del equipo");
                    String nombre_equipo = entradaEscaner.nextLine();
                    
                    System.out.println("Introduce la caja actual del equipo");
                    String caja_actual = entradaEscaner.nextLine();
                    
                    System.out.println("Introduce los abonados del equipo");
                    String abonados = entradaEscaner.nextLine();
                    
                    System.out.println("Introduce el gasto general del equipo");
                    String gastos_generales = entradaEscaner.nextLine();
                    
                    liga.nuevo_equipo(nombre_equipo, Integer.parseInt(caja_actual), Integer.parseInt(abonados), Integer.parseInt(gastos_generales));
                    break;
                    
                case "2":
                    
                    System.out.println("Introduce el nombre del jugador");
                    String nombre_jugador = entradaEscaner.nextLine();
                    
                    System.out.println("Introduce la posicion del jugador(Delantero,Medio,Defensa,Portero)");
                    String demarcacion = entradaEscaner.nextLine();
                    
                    System.out.println("Introduce la clausula del jugador");
                    String clausula = entradaEscaner.nextLine();
                    
                    System.out.println("Introduce el salario del jugador");
                    String salario_anual = entradaEscaner.nextLine();
                    
                    //liga.listar_datos_equipos();
                    String equipos = liga.listar_datos_equipos();
                    System.out.println(equipos);
                    
                    System.out.println("Introduce el id del equipo al que pertenecera el jugador");
                    String id_equipo = entradaEscaner.nextLine();
                    
                    liga.nuevo_jugador(nombre_jugador, demarcacion, Integer.parseInt(clausula), Integer.parseInt(id_equipo),Integer.parseInt(salario_anual) );
                    
                    break;
                
                case "3":
                    //liga.listar_datos_equipos();
                    equipos = liga.listar_datos_equipos();
                    System.out.println(equipos);
                    
                    System.out.println("Introduce el id del equipor origen");
                    String id_equipo_origen = entradaEscaner.nextLine();
                    
                    //liga.listar_jugadores(Integer.parseInt(id_equipo_origen));
                    String jugadores = liga.listar_jugadores(Integer.parseInt(id_equipo_origen));
                    System.out.println(jugadores);
                    
                    System.out.println("Introduce el id del jugador");
                    String id_jugador = entradaEscaner.nextLine();
                    
                    equipos = liga.listar_datos_equipos();
                    System.out.println(equipos);
                    
                    
                    System.out.println("Introduce el id del equipor destino");
                    String id_equipo_destino = entradaEscaner.nextLine();
                    
                    liga.traspaso(Integer.parseInt(id_equipo_origen), Integer.parseInt(id_jugador), Integer.parseInt(id_equipo_destino));
                    
                    break;
                    
                case "4":
                    equipos = liga.listar_datos_equipos();
                    System.out.println(equipos);
                    break;
                    
                case "5":
                   
                    jugadores = liga.listar_jugadores();
                    System.out.println(jugadores);
                    break;
                    
                case "6":
                    String traspasos = liga.traspasos_realizados();    
                    
                    System.out.println(traspasos);

                    break;
                    
                case "7":
                    
                    equipos = liga.listar_datos_equipos();
                    System.out.println(equipos);
                    
                    System.out.println("Introduce el id del equipor del jugador a modificar");
                    String id_equipo_modificacion = entradaEscaner.nextLine();
                    
                    String jugadores_modificables = liga.listar_jugadores(Integer.parseInt(id_equipo_modificacion));
                    System.out.println(jugadores_modificables);
                    
                    System.out.println("Introduce el id del jugador a modificar");
                    String id_jugador_modificable = entradaEscaner.nextLine();
                    
                    System.out.println("Introduce la nueva demarcacion(Delantero,Medio,Defensa,Portero)");
                    String nueva_demarcacion = entradaEscaner.nextLine();
                    
                    liga.modificar_jugador(Integer.parseInt(id_equipo_modificacion), Integer.parseInt(id_jugador_modificable), nueva_demarcacion);
                    
                    break;
                    
                case "8":
                    
                    equipos = liga.listar_datos_equipos();
                    System.out.println(equipos);
                    
                    System.out.println("Introduce el id del equipo a analizar");
                    String id_equipo_fair_play = entradaEscaner.nextLine();
                    
                    liga.fair_play(Integer.parseInt(id_equipo_fair_play));
                    
                    break;
                    
                case "9":
                    
                    equipos = liga.listar_datos_equipos();
                    System.out.println(equipos);
                    
                    System.out.println("Introduce el id del equipo del cual desea verificar las demarcaciones");
                    String id_equipo_demarcaciones = entradaEscaner.nextLine();
                    
                    liga.verificar_demarcaciones(Integer.parseInt(id_equipo_demarcaciones));
                    
                    break;
                
                case "10":
                    FileWriter fichero = null;
                    PrintWriter pw = null;
                    
                    System.out.println("\nIntroduce el nombre del fichero (ejemplo.txt)");
                    String nombre_fichero = entradaEscaner.nextLine();
                    try
                    {
                       fichero = new FileWriter(nombre_fichero);
                       equipos = liga.listar_datos_equipos();
                       jugadores = liga.listar_jugadores();
                       traspasos = liga.traspasos_realizados();  
                       
                       //Escribir en fichero todos los datos
                       
                       fichero.write(equipos + " \r \n");
                       fichero.write(jugadores + " \r \n ");
                       fichero.write(traspasos + " \r \n");

                    } catch (Exception e) {
                        System.out.println( " \n No se ha podido crear el fichero \n");   
                    } 
                    
                    finally {
                       try {
                       // Nuevamente aprovechamos el finally para 
                       // asegurarnos que se cierra el fichero.
                       if (null != fichero)
                          fichero.close();
                       } catch (Exception e2) {
                          System.out.println( " \n El fichero no se ha cerrado correctamente \n");
                       }
                    }
                    break;
                    
                    default:
                        System.out.println("\nOpcion incorrecta\n");
                        break;
                
            }
            }catch(Exception e3) { System.out.println( " \n Algún campo no escrito correctamente  \n");
        }
        } while (!"10".equals(eleccion));
        
        

    }
    

}
