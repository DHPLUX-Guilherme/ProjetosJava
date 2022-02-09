package Loja;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

public class NRG {
    private JPanel panel1;
    private JTextField textFieldNome;
    private JTextField textFieldPass;
    private JButton novoRegistroButton;
    private JTextField textFieldUsername;
    private JTextField textFieldTelefone;
    private JButton buttonProcurar;
    private JLabel LabelImagem;
    private JTextField textFieldSalario;
    private String path = null;
    private byte[] userImage;

    public static void setVisible(boolean b){

        JFrame frame = new JFrame("Gestão de Produtos");
        frame.setContentPane(new NRG().panel1);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(600, 750);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public NRG() {

        novoRegistroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome, tele, nomeUtil, pass;
                double sala;
                Blob blob;

                try {
                    nome = textFieldNome.getText();
                    tele =  textFieldTelefone.getText();
                    nomeUtil = textFieldUsername.getText();
                    pass = textFieldPass.getText();
                    sala = Double.valueOf(textFieldSalario.getText());

                    Connection conn = Conetare.CriarConexao();
                    String sql = "insert into Login(Nome, Salario, telefona, NomeUtil, palavraPass, foto) values(?,?,?,?,?,?)";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, nome);
                    pst.setDouble(2, sala);
                    pst.setString(3, tele);
                    pst.setString(4, nomeUtil);
                    pst.setString(5, pass);
                    pst.setBytes(6, userImage);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Novo Empregado criado!");
                    textFieldNome.setText("");
                    textFieldTelefone.setText("");
                    textFieldUsername.setText("");
                    textFieldPass.setText("");
                    textFieldSalario.setText("");
                    LabelImagem.setIcon(null);


                } catch (
                        SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }

            }
        });

        buttonProcurar.addActionListener(new ActionListener() {
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
}
