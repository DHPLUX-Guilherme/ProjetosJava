package Aulas.Entidades;

import java.util.Scanner;

public class Produto {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stock p1;
        p1 = new Stock();
        int esc = 1;
        int quant;
        do {
            System.out.println("1 - Mostar produto");
            System.out.println("2 - Tirar do stock");
            System.out.println("3 - Adicionar ao stock");
            System.out.println("0 - Sair");
            esc = sc.nextInt();
            if(esc == 1)
            {
                p1.Mostrar();
            }
            else if(esc == 2)
            {
                System.out.println("Quanto pretende tirar?");
                quant = sc.nextInt();
                p1.RetirarStock(quant);
                p1.Mostrar();
            }
            else if(esc == 3)
            {
                System.out.println("Quanto pretende adicionar?");
                quant = sc.nextInt();
                p1.AdicionarStock(quant);
                p1.Mostrar();
            }


        }while (esc != 0);

        System.exit(0);

    }
}
