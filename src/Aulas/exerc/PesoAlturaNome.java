package Aulas.exerc;

import java.util.Scanner;

public class PesoAlturaNome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantas pessoas? ");
        int j = sc.nextInt();
        sc.nextLine();

        Pessoas[] pessoas = new Pessoas[j];

        for(int i = 0; i<j; i++)
        {
            System.out.println("Qual o nome da "+ (i+1) + "º pessoa?");
            String nome = sc.next();
            sc.nextLine();
            System.out.println("Qual o peso da "+ (i+1) + "º pessoa?");
            double peso = sc.nextDouble();
            sc.nextLine();
            System.out.println("Qual a altura da "+ (i+1) + "º pessoa?");
            double altura = sc.nextDouble();
            sc.nextLine();

            Pessoas pessoa = new Pessoas(nome, peso, altura);
            pessoas[i] = pessoa;

        }

        double maxP = 0;
        double minP = 99999;
        double maxA = 0;
        double minA = 99999;
        double mediaP = 0;
        double mediaA = 0;
        double p1 = 0;
        double a1 = 0;

        for(int i = 0; i<j; i++)
        {
            System.out.println("Dados da " + (i+1) + "º pessoa: (" + pessoas[i].Nome + ", " + pessoas[i].Peso + "kg, " + pessoas[i].Altura + " metros!");

            if(pessoas[i].Peso > maxP)
            {
                maxP = pessoas[i].Peso;
            }
            else if(pessoas[i].Peso < minP)
            {
                minP = pessoas[i].Peso;
            }

            if(pessoas[i].Altura > maxA){
                maxA = pessoas[i].Altura;
            }
            else if(pessoas[i].Altura < minA)
            {
                minA = pessoas[i].Altura;
            }

            p1 = p1 + pessoas[i].Peso;
            a1 = a1 + pessoas[i].Altura;

            mediaP = p1 / j;
            mediaA = a1 /j;

        }
        System.out.println("Os maiores valores de altura e peso registrados: " + maxA + " metros e " + maxP + "Kg");
        System.out.println("Os menores de altura e peso registrados: " + minA + " metros e " + minP + "Kg");
        System.out.println("As medias de altura e peso registrados: " + mediaA + " metros e " + mediaP + "Kg");


    }
}
