package Loja;



import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.bind.annotation.XmlType;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;

public class GestaoProdutos {

    private JPanel PainelProdutos;
    private JTextField textFieldIdPro;
    private JTextField textFieldNomePro;
    private JTextField textFieldPrecoPro;
    private JTextField textFieldQuantPro;
    private JTextField textFieldCatgPro;
    private JButton criarButton;
    private JButton procurarButton;
    private JButton apagarButton;
    private JButton actualizarButton;
    private JTextArea textAreaCategorias;
    private JLabel LabelImagem;
    private JButton buttonProImagem;
    private String path;
    private byte[] userImage;
/*
    public boolean isStringInt(String s) {
        try
        {
            Integer.parseInt(s);
            return false;
        } catch (NumberFormatException ex)
        {
            return true;
        }
    }

 */

    public String Conversão() {
    //Procura a categoria pelo nome e dá a id para ser adicionada em produtos

    String NomeCatg = textFieldCatgPro.getText();
    String idCateg = "";
    try {

        Connection con = Conetare.CriarConexao();
        PreparedStatement pst = con.prepareStatement("Select id, NomeCatego  From categoria where NomeCatego = ? ");
        pst.setString(1, NomeCatg);
        ResultSet rs = pst.executeQuery();

        if(rs.next()==true)
        {
            idCateg = rs.getString(1);

        }
        else
            JOptionPane.showMessageDialog(null, "Essa categoria não existe!");


    }catch (SQLException e1)
    {
        e1.printStackTrace();

    }

    return idCateg;
}


    public GestaoProdutos() {



        procurarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldIdPro.getText() != "")
                {
                    String id, nome, idCateg = "";
                    double preco, quantidade;
                    try {
                        Connection con = Conetare.CriarConexao();
                        String pid = textFieldIdPro.getText();
                        PreparedStatement pst = con.prepareStatement("SELECT ID, NomeProd, Preço, Quantidade, Categoria, foto FROM produtos WHERE ID = ?");
                        pst.setString(1, pid);
                        ResultSet rs = pst.executeQuery();
                        if(rs.next()==true)
                        {
                             id = rs.getString(1);
                             nome = rs.getString(2);
                             preco = Double.parseDouble(rs.getString(3));
                             quantidade = Double.parseDouble(rs.getString(4));
                             idCateg = rs.getString(5);
                            Blob blob = rs.getBlob("foto");

                            byte[] imageBytes = blob.getBytes(1, (int) blob.length());

                            ImageIcon imgIcon = new ImageIcon(new
                                    ImageIcon(imageBytes).getImage().getScaledInstance(250, 250,
                                    Image.SCALE_DEFAULT));

                            userImage = blob.getBytes(1, (int) blob.length());
                            LabelImagem.setIcon(imgIcon);
                            textFieldIdPro.setText(id);
                            textFieldNomePro.setText(nome);
                            textFieldPrecoPro.setText(String.valueOf(preco));
                            textFieldQuantPro.setText(String.valueOf(quantidade));
                        }
                        else
                        {
                            textFieldIdPro.setText("");
                            textFieldNomePro.setText("");
                            textFieldCatgPro.setText("");
                            textFieldPrecoPro.setText(String.valueOf(""));
                            textFieldQuantPro.setText(String.valueOf(""));
                            JOptionPane.showMessageDialog(null,"ID NÃO ENCONTRADA OU PODE TER SIDO ELIMINADA!");
                        }
                    }
                    catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }

                    //Muda de número para nome
                    String NomeCatg = "";
                    try {
                        Connection con = Conetare.CriarConexao();
                        PreparedStatement pst = con.prepareStatement("Select produtos.categoria, NomeCatego from categoria join produtos on produtos.categoria = categoria.id where " +
                                "produtos.categoria = ?");
                        pst.setString(1, idCateg);
                        ResultSet rs = pst.executeQuery();

                        if(rs.next()==true)
                        {
                            NomeCatg = rs.getString(2);
                            textFieldCatgPro.setText(NomeCatg);
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Essa categoria não existe!");


                    }catch (SQLException e1)
                    {
                        e1.printStackTrace();

                    }

                }else
                {
                    JOptionPane.showMessageDialog(null, "ANTES, PRECISA INTODUZIR UM ID");
                }

            }
        });

        criarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(textFieldNomePro.getText().equals(""))
                {
                    textFieldNomePro.setText("Nome?");
                    JOptionPane.showMessageDialog(null, "ANTES, PRECISA INTODUZIR UM NOME!");
                }
                else if(textFieldPrecoPro.getText().equals(""))
                {
                    textFieldPrecoPro.setText("0?");
                    JOptionPane.showMessageDialog(null, "ANTES, PRECISA INTODUZIR UM PREÇO!");
                }
                else if(textFieldQuantPro.getText().equals(""))
                {
                    textFieldQuantPro.setText("0?");
                    JOptionPane.showMessageDialog(null, "ANTES, PRECISA INTODUZIR UMA QUANTIDADE DE PRODUTOS EXISTENTES!");
                }
                else if(textFieldCatgPro.getText().equals(""))
                {
                    textFieldCatgPro.setText("Consegues ver as categorias existentes Abaixo, apenas com um click!");
                    JOptionPane.showMessageDialog(null, "ANTES, PRECISA INTODUZIR UMA CATEGORIA!");
                }
                else
                {
                        //Cria um novo produto
                        String pid, name, price, qty, idCateg = Conversão();


                        name = textFieldNomePro.getText();
                        price = textFieldPrecoPro.getText();
                        qty = textFieldQuantPro.getText();
                        pid = textFieldIdPro.getText();

                        try {

                            Connection con = Conetare.CriarConexao();
                            PreparedStatement pst = con.prepareStatement("INSERT INTO PRODUTOS(NOMEPROD,PREÇO,QUANTIDADE,CATEGORIA, foto)values(?,?,?,?,?)");
                            pst.setString(1, name);
                            pst.setString(2, price);
                            pst.setString(3, qty);
                            pst.setString(4, idCateg);
                            pst.setBytes(5,userImage);
                            pst.executeUpdate();

                            JOptionPane.showMessageDialog(null, "Produto Criado com sucesso!");

                            textFieldNomePro.setText("");
                            textFieldPrecoPro.setText("");
                            textFieldQuantPro.setText("");
                            textFieldIdPro.setText("");
                            textFieldCatgPro.setText("");
                            LabelImagem.setIcon(null);

                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }


                }

            }
        });

        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldIdPro.getText() != "")//Regra para caso tente apagar sem ter intoduzido um id
                {
                    String bid;
                    bid = textFieldIdPro.getText();

                    try {

                        Connection con = Conetare.CriarConexao();
                        PreparedStatement pst = con.prepareStatement("DELETE FROM PRODUTOS WHERE ID = ?");
                        pst.setString(1, bid);
                        pst.executeUpdate();
                        textFieldNomePro.setText("");
                        textFieldPrecoPro.setText("");
                        textFieldQuantPro.setText("");
                        textFieldIdPro.setText("");
                        textFieldCatgPro.setText("");
                        LabelImagem.setIcon(null);

                    }
                    catch (SQLException e1)
                    {
                        e1.printStackTrace();
                    }
                }else
                {
                    JOptionPane.showMessageDialog(null, "ANTES, PRECISA INTODUZIR UM ID");
                }
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldIdPro.getText().equals(""))//Sessão de regras para que nada fique vazio
                {
                    JOptionPane.showMessageDialog(null, "PRECISA INTODUZIR UM ID");
                }
                else if(textFieldNomePro.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "ANTES, PRECISA INTODUZIR UM NOME!");
                }
                else if(textFieldCatgPro.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "ANTES, PRECISA INTODUZIR UM PREÇO!");
                }
                else if(textFieldQuantPro.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "ANTES, PRECISA INTODUZIR UMA QUANTIDADE DE PRODUTOS EXISTENTES!");
                }
                else if(textFieldCatgPro.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "ANTES, PRECISA INTODUZIR UMA CATEGORIA!");

                }
                else
                {
                    String pid,name, idCateg = Conversão();
                    double price, qty;
                    name = textFieldNomePro.getText();
                    price = Double.parseDouble(textFieldPrecoPro.getText());
                    pid = textFieldIdPro.getText();
                    qty = Double.parseDouble(textFieldQuantPro.getText());


                    if(idCateg != "") {
                        try {
                            Connection con = Conetare.CriarConexao();
                            PreparedStatement pst = con.prepareStatement("UPDATE PRODUTOS SET NOMEPROD = ?, PREÇO = ?,QUANTIDADE = ?, CATEGORIA = ?, foto = ? WHERE ID = ?");

                            pst.setString(1, name);
                            pst.setDouble(2, price);
                            pst.setDouble(3, qty);
                            pst.setString(4, idCateg);
                            pst.setBytes(5,userImage);
                            pst.setString(6, pid);
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "DADOS ACTUALIZADOS!");
                            textFieldNomePro.setText("");
                            textFieldPrecoPro.setText("");
                            textFieldQuantPro.setText("");
                            textFieldIdPro.setText("");
                            textFieldCatgPro.setText("");
                            LabelImagem.setIcon(null);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }else
                        JOptionPane.showMessageDialog(null, "Lista das categorias abaixo!");


                }


            }
        });

        textAreaCategorias.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {

                super.focusGained(e);
                textAreaCategorias.setText("");
                try {

                    Connection con = Conetare.CriarConexao();
                    PreparedStatement pst = con.prepareStatement("Select NomeCatego From categoria");
                    ResultSet rs = pst.executeQuery();

                    while (rs.next()==true)
                    {
                        String nome = rs.getString(1);
                        textAreaCategorias.append("" + nome + "\n");
                    }

                }catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });


        buttonProImagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser imgChooser = new JFileChooser();
                imgChooser.showOpenDialog(null);
                File file = imgChooser.getSelectedFile();

                path =  file.getAbsolutePath();
                BufferedImage img;
                try{
                    img = ImageIO.read(imgChooser.getSelectedFile());
                    ImageIcon imageIcon = new ImageIcon( new ImageIcon(img).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
                    LabelImagem.setIcon(imageIcon);
                    //guardar imagem na variavel byte[] userImage para ser depois guardada na base de dados
                    File image = new File(path);
                    FileInputStream fs = new FileInputStream(image);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int nBytesRead = 0;
                    while ((nBytesRead = fs.read(buff)) != -1)
                    {
                        bos.write(buff, 0,nBytesRead);
                    }

                    userImage = bos.toByteArray();


                }catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    public static void setVisible(boolean b){

        JFrame frame = new JFrame("Gestão de Produtos");
        frame.setContentPane(new GestaoProdutos().PainelProdutos);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(700, 850);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
