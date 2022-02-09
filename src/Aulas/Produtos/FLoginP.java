package Aulas.Produtos;

import Aulas.Jogadores.Coneson;
import Aulas.Jogadores.GDJEC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FLoginP {
    private JButton logarButton;
    private JPanel panel1;
    private JButton cancelarButton;
    private JTextField textFieldPass;
    public JTextField textFieldUser;

    public String txtPass;
    public String txtUser;



    public FLoginP() {
        logarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtUser = textFieldUser.getText();
                txtPass = textFieldPass.getText();

                try {

                    Connection conn = Conexao.CriarConexao();
                    String sql = "SELECT NOME, USERNAME, PASSWRD FROM clientes";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    boolean fg = false;


                    while (rs.next())
                    {
                        String nome = rs.getString(1);
                        String user = rs.getString("USERNAME");
                        String pass = rs.getString("PASSWRD");
                        System.out.printf("|%s - %s - %s | ", nome, user, pass);
                        //JOptionPane.showMessageDialog(null, "Nome: " + nome + ", Username: " + user + ", password: " + pass + ", cc: " + cc );
                        if(txtUser.equals(user) && txtPass.equals(pass))
                        {
                            FVitrine.setVisible(true);
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
