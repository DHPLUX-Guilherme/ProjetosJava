package Loja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FConsulta {
    private JPanel panelConsulta;
    private JTextField textFieldId;
    private JTextField textFieldNome;
    private JTextField textFieldSalario;
    private JButton buttonUltimo;
    private JButton buttonProximo;
    private JButton buttonAnterior;
    private JButton buttonPrimeiro;
    private JLabel LabelImagem;
    private JTextField textFieldUser;
    private JTextField textFieldPalavra;
    private JTextField textFieldTele;
    private String path = null;
    private byte[] userImage;
    private ResultSet rs;
    private Statement ps;

    public void Connec() {
        try{
            Connection conn = Conetare.CriarConexao();
            ps = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery("Select id, Nome, Salario, telefona, NomeUtil, palavraPass, foto from login");
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }

    public FConsulta() {
        Connec();

        buttonPrimeiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    rs.first();

                    textFieldId.setText(rs.getString(1));
                    textFieldNome.setText(rs.getString(2));
                    textFieldSalario.setText(String.valueOf(rs.getDouble(3)));
                    textFieldTele.setText(rs.getString(4));
                    textFieldUser.setText(rs.getString(5));
                    textFieldPalavra.setText(rs.getString(6));
                    Blob blob = rs.getBlob(7);
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
                        textFieldSalario.setText(String.valueOf(rs.getDouble(3)));
                        textFieldTele.setText(rs.getString(4));
                        textFieldUser.setText(rs.getString(5));
                        textFieldPalavra.setText(rs.getString(6));
                        Blob blob = rs.getBlob(7);
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
                        textFieldSalario.setText(String.valueOf(rs.getDouble(3)));
                        textFieldTele.setText(rs.getString(4));
                        textFieldUser.setText(rs.getString(5));
                        textFieldPalavra.setText(rs.getString(6));
                        Blob blob = rs.getBlob(7);
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
                    textFieldSalario.setText(String.valueOf(rs.getDouble(3)));
                    textFieldTele.setText(rs.getString(4));
                    textFieldUser.setText(rs.getString(5));
                    textFieldPalavra.setText(rs.getString(6));
                    Blob blob = rs.getBlob(7);
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

        JFrame frame = new JFrame("Gestão de Clubes");
        frame.setContentPane(new FConsulta().panelConsulta);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(600, 750);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
