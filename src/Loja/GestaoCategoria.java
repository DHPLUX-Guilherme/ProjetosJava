package Loja;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestaoCategoria {
    private JPanel PainelCategoria;
    private JTextField textFieldNCatg;
    private JTextField textFieldNomeCatg;
    private JButton procurarButton;
    private JButton criarButton;
    private JButton apagarButton;
    private JTextArea textArea1;
    private JButton actualizarButton;



    public GestaoCategoria() {

        criarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(textFieldNCatg.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "ANTES, PRECISA INTODUZIR UM ID");

                }
                else if(textFieldNomeCatg.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "ANTES, PRECISA INTODUZIR UM NOME PARA A CATEGORIA!");

                }
                else
                {
                    String nomeCatg = textFieldNomeCatg.getText();
                    int numeCatg = Integer.parseInt(textFieldNCatg.getText());

                    try{

                        Connection conn = Conetare.CriarConexao();
                        PreparedStatement pst = conn.prepareStatement("INSERT INTO categoria(ID, NomeCatego)values(?,?)");
                        pst.setInt(1, numeCatg);
                        pst.setString(2, nomeCatg);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Nova Categoria criada!");
                        textFieldNCatg.setText("");
                        textFieldNomeCatg.setText("");

                    } catch (
                            SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    }

                }
            }
        });

        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldNCatg.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "ANTES, PRECISA INTODUZIR UM ID");
                }else
                {

                    String bid;
                    bid = textFieldNCatg.getText();
                    try {
                        Connection con = Conetare.CriarConexao();
                        PreparedStatement pst = con.prepareStatement("DELETE FROM CATEGORIA WHERE ID = ?");
                        pst.setString(1, bid);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "CATEGORIA APAGADA!");
                        textFieldNomeCatg.setText("");
                        textFieldNCatg.setText("");

                    }
                    catch (SQLException e1)
                    {
                        e1.printStackTrace();
                    }

                }


            }
        });

        procurarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(textFieldNCatg.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "ANTES, PRECISA INTODUZIR UM ID");
                }
                else
                {
                    try {
                        Connection con = Conetare.CriarConexao();
                        String pid = textFieldNCatg.getText();
                        PreparedStatement pst = con.prepareStatement("SELECT ID, NomeCatego FROM categoria WHERE ID = ?");
                        pst.setString(1, pid);
                        ResultSet rs = pst.executeQuery();
                        if(rs.next()==true)
                        {
                            String id = rs.getString(1);
                            String nome = rs.getString(2);
                            textFieldNomeCatg.setText(id);
                            textFieldNomeCatg.setText(nome);

                        }
                        else
                        {
                            textFieldNomeCatg.setText("");
                            textFieldNomeCatg.setText("");
                            JOptionPane.showMessageDialog(null,"ID NÃO ENCONTRADA OU PODE TER SIDO ELIMINADA!");
                        }
                    }
                    catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }
                }

            }
        });


        textArea1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);

                textArea1.setText("");
                try {

                    Connection con = Conetare.CriarConexao();
                    String pCat = textFieldNomeCatg.getText();
                    PreparedStatement pst = con.prepareStatement("select produtos.NomeProd, produtos.PREÇO, produtos.QUANTIDADE, categoria.NomeCatego from categoria join produtos on produtos.categoria = categoria.id where NomeCatego = ?");
                    pst.setString(1, pCat);
                    ResultSet rs = pst.executeQuery();


                    while(rs.next()==true)
                    {
                        String nome = rs.getString(1);
                        double preco = Double.parseDouble(rs.getString(2));
                        double quant = Double.parseDouble(rs.getString(3));
                        textArea1.append("" + nome + " - " + preco + "€ - " + quant + " unidades; \n");

                    }


                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
                textArea1.append("\nClick aqui para actualizar!");
                if(textFieldNomeCatg.getText().equals(""))
                {
                    textArea1.append("\n(Tenha certeza que tem algo em 'Nome da categoria')");
                }
            }
        });


        actualizarButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {

                if(textFieldNCatg.getText() != "")
                {
                    String pid,name;
                    name = textFieldNomeCatg.getText();
                    pid = textFieldNCatg.getText();
                    try {
                        Connection con = Conetare.CriarConexao();
                        PreparedStatement pst = con.prepareStatement("UPDATE CATEGORIA SET NOMECATEGO = ? WHERE ID = ?");
                        pst.setString(1, name);
                        pst.setString(2, pid);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "DADOS ACTUALIZADOS!");
                        textFieldNomeCatg.setText("");
                        textFieldNCatg.setText("");
                    }
                    catch (SQLException e1)
                    {
                        e1.printStackTrace();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "ANTES, PRECISA INTODUZIR UM NOME PARA A CATEGORIA!");
                }
            }
        });

    }

    public static void setVisible(boolean b){

        JFrame frame = new JFrame("Gestão de Categoria");
        frame.setContentPane(new GestaoCategoria().PainelCategoria);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
