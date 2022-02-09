package Aulas.Produtos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FVitrine {
    private JButton entrarNaLojaButton;
    private JPanel panelVitrine;
    public JButton gerenciarLojaButton;


    public FVitrine() {
        panelVitrine.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);

            }
        });

        entrarNaLojaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void setVisible(boolean b){

        JFrame frame = new JFrame("Vitrine");
        frame.setContentPane(new FVitrine().panelVitrine);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }




}
