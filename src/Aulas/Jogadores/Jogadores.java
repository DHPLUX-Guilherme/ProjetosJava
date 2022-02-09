package Aulas.Jogadores;

public class Jogadores {
    public String Nome;
    public int Idade;
    public String Morada;
    public double Peso;
    public double Altura;
    public int NCamisola;
    public String PosNoCampo;
    public double Remunera;

    public Jogadores(){}
    public Jogadores(String nome, int idade, String morada, double peso, double altura, int nCamisola, String posNoCampo,
                     double remunera)
    {
        this.Nome = nome;
        this.Idade = idade;
        this.Morada = morada;
        this.Peso = peso;
        this.Altura = altura;
        this.NCamisola = nCamisola;
        this.PosNoCampo = posNoCampo;
        this.Remunera = remunera;

    }

    //set,s
    public void setNome(String nome) {
        this.Nome = nome;
    }

    public void setRemunera(double remunera) {
        this.Remunera = remunera;
    }

    public void setPosNoCampo(String posNoCampo) {
        this.PosNoCampo = posNoCampo;
    }

    public void setPeso(double peso) {
        this.Peso = peso;
    }

    public void setNCamisola(int NCamisola) {
        this.NCamisola = NCamisola;
    }

    public void setMorada(String morada) {
        this.Morada = morada;
    }

    public void setIdade(int idade) {
        this.Idade = idade;
    }

    public void setAltura(double altura) {
        this.Altura = altura;
    }

    //get,s
    public double getAltura() {
        return Altura;
    }

    public double getPeso() {
        return Peso;
    }

    public double getRemunera() {
        return Remunera;
    }

    public int getIdade() {
        return Idade;
    }

    public int getNCamisola() {
        return NCamisola;
    }

    public String getMorada() {
        return Morada;
    }

    public String getNome() {
        return Nome;
    }

    public String getPosNoCampo() {
        return PosNoCampo;
    }

    public double SalarioAnual()
    {
        return (Remunera * 14);
    }

    public double MassCorpo()
    {
        return Math.round(Peso / (Altura*Altura));
    }


    @Override
    public String toString() {
        return "Nome = " + Nome + ", Idade = " + Idade + " anos, Morada = " + Morada + ", Peso = " + Peso + "g, Altura = " +
                Altura + "m, Massa Corporal: " + MassCorpo() + ", NCamisola = " + NCamisola + ", PosNoCampo = " + PosNoCampo + ", Remuneração = " + Remunera + "€, e o salario anual: " + SalarioAnual() + "€";
    }
}
