package Loja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;

public class ListaDeTudo {

    private JPanel PainelTudo;
    private JTextField textFieldId;
    private JTextField textFieldNome;
    private JTextField textFieldPreco;
    private JTextField textFieldQuant;
    private JTextField textFieldCatg;
    private JLabel LabelImagem;
    private JButton buttonPrimeiro;
    private JButton buttonAnterior;
    private JButton buttonProximo;
    private JButton buttonUltimo;
    private JTextArea textArea1;
    private JButton fecharButton;
    private String path = null;
    private byte[] userImage;
    private ResultSet rs;
    private Statement ps;

    public void Connec() {
        try{
            Connection conn = Conetare.CriarConexao();
            ps = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery("Select produtos.id, produtos.NomeProd, produtos.Preço, produtos.Quantidade, NomeCatego, produtos.foto from produtos join categoria on produtos.categoria = categoria.id order by produtos.id");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ListaDeTudo() {
        Connec();

        buttonPrimeiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    rs.first();

                    textFieldId.setText(rs.getString(1));
                    textFieldNome.setText(rs.getString(2));
                    textFieldPreco.setText(String.valueOf(rs.getDouble(3)));
                    textFieldQuant.setText(rs.getString(4));
                    textFieldCatg.setText(rs.getString(5));
                    Blob blob = rs.getBlob(6);
                    byte[] imageByte = blob.getBytes(1,(int)blob.length());
                    ImageIcon imgIcon = new ImageIcon(new
                            ImageIcon(imageByte).getImage().getScaledInstance(250, 250,
                            Image.SCALE_DEFAULT));
                    LabelImagem.setIcon(imgIcon);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        buttonAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!rs.isFirst()) {
                        rs.previous();

                        textFieldId.setText(rs.getString(1));
                        textFieldNome.setText(rs.getString(2));
                        textFieldPreco.setText(String.valueOf(rs.getDouble(3)));
                        textFieldQuant.setText(rs.getString(4));
                        textFieldCatg.setText(rs.getString(5));
                        Blob blob = rs.getBlob(6);
                        byte[] imageByte = blob.getBytes(1,(int)blob.length());
                        ImageIcon imgIcon = new ImageIcon(new
                                ImageIcon(imageByte).getImage().getScaledInstance(250, 250,
                                Image.SCALE_DEFAULT));
                        LabelImagem.setIcon(imgIcon);

                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        buttonProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!rs.isLast()) {
                        rs.next();

                        textFieldId.setText(rs.getString(1));
                        textFieldNome.setText(rs.getString(2));
                        textFieldPreco.setText(String.valueOf(rs.getDouble(3)));
                        textFieldQuant.setText(rs.getString(4));
                        textFieldCatg.setText(rs.getString(5));
                        Blob blob = rs.getBlob(6);
                        byte[] imageByte = blob.getBytes(1,(int)blob.length());
                        ImageIcon imgIcon = new ImageIcon(new
                                ImageIcon(imageByte).getImage().getScaledInstance(250, 250,
                                Image.SCALE_DEFAULT));
                        LabelImagem.setIcon(imgIcon);

                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        buttonUltimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    rs.last();

                    textFieldId.setText(rs.getString(1));
                    textFieldNome.setText(rs.getString(2));
                    textFieldPreco.setText(String.valueOf(rs.getDouble(3)));
                    textFieldQuant.setText(rs.getString(4));
                    textFieldCatg.setText(rs.getString(5));
                    Blob blob = rs.getBlob(6);
                    byte[] imageByte = blob.getBytes(1,(int)blob.length());
                    ImageIcon imgIcon = new ImageIcon(new
                            ImageIcon(imageByte).getImage().getScaledInstance(250, 250,
                            Image.SCALE_DEFAULT));
                    LabelImagem.setIcon(imgIcon);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void setVisible(boolean b){

        JFrame frame = new JFrame("Gestão de Produtos");
        frame.setContentPane(new ListaDeTudo().PainelTudo);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(600, 750);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
