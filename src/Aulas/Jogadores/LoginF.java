package Aulas.Jogadores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginF {
    private JButton entrarButton;
    private JPanel panel1;
    private JTextField textFieldPassWord;
    private JTextField textFieldUser;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new LoginF().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }





    public LoginF() {

        entrarButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                String txtUser = textFieldUser.getText();
                String txtPass = textFieldPassWord.getText();

                try {

                    Connection conn = Coneson.CriarConexao();
                    String sql = "SELECT NOME, cartaCidadao, USERNAME, PASSWRD FROM fucionario";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    boolean fg = false;


                    while (rs.next())
                    {
                        String nome = rs.getString(1);
                        String user = rs.getString("USERNAME");
                        String pass = rs.getString("PASSWRD");
                        int cc = Integer.valueOf(rs.getString("cartaCidadao"));
                        System.out.printf("|%s - %s - %s - %d |", nome, user, pass, cc);
                        //JOptionPane.showMessageDialog(null, "Nome: " + nome + ", Username: " + user + ", password: " + pass + ", cc: " + cc );

                        if(txtUser.equals(user) && txtPass.equals(pass))
                        {
                            GDJEC.setVisible(true);
                            fg = true;
                        }

                    }
                    if(!fg)
                    {
                        JOptionPane.showMessageDialog(null, "Dados Incorretos!");
                    }


                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }

            }
        });


    }
}
