package Aulas.Entidades;

public class Triangulo {
    public double lA;
    public double lB;
    public double lC;

    public double Area()
    {
        double v = (lA + lB + lC)/2;
        double a = Math.sqrt(v*(v-lA)*(v-lB)*(v-lB));
        return a;
    }

    public double Perimetro()
    {
        return(lA+ lB+ lC);
    }
}
