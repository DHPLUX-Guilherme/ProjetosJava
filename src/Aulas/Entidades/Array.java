package Aulas.Entidades;

import java.security.PublicKey;
import java.util.ArrayList;

public class Array {

    public double Preco;
    public String Nome;

    public Array(){

    }

    public Array(String nome, double preco)
    {
        this.Nome = nome;
        this.Preco = preco;

    }

    public  String getNome(){
        return this.Nome;
    }

    public double getPreco(){
        return this.Preco;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public void setPreco(double preco) {
        this.Preco = preco;
    }
}
