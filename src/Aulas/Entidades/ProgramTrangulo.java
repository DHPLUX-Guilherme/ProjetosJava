package Aulas.Entidades;

import java.util.Scanner;

public class ProgramTrangulo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Triangulo t1, t2, t3;
        t1 = new Triangulo();
        t2 = new Triangulo();
        t3 = new Triangulo();
        System.out.println("Primeiro Triangulo: ");
        System.out.println("Lado A: ");
        t1.lA = sc.nextDouble();
        System.out.println("Lado B: ");
        t1.lB = sc.nextDouble();
        System.out.println("Lado C: ");
        t1.lC = sc.nextDouble();

        System.out.printf("Area do triangulo: %.2f%n", t1.Area());
        System.out.printf("Perimetro do triangulo: %.2f%n", t1.Perimetro());


        System.out.println("Segundo Triangulo: ");
        System.out.println("Lado A: ");
        t2.lA = sc.nextDouble();
        System.out.println("Lado B: ");
        t2.lB = sc.nextDouble();
        System.out.println("Lado C: ");
        t2.lC = sc.nextDouble();

        System.out.printf("Area do triangulo: %.2f%n", t2.Area());
        System.out.printf("Perimetro do triangulo: %.2f%n", t2.Perimetro());


        System.out.println("Terceiro Triangulo: ");
        System.out.println("Lado A: ");
        t3.lA = sc.nextDouble();
        System.out.println("Lado B: ");
        t3.lB = sc.nextDouble();
        System.out.println("Lado C: ");
        t3.lC = sc.nextDouble();

        System.out.printf("Area do triangulo: %.2f%n", t3.Area());
        System.out.printf("Perimetro do triangulo: %.2f%n", t3.Perimetro());


    }

}
