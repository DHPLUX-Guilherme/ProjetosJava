package ExercicioProdutos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;
public class Produto {
    private JTextField textFieldQuantidade;
    private JTextField textFieldPreço;
    private JTextField textFieldNomeProduto;
    private JButton guardarButton;
    private JPanel PanelProduto;
    private JButton apagarButton;
    private JButton atualizarButton;
    private JButton procurarButton;
    private JTextField textFieldIDProduto;
    private JTabbedPane tabbedPane1;
    private JTextField textFieldCategoria;
    private JTextArea textAreaProdutos;
    private JTextArea textAreaCategorias;
    private JTextField textFieldIDCategoria;
    private JButton apagarCategoriaButton;
    private JButton inserirCategoriaButton;
    private JButton procurarCategoriaButton;
    private JTextField textFieldNomeCategoria;

    Connection con;
    PreparedStatement pst;
    public String name,price,qty,cat;

    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bdlojalucas", "root","1234");
            System.out.println("Success");
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    public static void setVisible(boolean b) {
        JFrame frame = new JFrame("Produto");
        frame.setContentPane(new Produto().PanelProduto);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public Produto() {
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = textFieldNomeProduto.getText();
                price = textFieldPreço.getText();
                qty = textFieldQuantidade.getText();
                cat = textFieldCategoria.getText();

                try {
                    con = Conexao.createConnection();

                    PreparedStatement pst = con.prepareStatement("insert into produtos(NOMEPROD,PREÇO,QUANTIDADE,CATEGORIA)values(?,?,?,?)");
                    pst.setString(1, name);
                    pst.setString(2, price);
                    pst.setString(3, qty);
                    pst.setString(4,cat);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Addedddddd!!!!");
                    textFieldNomeProduto.setText("");
                    textFieldPreço.setText("");
                    textFieldQuantidade.setText("");
                    textFieldCategoria.setText("");
                    textFieldNomeProduto.requestFocus();
                    textFieldCategoria.setText("");

                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        procurarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String pid = textFieldIDProduto.getText();
                    con = Conexao.createConnection();
                    PreparedStatement pst = con.prepareStatement("select NOMEPROD,PREÇO,QUANTIDADE,CATEGORIA from produtos where id = ?");
                    pst.setString(1, pid);
                    ResultSet rs = pst.executeQuery();
                    if(rs.next()==true)
                    {
                        String name = rs.getString(1);
                        String price = rs.getString(2);
                        String qty = rs.getString(3);
                        String cat = rs.getString(4);
                        textFieldNomeProduto.setText(name);
                        textFieldPreço.setText(price);
                        textFieldQuantidade.setText(qty);
                        textFieldCategoria.setText(cat);
                    }
                    else
                    {
                        textFieldNomeProduto.setText("");
                        textFieldPreço.setText("");
                        textFieldQuantidade.setText("");
                        JOptionPane.showMessageDialog(null,"Porduto sem ID");
                    }
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pid,name,price,qty,cat;

                name = textFieldNomeProduto.getText();
                price = textFieldPreço.getText();
                qty = textFieldQuantidade.getText();
                pid = textFieldIDProduto.getText();
                cat = textFieldCategoria.getText();
                try {
                    PreparedStatement pst = con.prepareStatement("update produtos set NOMEPROD = ?,PREÇO = ?,QUANTIDADE = ?, CATEGORIA = ? where ID = ?");
                    pst.setString(1, name);
                    pst.setString(2, price);
                    pst.setString(3, qty);
                    pst.setString(4, cat);
                    pst.setString(5, pid);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Produto atualizado!");
                    textFieldNomeProduto.setText("");
                    textFieldPreço.setText("");
                    textFieldQuantidade.setText("");
                    textFieldNomeProduto.requestFocus();
                    textFieldIDProduto.setText("");
                    textFieldCategoria.setText("");

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

                bid = textFieldIDProduto.getText();
                try {
                    PreparedStatement pst = con.prepareStatement("delete from produtos where ID = ?");
                    pst.setString(1, bid);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Produto apagado!");
                    textFieldNomeProduto.setText("");
                    textFieldPreço.setText("");
                    textFieldQuantidade.setText("");
                    textFieldNomeProduto.requestFocus();
                    textFieldIDProduto.setText("");
                    textFieldCategoria.setText("");
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }

            }
        });
        textAreaProdutos.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textAreaProdutos.setText("");
                try
                {
                    String pid = textFieldIDProduto.getText();
                    con = Conexao.createConnection();
                    PreparedStatement pst = con.prepareStatement("select NOMEPROD,PREÇO,QUANTIDADE,CATEGORIA from produtos ");
                    ResultSet rs = pst.executeQuery();
                        while (rs.next())
                        {
                            String name = rs.getString(1);
                            String price = rs.getString(2);
                            String qty = rs.getString(3);
                            String cat = rs.getString(4);

                            textAreaProdutos.append("\n Nome:  " + name + "\n Preço : " + price + "\n Quantidade: " +  qty + "\n Categoria: " + cat + "\n\n");

                        }



                }catch (SQLException e1)
                {
                    e1.printStackTrace();
                }

            }

        });

        textAreaCategorias.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textAreaCategorias.setText("");
                try
                {
                    String pid = textFieldIDCategoria.getText();
                    con = Conexao.createConnection();
                    PreparedStatement pst = con.prepareStatement("select NOMECAT from categorias ");
                    ResultSet rs = pst.executeQuery();
                    while (rs.next())
                    {
                        String cat = rs.getString(1);
                        textAreaCategorias.append("Categoria:  " + cat + "\n\n");
                    }



                }catch (SQLException e1)
                {
                    e1.printStackTrace();
                }

            }
        });

        procurarCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cid = textFieldIDCategoria.getText();
                    con = Conexao.createConnection();
                    PreparedStatement pst = con.prepareStatement("select ID, NOMECAT from categorias where id = ?");
                    pst.setString(1, cid);
                    ResultSet rs = pst.executeQuery();
                    if(rs.next()==true)
                    {
                         String nomeCat = rs.getString(2);
                        textFieldNomeCategoria.setText(nomeCat);
                    }
                    else
                    {
                        textFieldNomeCategoria.setText("");
                        JOptionPane.showMessageDialog(null,"Invalid Product ID");
                    }
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        apagarCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bid;

                bid = textFieldIDCategoria.getText();
                try {
                    PreparedStatement pst = con.prepareStatement("delete from categorias where ID = ?");
                    pst.setString(1, bid);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Deleteeeeee!!!!!");
                    textFieldNomeCategoria.setText("");

                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        inserirCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nca = textFieldNomeCategoria.getText();

                try {
                    con = Conexao.createConnection();

                    PreparedStatement pst = con.prepareStatement("insert into categorias(NOMECAT)values(?)");
                    pst.setString(1, nca);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Addedddddd!!!!");
                    textFieldIDCategoria.setText("");
                    textFieldNomeCategoria.setText("");

                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }

            }
        });
    }
}

