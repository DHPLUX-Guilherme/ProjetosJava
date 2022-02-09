package Aulas.Jogadores;

import Aulas.Alunos.Aluno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class JogaComDores {

    private JTabbedPane tabbedPane1;
    private JTextField textFieldNome;
    private JTextField textFieldIdade;
    private JTextField textFieldPeso;
    private JTextField textFieldAltura;
    private JButton gravarButton;
    private JTextField textFieldCamisola;
    private JTextField textFieldMorada;
    private JTextField textFieldPosição;
    private JTextField textFieldRenumera;
    private JTextArea textAreaMOstrar;
    private JTextField textFieldProcura;
    private JButton pesquisarButton;
    private JTextField textFieldAlNome;
    private JTextField textFieldAlIdade;
    private JTextField textFieldAlPeso;
    private JTextField textFieldAlAltura;
    private JTextField textFieldAlCamisa;
    private JTextField textFieldAlMorada;
    private JTextField textFieldAlPosicao;
    private JTextField textFieldAlRemunera;
    private JButton alterarButton;
    private JTextArea textAreaInfo;
    private JButton procurarButton;
    private JButton eliminarButton;
    private JTextField textFieldEliminar;
    private JButton novoButton;
    private JLabel LabelIndiceCorpo;

    public static void setVisible(boolean b){

        JFrame frame = new JFrame("Gestão de Jogadores");
        frame.setContentPane(new JogaComDores().tabbedPane1);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


    public static Jogadores jogador;
    public static ArrayList<Jogadores> jogadores = new ArrayList<Jogadores>();

    public JogaComDores() {
        gravarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(textFieldAltura.getText() != "" && textFieldNome.getText() != "" && textFieldIdade.getText() != "" &&
                        textFieldCamisola.getText() != "" && textFieldPeso.getText() != "" && textFieldPosição.getText() != "" &&
                        textFieldMorada.getText() != "" && textFieldRenumera.getText() != "" )
                {
                    try {


                        jogador = new Jogadores();
                        jogador.Nome = textFieldNome.getText();
                        jogador.Altura = Double.parseDouble(textFieldAltura.getText());
                        jogador.Peso = Double.parseDouble(textFieldPeso.getText());
                        jogador.Remunera = Double.parseDouble(textFieldRenumera.getText());
                        jogador.PosNoCampo = textFieldPosição.getText();
                        jogador.NCamisola = Integer.parseInt(textFieldCamisola.getText());
                        jogador.Morada = textFieldMorada.getText();
                        jogador.Idade = Integer.parseInt(textFieldIdade.getText());
                        LabelIndiceCorpo.setText(String.valueOf(jogador.MassCorpo()));
                        jogadores.add(jogador);


                        JOptionPane.showMessageDialog(null, "Jogador " + jogador.getNome() +
                                " guardado com sucesso!");

                        textFieldNome.setText("");
                        textFieldAltura.setText("");
                        textFieldPeso.setText("");
                        textFieldRenumera.setText("");
                        textFieldPosição.setText("");
                        textFieldCamisola.setText("");
                        textFieldMorada.setText("");
                        textFieldIdade.setText("");
                        LabelIndiceCorpo.setText("");
                    }
                    catch (NumberFormatException nfe)
                    {
                        JOptionPane.showMessageDialog(null, "Erro: " + nfe.getMessage());
                    }
                }else
                {
                    JOptionPane.showMessageDialog(null, "Dados Incompletos! Por favor, complete os dados!");
                }
            }
        });
        textAreaMOstrar.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textFieldNome.setText("");
                textFieldAltura.setText("");
                textFieldPeso.setText("");
                textFieldRenumera.setText("");
                textFieldPosição.setText("");
                textFieldCamisola.setText("");
                textFieldMorada.setText("");
                textFieldIdade.setText("");

                textFieldAlNome.setText("");
                textFieldAlAltura.setText("");
                textFieldAlPeso.setText("");
                textFieldAlRemunera.setText("");
                textFieldAlPosicao.setText("");
                textFieldAlCamisa.setText("");
                textFieldAlMorada.setText("");
                textFieldAlIdade.setText("");
                textAreaMOstrar.setText("");

                for(Jogadores j: jogadores)
                {
                    textAreaMOstrar.append(j.toString() + "\n");
                    textAreaMOstrar.setWrapStyleWord(true);

                }

            }
        });
        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldProcura.getText();
                for(Jogadores j: jogadores)
                    if(j.Nome.equals(nome))
                    {
                        textFieldAlNome.setText(j.getNome());
                        textFieldAlAltura.setText(String.valueOf(j.getAltura()));
                        textFieldAlCamisa.setText(String.valueOf(j.getNCamisola()));
                        textFieldAlIdade.setText(String.valueOf(j.getIdade()));
                        textFieldAlMorada.setText(j.getMorada());
                        textFieldAlPeso.setText(String.valueOf(j.getPeso()));
                        textFieldAlPosicao.setText(j.getPosNoCampo());
                        textFieldAlRemunera.setText(String.valueOf(j.getRemunera()));
                        jogador = j;


                    }

            }
        });
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldProcura.getText();
                if(textFieldAlAltura.getText() != "" && textFieldAlNome.getText() != "" && textFieldAlIdade.getText() != "" &&
                        textFieldAlCamisa.getText() != "" && textFieldAlPeso.getText() != "" && textFieldAlPosicao.getText() != "" &&
                        textFieldAlMorada.getText() != "" && textFieldAlRemunera.getText() != "" )
                {
                    try {
                        for (Jogadores j : jogadores) {
                            if (j.getNome().equals(nome)) {
                                j.Nome = textFieldAlNome.getText();
                                j.Altura = Double.parseDouble(textFieldAlAltura.getText());
                                j.Peso = Double.parseDouble(textFieldAlPeso.getText());
                                j.Remunera = Double.parseDouble(textFieldAlRemunera.getText());
                                j.PosNoCampo = textFieldPosição.getText();
                                j.NCamisola = Integer.parseInt(textFieldAlCamisa.getText());
                                j.Morada = textFieldAlMorada.getText();
                                j.Idade = Integer.parseInt(textFieldAlIdade.getText());

                            }

                        }
                    }
                     catch (NumberFormatException nfe)
                        {
                            JOptionPane.showMessageDialog(null, "Erro: " + nfe.getMessage());
                        }

                    JOptionPane.showMessageDialog(null, "Jogador " + jogador.getNome() +
                            " Alterado com sucesso!");

                }else
                {
                    JOptionPane.showMessageDialog(null, "Dados Incompletos! Por favor, complete os dados!");
                }
            }
        });
        procurarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldEliminar.getText();
                for(Jogadores j: jogadores)
                    if(j.Nome.equals(nome))
                    {
                        textAreaInfo.setText("");
                        textAreaInfo.setText(j.toString());
                    }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldEliminar.getText();
                for(Jogadores j: jogadores)
                    if(j.Nome.equals(nome))
                    {
                        textAreaInfo.setText("");
                        textAreaInfo.setText(j.toString());
                        jogador = j;

                        int res = JOptionPane.showConfirmDialog(null, "tem certeza que deseja eliminar o " +
                                j.getNome() + "?");
                        if(res == 0)
                        {
                            jogadores.remove(j);
                            JOptionPane.showMessageDialog(null, "Dados do jogador eliminados com sucesso!");
                        }

                    }
            }
        });
        novoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldNome.setText("");
                textFieldAltura.setText("");
                textFieldPeso.setText("");
                textFieldRenumera.setText("");
                textFieldPosição.setText("");
                textFieldCamisola.setText("");
                textFieldMorada.setText("");
                textFieldIdade.setText("");
                LabelIndiceCorpo.setText("");
            }
        });
    }


}


