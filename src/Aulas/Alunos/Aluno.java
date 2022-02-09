package Aulas.Alunos;

public class Aluno {
    public String Identificaçao;
    public int[] Nota;

    public Aluno(){}

    public Aluno(String identificaçao, int[] nota)
    {
        this.Identificaçao = identificaçao;
        this.Nota = nota;
    }

    public int[] getNota() {
        return Nota;
    }

    public String getIdentificaçao() {
        return Identificaçao;
    }

    public void setIdentificaçao(String identificaçao) {
        Identificaçao = identificaçao;
    }

    public void setNota(int[] nota) {
        this.Nota = nota;
    }


    public double Media()
    {
        double total = 0;

        for(int i = 0; i<Nota.length; i++)
        {
            total += Nota[i];
        }
        return (total/Nota.length);
    }

    public int nNegativas()
    {
        int neg = 0;
        for(int i = 0; i<Nota.length;i++)
        {
            if(Nota[i]<10)
                neg++;

        }
        return neg;
    }

    public String toString()
    {
        String s = this.getIdentificaçao() + ", Notas: ";
                for(int i= 0; i<Nota.length; i++)
                {
                    s += String.valueOf(Nota[i] + ", ");
                }
                s += "Média: " + this.Media();
                s += "N negativas: Média: " + this.nNegativas();
                return s;
    }

}
