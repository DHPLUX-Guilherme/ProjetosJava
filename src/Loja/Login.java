package Loja;


import com.sun.java.accessibility.util.GUIInitializedListener;
import com.sun.java.accessibility.util.GUIInitializedMulticaster;
import javafx.application.Application;

import javax.management.JMException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    private JPanel panel1;
    private JTextField textFieldUser;
    private JTextField textFieldPass;
    private JButton loginButton;
    private JButton cancelButton;
    private JPasswordField passwordFieldPass;
    private JButton novoEmpregadoButton;

    public String txtUser;

    public Login() {

        passwordFieldPass.setEchoChar('*');

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtUser = textFieldUser.getText();
                char[] Pass = passwordFieldPass.getPassword();
                try {
                    Connection conn = Conetare.CriarConexao();
                    String sql = "SELECT NOME, TELEFONa, NOMEUTIL, PALAVRAPASS FROM login";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    boolean fg = false;
                    String txtPass = String.valueOf(Pass);
                    while (rs.next()) {
                        String nome = rs.getString(1);
                        String tele = rs.getString(2);
                        String user = rs.getString(3);
                        String pass = rs.getString(4);
                        System.out.printf("|%s - %s - %s | ", nome, user, pass);
                        if (txtUser.equals(user) && txtPass.equals(pass)) {
                            Loja.setVisible(true);
                            JOptionPane.showMessageDialog(null, "Bem vindo(a) " + nome);
                            fg = true;
                        }
                    }
                    if (!fg) {
                        JOptionPane.showMessageDialog(null, "Dados Incorretos!");
                    }
                } catch (
                        SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        novoEmpregadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NRG.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login da Loja");
        frame.setContentPane(new Login().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
