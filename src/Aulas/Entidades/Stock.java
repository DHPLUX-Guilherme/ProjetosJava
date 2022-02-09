package Aulas.Entidades;


public class Stock {

    public String nome = "Televisão";
    public double price = 399.99;
    public int quantidade = 30;

    public double AdicionarStock(int i)
    {
        return quantidade = quantidade + i;
    }

    public double RetirarStock(int i)
    {
        return quantidade = quantidade - i;

    }

    public void Mostrar()
    {
        System.out.println("Produto: " + nome + ", preço: " + price + ", quantidade disponivel: " + quantidade);
    }


}
