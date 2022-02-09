package Loja;



import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Loja {
    private JButton produtosButton;
    private JPanel panel1;
    private JButton categoriasButton;
    private JButton listarProdutosECategoriasButton;
    private JButton buttonMudar;
    public JLabel telemovelLabel;
    public JLabel nomeLabel;


    public static void setVisible(boolean b){

        JFrame frame = new JFrame("Loja Catita");
        frame.setContentPane(new Loja().panel1);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void NomeTele()    {
        try{
            Login login = new Login();
            String user = "não";
            user = login.txtUser;
            String nome, tele;
            System.out.printf(user);

            Connection conn = Conetare.CriarConexao();
            String sql = "Select Nome, telefona From Login where NomeUtil = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                nome = rs.getString(1);
                tele = rs.getString(2);
                nomeLabel.setText(nome);
                telemovelLabel.setText(tele);

            }


        } catch (
                SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public Loja() {
        produtosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            GestaoProdutos.setVisible(true);

            }
        });

        categoriasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestaoCategoria.setVisible(true);
            }
        });

        listarProdutosECategoriasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaDeTudo.setVisible(true);
            }
        });


        buttonMudar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FConsulta.setVisible(true);
            }
        });
    }
}
