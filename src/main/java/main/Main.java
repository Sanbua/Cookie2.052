package main;

import controlador.CookieDriver;
import controlador.Logger;


public class Main extends javax.swing.JFrame {

    public static void main(String[] args) {
        CookieDriver prueba = new CookieDriver();

        Logger log = new Logger();
        String partida = log.leerLog(); //cargar desde logFile

        prueba.web();
        prueba.ventanaGrande();
        prueba.aceptaCookies();

        prueba.cargaPartida(partida);
        prueba.clickBigCookie();

        prueba.cerrarDriver();

    }

}
