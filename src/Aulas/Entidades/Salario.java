package Aulas.Entidades;

import java.util.Scanner;

public class Salario {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nome;
        double salarioB;
        double salarioL = 0;
        double taxa;
        int persentagem;

        Empregado p1;
        p1 = new Empregado();


        System.out.println("Nome: ");
        nome = sc.next();
        System.out.println("Salario Bruto: ");
        salarioB = sc.nextDouble();
        System.out.println("Taxa: ");
        taxa = sc.nextDouble();


        salarioL = p1.NetSalary(taxa, salarioB);
        System.out.println("Empregado: " + nome + ", " + salarioL + "€");

        System.out.println("Quanto é o aumento do salario em persentagem?");
        persentagem = sc.nextInt();

        salarioL = p1.AumentoDoSalarioEmPersentagem(salarioB, persentagem, salarioL);

        System.out.println("Dados actualizados: " + nome + ", " + salarioL + "€");






    }
}
