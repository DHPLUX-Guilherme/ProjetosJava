package ExAvaliacao;




import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FLojaPrincipal {

    private JPanel PanelPrincipal;
    private JTextField textFieldNomeProduto;
    private JTextField textFieldPreco;
    private JTextField textFieldQuantidade;
    private JButton buttonSalvar;
    private JButton buttonApagar;
    private JButton buttonAtualizar;
    private JTextField textFieldIDProduto;
    private JButton pesquisarButton;




    public FLojaPrincipal() {

        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name,price,qty;


                try {

                    String id  = textFieldIDProduto.getText();
                    Connection conn = ConeF.createConnection();
                    PreparedStatement pst = conn.prepareStatement("select Nome, Preço, Quantidade from produto where ID = ?");
                    pst.setString(1, id);

                    ResultSet rs = pst.executeQuery();
                    JOptionPane.showMessageDialog(null,"conexao ok");

                    if(rs.next()==true)
                    {
                        name = rs.getString(1);
                        price = rs.getString(2);
                        qty = rs.getString(3);
                        textFieldNomeProduto.setText(name);
                        textFieldPreco.setText(price);
                        textFieldQuantidade.setText(qty);
                    }
                    else
                    {
                        textFieldNomeProduto.setText("");
                        textFieldPreco.setText("");
                        textFieldQuantidade.setText("");
                        JOptionPane.showMessageDialog(null,"Invalid produto ID");
                    }
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null,"Erro na conexaoo: " + ex.getMessage());
                    ex.printStackTrace();
                }

            }
        });
        buttonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name,price,qty;
                name = textFieldNomeProduto.getText();
                price = textFieldPreco.getText();
                qty = textFieldQuantidade.getText();
                try {
                    Connection conn = ConeF.createConnection();
                    PreparedStatement pst = conn.prepareStatement("insert into produto(Nome,Preço,Quantidade )values(?,?,?)");
                     pst.setString(1, name);
                     pst.setString(2, price);
                     pst.setString(3, qty);
                     pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Addedddddd!!!!");
                    textFieldNomeProduto.setText("");
                    textFieldPreco.setText("");
                    textFieldQuantidade.setText("");
                    textFieldNomeProduto.requestFocus();
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        buttonAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String pid,name,price,qty;
                name = textFieldNomeProduto.getText();
                price = textFieldPreco.getText();
                qty = textFieldQuantidade.getText();
                pid = textFieldIDProduto.getText();
                try {
                    Connection conn = ConeF.createConnection();
                    PreparedStatement pst = conn.prepareStatement("update produto set Nome = ?,Preço = ?,Quantidade = ? where ID = ?");
                    pst.setString(1, name);
                    pst.setString(2, price);
                    pst.setString(3, qty);
                    pst.setString(4, pid);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Updateee!!!!!");
                    textFieldNomeProduto.setText("");
                    textFieldPreco.setText("");
                    textFieldQuantidade.setText("");
                    textFieldNomeProduto.requestFocus();
                    textFieldIDProduto.setText("");
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        buttonApagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String bid;
                bid = textFieldIDProduto.getText();

                try {
                    Connection conn = ConeF.createConnection();
                    PreparedStatement pst = conn.prepareStatement("delete from produto where ID = ?");
                    pst.setString(1, bid);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Deleteeeeee!!!!!");
                    textFieldNomeProduto.setText("");
                    textFieldPreco.setText("");
                    textFieldQuantidade.setText("");
                    textFieldNomeProduto.requestFocus();
                    textFieldIDProduto.setText("");
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void setVisible(boolean b)
    {
        JFrame frame = new JFrame("");
        frame.setContentPane(new FLojaPrincipal().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 420);
        frame.setLocationRelativeTo(null);
        //frame.pack();
        frame.setVisible(true);
    }
}
