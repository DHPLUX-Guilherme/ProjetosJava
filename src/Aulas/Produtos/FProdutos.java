package Aulas.Produtos;

import Aulas.Jogadores.Coneson;
import Aulas.Jogadores.GDJEC;
import Aulas.Jogadores.JogaComDores;
import Aulas.Jogadores.LoginF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FProdutos {

    private JButton procurarButton;
    private JPanel panelProdutos;
    private JTextField textFieldID;
    private JButton actualizarButton;
    private JTextField textFieldQuant;
    private JTextField textFieldPreco;
    private JTextField textFieldNdoProd;
    private JButton apagarButton;
    private JButton salvarButton;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login da Loja");
        frame.setContentPane(new FProdutos().panelProdutos);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


    public FProdutos() {
        procurarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    Connection con = Conexao.CriarConexao();
                    String pid = textFieldID.getText();
                    PreparedStatement pst = con.prepareStatement("SELECT NOME, PREÇO, QUANTIDADE FROM PRODUTOS WHERE ID = ?");
                    pst.setString(1, pid);
                    ResultSet rs = pst.executeQuery();

                    if(rs.next()==true)
                    {
                        String name = rs.getString(1);
                        String price = rs.getString(2);
                        String qty = rs.getString(3);
                        textFieldNdoProd.setText(name);
                        textFieldPreco.setText(price);
                        textFieldQuant.setText(qty);
                    }
                    else
                    {
                        textFieldNdoProd.setText("");
                        textFieldPreco.setText("");
                        textFieldQuant.setText("");
                        JOptionPane.showMessageDialog(null,"ID NÃO ENCONTRADA, PODE TER SIDO ELIMINADA!");
                    }
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        });


        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String pid,name,price,qty;


                name = textFieldNdoProd.getText();
                price = textFieldPreco.getText();
                qty = textFieldQuant.getText();
                pid = textFieldID.getText();

                try {

                    Connection con = Conexao.CriarConexao();
                    PreparedStatement pst = con.prepareStatement("UPDATE PRODUTOS SET NOME = ?, PREÇO = ?,QUANTIDADE = ? WHERE ID = ?");
                    pst.setString(1, name);
                    pst.setString(2, price);
                    pst.setString(3, qty);
                    pst.setString(4, pid);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "DADOS ACTUALIZADOS!");

                    textFieldNdoProd.setText("");
                    textFieldPreco.setText("");
                    textFieldQuant.setText("");
                    textFieldNdoProd.requestFocus();
                    textFieldID.setText("");
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }

            }
        });


        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bid;
                bid = textFieldID.getText();
                try {
                    Connection con = Conexao.CriarConexao();
                    PreparedStatement pst = con.prepareStatement("DELETE FROM PRODUTOS WHERE ID = ?");
                    pst.setString(1, bid);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "DADOS APAGADOS!");
                    textFieldNdoProd.setText("");
                    textFieldPreco.setText("");
                    textFieldQuant.setText("");
                    textFieldNdoProd.requestFocus();
                    textFieldID.setText("");
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }




            }
        });


        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name,price,qty;

                name = textFieldNdoProd.getText();
                price = textFieldPreco.getText();
                qty = textFieldQuant.getText();

                try {

                    Connection con = Conexao.CriarConexao();

                    PreparedStatement pst = con.prepareStatement("INSERT INTO PRODUTOS(NOME,PREÇO,QUANTIDADE)values(?,?,?)");
                    pst.setString(1, name);
                    pst.setString(2, price);
                    pst.setString(3, qty);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Produto Criado!");
                    textFieldNdoProd.setText("");
                    textFieldPreco.setText("");
                    textFieldQuant.setText("");
                    textFieldNdoProd.requestFocus();
                }catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
    }
}
