package main;

import controlador.CookieDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        CookieDriver prueba = new CookieDriver();
        prueba.web();
        prueba.aceptaCookies();
        prueba.cargaPartida();
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
