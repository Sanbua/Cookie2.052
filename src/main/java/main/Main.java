package main;

import controlador.CookieDriver;
import controlador.Logger;

import java.io.*;


public class Main {

    public static void main(String[] args) {

        CookieDriver prueba = new CookieDriver();

        Logger log = new Logger();
        String partida = log.leerLog();

        prueba.web();
        prueba.aceptaCookies();

        prueba.cargaPartida(partida);
        prueba.cerrarDriver();
    }


    public static String leerLog() throws FileNotFoundException, IOException {
        File file = new File("log\\logSave");

        InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(streamReader);
        String line = new String();

        while (br.ready()) {
            line = br.readLine();
        }

        return line;


    }
}
