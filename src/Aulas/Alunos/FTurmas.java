package Aulas.Alunos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FTurmas {
    private JPanel panelGTumas;
    private JTextArea textAreaDadosAlunos;
    private JButton atribuirAlunosButton;
    private JTextField textFieldDesignTurma;
    private JTextField textFieldNumeroDeAlunos;
    private JTextField textFieldMediaTurma;
    private JTextField textFieldNumeroNegas;
    private JTextField textFieldNotaAltaTurma;
    private JButton guardarTurmaButton;
    private JPanel panelGTurmas;

    public static void setVisible(boolean b)
    {
        JFrame frame = new JFrame("Gestão de Turmas");
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(new FTurmas().panelGTumas);
        frame.setVisible(true);
    }


    public FTurmas() {
        atribuirAlunosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Aluno a: FAlunos.turma)
                {
                    textAreaDadosAlunos.append(a.toString() + "\n");
                }
            }
        });

        guardarTurmaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(textAreaDadosAlunos.getText() !="" && textFieldDesignTurma.getText() != "" ){
                    Turma t=new Turma();
                    t.setDesignacao(textFieldDesignTurma.getText());
                    t.setAlunos(FAlunos.turma);

                    textFieldNumeroDeAlunos.setText(String.valueOf(t.Alunos.size()));
                    textFieldMediaTurma.setText(String.valueOf(t.MediaTurma()));
                    textFieldNumeroNegas.setText(String.valueOf(t.AlunosNegativas()));
                    textFieldNotaAltaTurma.setText(String.valueOf(t.MediaAlta()));
                    JOptionPane.showMessageDialog(null, "Turma " + t.getDesignacao() +
                            " guardada com sucesso!");
                }

            }
        });
    }
}
