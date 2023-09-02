package main;

import controlador.CookieDriver;
import controlador.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame{
    private JPanel Base;
    private JPanel PanelTop;
    private JPanel PanelBotom;
    private JButton startButton;
    private JButton stopButton;
    private JButton clickCookie;
    private JButton stopClick;

    public Ventana(CookieDriver driver) {
        setContentPane(Base);
        setTitle("CookieCliker");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                driver.web();
                driver.ventanaGrande();
                driver.aceptaCookies();
                driver.cargaPartida(new Logger().leerLog());
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                driver.cerrarDriver();
            }
        });
        clickCookie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(true){
                            driver.clickBigCookie();
                        }
                    }
                });
                thread.start();
            }
        });

    }



}
