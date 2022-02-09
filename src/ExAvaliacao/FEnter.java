package ExAvaliacao;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FEnter {
    private JPanel Panel1;
    private JButton entrarButton;
    private JTextField textFieldUtilizador;
    private JTextField textFieldPalavraPass;


    public FEnter() {
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user= textFieldUtilizador.getText();
                String pass = textFieldPalavraPass.getText();

                Connection conn = null;


                try {

                    conn = ConeF.createConnection();
                    PreparedStatement ps = conn.prepareStatement("SELECT Nome,NomeUsuario,PalavraPass FROM funcionarios");
                    ResultSet sr = ps.executeQuery();
                    boolean fg = false;

                    while (sr.next())
                    {

                        String nome = sr.getString(1);
                        String userc = sr.getString("NomeUsuario");
                        String passc = sr.getString("PalavraPass");
                        System.out.printf("%s - %s - %s", nome, userc, passc);
                        // nome - usename - password
                        //JOptionPane.showMessageDialog(null, nome + "-" + userc + "-" + passc);

                        if (user.equals(userc) && pass.equals(passc))
                        {
                            new FLojaPrincipal().setVisible(true);
                            fg = true;
                        }
                    }
                    if (!fg) {
                        JOptionPane.showMessageDialog(null, "Login errado! NomeUsuario/PalavraPass incorretos!");
                    }
                }catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame=new JFrame("Gestao da Loja");
        frame.setContentPane(new FEnter().Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



}

