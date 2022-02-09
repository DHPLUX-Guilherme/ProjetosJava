package Aulas.Jogadores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class CluTeubes {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JButton adicionarJogadoresButton;
    private JTextField textFieldNomeDoClube;
    private JTextArea textArea1;
    private JButton guardarClubeButton;
    private JTextArea textAreaMostrarClube;
    private JTextField textFieldProcuraDoClub;
    private JButton procurarClubeButton;
    private JButton buttonEliProcurar;
    private JTextField textFieldEli;
    private JTextArea textArea2;
    private JButton eliminarButton;
    private JButton procurarAlButton;
    private JTextField textFieldAlProcurar;
    private JTextArea textAreaAl;
    private JButton AlterarAlButton;


    public static Clubes clubes;
    public static ArrayList<Clubes> clu = new ArrayList<Clubes>();

    public CluTeubes() {
        adicionarJogadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Jogadores j: JogaComDores.jogadores)
                {
                    textArea1.append(j.toString() + "\n");
                }
            }
        });
        guardarClubeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textArea1.getText() != "" && textFieldNomeDoClube.getText() != "")
                {
                    clubes = new Clubes();
                    clubes.setDesignação(textFieldNomeDoClube.getText());
                    clubes.setConjutJogadores(JogaComDores.jogadores);
                    clu.add(clubes);
                    JOptionPane.showMessageDialog(null, "O clube " + clubes.getDesignação() +
                            " foi guardado com sucesso!");
                }
            }
        });
        textAreaMostrarClube.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);


            }
        });
        procurarClubeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldProcuraDoClub.getText();
                for(Clubes a: clu)
                {
                    if(a.Designação.equals(nome))
                    {
                        textAreaMostrarClube.append(a.toString());

                    }
                }
            }
        });
    }

    public static void setVisible(boolean b){

        JFrame frame = new JFrame("Gestão de Clubes");
        frame.setContentPane(new CluTeubes().panel1);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
