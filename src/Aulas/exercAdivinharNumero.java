package Aulas;


import javafx.application.Application;

import javax.swing.*;
import java.util.Random;

public class exercAdivinharNumero {

    public static void main(String[] args)
    {
        Random rnd = new Random();
        int input = 1;


        do{
            int tentativas1 = rnd.nextInt(7)+1;
            int tentativas2 = rnd.nextInt(7)+1;
            int tentativas3 = rnd.nextInt(7)+1;
            JOptionPane.showMessageDialog(null, "Numeros da sorte: " + tentativas1 + ", " + tentativas2 + ", " + tentativas3);

            if(tentativas1 == 7 && tentativas2 == 7 && tentativas3 == 7)
            {
                JOptionPane.showMessageDialog(null, "Parabéns, Primeiro premio, Lucky Seven");
            }
            else if((tentativas1 != 7 && tentativas2 == 7 && tentativas3 == 7) ||(tentativas2 != 7 && tentativas1 == 7 && tentativas3 == 7) || (tentativas3 != 7 && tentativas1 == 7 && tentativas2 == 7) )
            {
                JOptionPane.showMessageDialog(null, "Parabéns, segundo premio!");
            }
            else if((tentativas1 + tentativas2 + tentativas3) == 7) {
                JOptionPane.showMessageDialog(null, "Parabéns, Terceiro premio!");

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Azar, sem premio!");
            }

            input = JOptionPane.showConfirmDialog(null,
                    "Deseja Continuar", "Continuar",JOptionPane.YES_NO_CANCEL_OPTION);

            // 0=yes, 1=no, 2=cancel
            System.out.println(input);

        }while (input == 0);
        System.exit(0);





    }
}
