package Aulas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelcusForFar {
    private JFormattedTextField celsiusFormattedTextField;
    private JButton converterButton;
    private JTextField fahrenheitTextField;
    private JPanel CelForFah;
    private JLabel dCtext;
    private JButton Fha;
    private JButton Limpar;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("CelcusForFah");
        frame.setContentPane(new CelcusForFar().CelForFah);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public CelcusForFar() {
        converterButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String Celcius = celsiusFormattedTextField.getText();
                String Fahrenheit = fahrenheitTextField.getText();
                double Cel;
                double Fah;

                if(Celcius != "C")
                {
                    fahrenheitTextField.setText("");
                    Cel = Integer.parseInt(Celcius);
                    Fah = ((Cel * 1.8) + 32) ;
                    Fahrenheit = String.valueOf(Fah);
                    fahrenheitTextField.setText(Fahrenheit);
                    if(Celcius != "C" && Fahrenheit != "C")
                    {

                    }

                }


            }
        });

        Fha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Celcius = celsiusFormattedTextField.getText();
                String Fahrenheit = fahrenheitTextField.getText();
                double Cel;
                double Fah;

                if(Fahrenheit != "F")
                {
                    celsiusFormattedTextField.setText("");
                    Fah = Integer.parseInt(Fahrenheit);
                    Cel = ((Fah - 32) * 0.6);
                    Celcius = String.valueOf(Cel);
                    celsiusFormattedTextField.setText(Celcius);


                }

            }
        });
        Limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fahrenheitTextField.setText("");
                celsiusFormattedTextField.setText("");
            }
        });
    }
}
