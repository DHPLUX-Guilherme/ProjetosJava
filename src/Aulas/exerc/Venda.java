package Aulas.exerc;

import java.util.Scanner;

public class Venda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos Carros? ");
        int N = sc.nextInt();
        System.out.println("Quantos Motas? ");
        int M = sc.nextInt();
        double combustivel = 1.10;
        double custoTotal = 0;
        double custoMenor = 99999;
        Veiculos[] motas = new Veiculos[N];
        Veiculos[] carros = new Veiculos[M];


                for (int g = 0; g < N; g++) {

                    System.out.println("Qual a marca do " + (g + 1) + " carro: ");
                    String marca = sc.next();


                    System.out.println("Qual a modelo do " + (g + 1) + " carro: ");
                    String modelo = sc.next();


                    System.out.println("Qual a custo do " + (g + 1) + " carro: ");
                    double custo = sc.nextDouble();
                    custo = custo * combustivel;
                    Veiculos carro = new Veiculos(marca, modelo, custo);
                    carros[g] = carro;

                    custoTotal = custoTotal + custo;
                    if (carros[g].Custo > custoMenor)
                        custoMenor = carros[g].Custo;

                }







            for (int j = 0; j < M; j++) {

                System.out.println("Qual a marca da " + (j + 1) + " Mota: ");
                String marca = sc.next();


                System.out.println("Qual a modelo da " + (j + 1) + " Mota: ");
                String modelo = sc.next();


                System.out.println("Qual a custo da " + (j + 1) + " Mota: ");
                double custo = sc.nextDouble();
                custo = custo * combustivel;

                Veiculos mota = new Veiculos(marca, modelo, custo);
                motas[j] = mota;

                custoTotal = custoTotal + custo;

                if (motas[j].Custo < custoMenor)
                    custoMenor = motas[j].Custo;


            }



        for(int c = 0; c<N; c++)
        {
            System.out.println("O " + (c + 1) + "º carro  da " + carros[c].Marca + ", o modelo " + carros[c].Modelo + ", e o custo total: " +  carros[c].Custo);
        }

        for(int m = 0; m<M; m++)
        {
            System.out.println("A " + (m + 1) + "ª mota da " + motas[m].Marca + ", o modelo " + motas[m].Modelo + ", e o custo total: " + motas[m].Custo);
        }

        System.out.println("Custo Total: " + ((N+M) * combustivel));
        System.out.println("O carro com menor custo é de: " + custoMenor);



    }
}
