package Aulas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;



public class Lucky7 {
    private JLabel labelNum1;
    private JButton buttonLuckySeven;
    private JLabel Premio;
    private JLabel labelNum2;
    private JLabel labelNum3;
    private JPanel Lucky;


    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Lucky7");
        frame.setContentPane(new Lucky7().Lucky);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public Lucky7() {
        buttonLuckySeven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random  rnd = new Random();
                int num1 = rnd.nextInt(7)+1;
                int num2 = rnd.nextInt(7)+1;
                int num3 = rnd.nextInt(7)+1;

                labelNum1.setText(String.valueOf(num1));
                labelNum2.setText(String.valueOf(num2));
                labelNum3.setText(String.valueOf(num3));

                String premio = "";
                if(num1 == 7 && num2 == 7 && num3 == 7)
                {
                    premio ="Parabéns, Primeiro premio, Lucky Seven";
                }
                else if((num1 != 7 && num2 == 7 && num3 == 7) ||(num2 != 7 && num1 == 7 && num3 == 7) || (num3 != 7 && num1 == 7 && num2 == 7) )
                {
                    premio = "Parabéns, segundo premio!";
                }
                else if((num1 + num2 + num3) == 7) {
                    premio = "Parabéns, Terceiro premio!";

                }
                else
                {
                    premio = "Azar, sem premio!";
                }

                Premio.setText(premio);
            }



        });
    }
}
