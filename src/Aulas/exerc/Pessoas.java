package Aulas.exerc;

import java.security.PublicKey;

public class Pessoas {
    public String Nome;
    public double Peso;
    public double Altura;


    public Pessoas(){

    }

    public Pessoas(String nome, double peso, double altura)
    {
        this.Nome = nome;
        this.Peso = peso;
        this.Altura = altura;
    }

    public  String getNome(){
        return this.Nome;
    }

    public double getPeso(){
        return this.Peso;
    }

    public double getAltura(){
        return this.Altura;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public void setPeso(double peso) {
        this.Peso = peso;
    }

    public void setAltura(double altura) {
        this.Altura = altura;
    }

}
