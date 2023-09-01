package main;

import controlador.CookieDriver;
import controlador.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Base;
    private JPanel PanelTop;
    private JPanel PanelBotom;
    private JButton startButton;
    private JButton stopButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Base);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Ventana() {
    startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
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
    });
    stopButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
}
}
