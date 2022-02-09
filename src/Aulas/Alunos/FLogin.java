package Aulas.Alunos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FLogin {
    private JPanel panelLogin;
    private JTextField textFieldUser;
    private JButton button;
    private JButton cancelButton;
    private JTextField TextFieldPassWord;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setContentPane(new FLogin().panelLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public FLogin() {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtUser = textFieldUser.getText();
                String txtPass = TextFieldPassWord.getText();



                    /*Connection conn = Conexao.CriarConexao();
                    String sql = "SELECT NOME, USERNAME, PASSWRD FROM USER";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    boolean fg = false;

                    while (rs.next())
                    {
                        String nome = rs.getString(1);
                        String user = rs.getString("USERNAME");
                        String pass = rs.getString("PASSWRD");
                        System.out.printf("%s - %s - %s", nome, user, pass);

                        if(txtUser.equals(user) && txtPass.equals(pass))
                        {
                            FMenu.setVisible(true);
                            fg = true;
                        }
                    }
                    if(!fg)
                    {
                        JOptionPane.showMessageDialog(null, "Dados Incorretos!");
                    }

*/




            }
        });
    }
}
