package Aulas.Jogadores;

import Aulas.Alunos.FMenu;
import Aulas.Alunos.FTurmas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GDJEC {
    private JButton clubesButton;
    private JPanel panel1;
    private JButton jogadoresButton;
    private JLabel Nome;
    private JLabel CC;

    public static void setVisible(boolean b)
    {
        JFrame frame = new JFrame("Gestão de Turmas");
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(new GDJEC().panel1);
        frame.setVisible(true);
    }


    public GDJEC() {


        jogadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JogaComDores.setVisible(true);
            }
        });
        clubesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CluTeubes.setVisible(true);
            }
        });

        LoginF loginf = new LoginF();

    }
}
