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
    private JCheckBox megaClickOnOff;
    private JTextArea printsArea;
    private JScrollPane scrollPrintsArea;

    public Ventana(CookieDriver driver) {
        setContentPane(Base);
        setTitle("CookieCliker");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        printsArea.setLineWrap(true);

        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                driver.initDriver();
                driver.web();
                driver.ventanaGrande();
                driver.aceptaCookiesPrim();
                driver.cargaPartida(new Logger().leerLog());
                driver.aceptaCookiesSec();
                stopButton.setEnabled(true);
                megaClickOnOff.setEnabled(true);
                startButton.setEnabled(false);
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                driver.cerrarDriver();
                startButton.setEnabled(true);
                megaClickOnOff.setEnabled(false);
                stopButton.setEnabled(false);
            }
        });

        megaClickOnOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(megaClickOnOff.isSelected()){
                            driver.clickBigCookie();
                            printsArea.append(driver.clickGoldenCookie());
                        }
                    }
                });
                thread.start();
            }
        });


    }


}
