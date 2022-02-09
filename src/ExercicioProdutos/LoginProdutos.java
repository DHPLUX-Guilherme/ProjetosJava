package ExercicioProdutos;

import ExercicioProdutos.Conexao;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginProdutos {
    private JTextField textFieldNomeUtilizador;
    private JTextField textFieldPalavraPasse;
    private JButton loginButton;
    private JPanel PanelProdutos;

    public static void main(String[] args) {
        JFrame frame= new JFrame("Login");
        frame.setContentPane(new LoginProdutos().PanelProdutos);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(600,500);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public LoginProdutos() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtUser=textFieldNomeUtilizador.getText();
                String txtPass=textFieldPalavraPasse.getText();


                try{

                    Connection conn= Conexao.createConnection();
                    String sql="SELECT  ID, NOME, TELEFONE, NOMEUTILIZADOR, PALAVRAPASSE FROM empregados";
                    PreparedStatement ps=conn.prepareStatement(sql);
                    ResultSet rs=ps.executeQuery();
                    boolean fg=false;

                    while(rs.next())
                    {
                            String nome=rs.getString(1);
                            String user=rs.getString("NOMEUTILIZADOR");
                            String pass=rs.getString("PALAVRAPASSE");
                        if(txtUser.equals(user) && txtPass.equals(pass)){
                            Produto.setVisible(true);
                            fg = true;
                        }
                    }
                    if(!fg)
                    {
                        JOptionPane.showMessageDialog(null,"Login errado! username/password errados");
                    }
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }
            }
        });
    }
}
