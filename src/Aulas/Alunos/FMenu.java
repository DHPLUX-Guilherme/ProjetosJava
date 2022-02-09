package Aulas.Alunos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class FMenu {
    private JPanel FMenuP;
    private JButton buttonTurma;
    private JButton buttonAlunos;

    public static void setVisible(boolean b)
    {
        JFrame frame = new JFrame("Gestão de Turmas");
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(new FMenu().FMenuP);
        frame.setVisible(true);
    }

    public FMenu() {
        buttonAlunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FAlunos.setVisible(true);
            }
        });

        buttonTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    FTurmas.setVisible(true);
            }
        });
    }
}
