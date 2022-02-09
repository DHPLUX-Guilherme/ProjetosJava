package Aulas.Alunos;

import sun.plugin2.message.Message;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Random;

public class FAlunos {
    private JPanel Principal;
    private JButton ºButton;
    private JButton button4;
    private JList list1;
    private JButton gestãoDeAlunosButton;
    private JTabbedPane tabbedPane1;
    private JTextField textFieldAreaNotas;
    private JTextField textFieldIdentAluno;
    private JTextField textFieldMedia;
    private JTextField textFieldNegativas;
    private JButton gerarDisciplinasButton;
    private JButton guardarButton;
    private JTextField textFieldNota;
    private JButton adicionarButton;
    private JPanel FAlunosp;
    private JTextArea textAreaNotas;
    private JButton novoAlunoButton;
    private JTextField textFieldPesquisar;
    private JButton pesquisarButton;
    private JTextField textFieldAlNomes;
    private JTextField textFieldAlMedia;
    private JTextField textFieldAlnegativas;
    private JTextArea textAreaPesNotas;
    private JButton alterarButton;
    private JTextArea textAreaConsulta;
    private JButton buttonGerar;
    private JButton encontrarAlunoButton;
    private JTextField textFieldNomeAlunoApagar;
    private JTextField textFieldNomeEncontrado;
    private JTextField textFieldMédiaEncontrada;
    private JTextField textFieldnNegativaEncontrada;
    private JButton button2;
    private JTextArea textAreaAposApagar;
    private JButton turmaAposApagarButton;
    private JTextPane textPaneAreaNotas;



    public static void setVisible(boolean b) {

        JFrame frame = new JFrame("Gestao de alunos");
        frame.setContentPane(new FAlunos().FAlunosp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);// centrar no ecrã
        frame.setVisible(true);
    }



    short nDiscp = 10;
    int[] nota = new int[nDiscp];
    public int[] notas = new int[nDiscp];
    short ap = 0;
    public static Aluno al, alu;
    public static ArrayList<Aluno> turma = new ArrayList<Aluno>();

    public FAlunos() {

        buttonGerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                int totall = 0;
                short nNeg = 0;

                textAreaNotas.setText("");

    for (int i = 0; i < nDiscp; i++)
    {
        notas[i] = rnd.nextInt(21);
        textAreaNotas.append(notas[i] + "\n");
    }
    double media = totall / nDiscp;
    textFieldMedia.setText(String.valueOf(media));
    textFieldNegativas.setText(String.valueOf(nNeg));

            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldIdentAluno.getText() != "" && textFieldMedia.getText() != "" && textAreaNotas.getText() != ""
                        && textFieldNegativas.getText() != "") {
                    alu = new Aluno();
                    alu.Identificaçao = textFieldAlNomes.getText();

                    alu.setIdentificaçao(textFieldIdentAluno.getText());
                    //aluno.setNota(notas);
                    alu.Nota = new int[notas.length];
                    System.arraycopy(notas, 0, alu.Nota, 0, notas.length);
                    turma.add(alu);

                    textFieldMedia.setText(String.valueOf(alu.Media()));
                    textFieldNegativas.setText(String.valueOf(alu.nNegativas()));

                    JOptionPane.showMessageDialog(null, "Aluno " + alu.getIdentificaçao() +
                            " guardado com sucesso!");

                } else
                    JOptionPane.showMessageDialog(null, "Dados Incompletos! Por favor, complete os dados!");
            }
        });
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldNota.getText() != "") {
                    textAreaNotas.append(textFieldNota.getText() + "\n");
                    notas[ap] = Integer.parseInt(textFieldNota.getText());
                    ap++;
                }
            }
        });


        novoAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldNota.setText("");
                textFieldNegativas.setText("");
                textFieldMedia.setText("");
                textFieldIdentAluno.setText("");
                textAreaNotas.setText("");
            }
        });


        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldPesquisar.getText();
                for(Aluno a: turma)
                if(a.Identificaçao.equals(nome))
                {
                    textFieldAlNomes.setText(a.getIdentificaçao());
                    for(int nota: a.getNota())
                        textAreaPesNotas.append(nota + "\n");

                    textFieldAlMedia.setText(String.valueOf(a.Media()));
                    textFieldAlnegativas.setText(String.valueOf(a.nNegativas()));
                    al = a;
                }

            }
        });
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    al.setIdentificaçao(textFieldAlNomes.getText());
                    String[] newStr = textAreaNotas.getText().split("\n");
                    int[] arNotas = new int[newStr.length];
                    for(int i =0; i<newStr.length;i++)
                    {
                        arNotas[i] = Integer.parseInt(newStr[i]);
                    }
                    al.Nota = arNotas.clone();
                    textFieldAlMedia.setText(String.valueOf(al.Media()));
                    textFieldNegativas.setText(String.valueOf(al.nNegativas()));
                    JOptionPane.showMessageDialog(null, "Dados guardados do aluno guardados com sucesso!");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }



            }
        });
        textAreaConsulta.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textFieldAlMedia.setText("");
                textFieldAlnegativas.setText("");
                textFieldAlNomes.setText("");
                textFieldIdentAluno.setText("");
                textAreaNotas.setText("");
                textFieldAlNomes.setText("");
                textFieldNota.setText("");
                textFieldNegativas.setText("");
                textFieldMedia.setText("");
                textFieldIdentAluno.setText("");
                textAreaNotas.setText("");
                textFieldPesquisar.setText("");
                textAreaPesNotas.setText("");
                for(Aluno a: turma)
                    textAreaConsulta.append(a.toString() + "\n");

            }
        });

        encontrarAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNomeAlunoApagar.getText();
                for(Aluno a: turma)
                {
                    if(a.getIdentificaçao().equals(nome));
                    {
                        textFieldNomeEncontrado.setText(a.getIdentificaçao());
                        textFieldMédiaEncontrada.setText(String.valueOf(a.Media()));
                        textFieldnNegativaEncontrada.setText(String.valueOf(a.nNegativas()));
                        int res = JOptionPane.showConfirmDialog(null, "tem certeza que deseja eliminar o " +
                                a.getIdentificaçao() + "?");
                        if(res == 0)
                        {
                            turma.remove(a);
                            JOptionPane.showMessageDialog(null, "Dados do Aluno eliminados com sucesso!");
                        }


                    }
                }

            }
        });
        turmaAposApagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Aluno a: turma)
                {
                    textAreaAposApagar.append(a.toString() + "\n");
                    textFieldNomeEncontrado.setText("");
                    textFieldnNegativaEncontrada.setText("");
                    textFieldMédiaEncontrada.setText("");
                    textFieldNomeAlunoApagar.setText("");
                }


            }
        });
    }

}
