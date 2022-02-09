package Aulas.Alunos;

import java.util.ArrayList;

public class Turma {

    public String Designacao;
    public ArrayList<Aluno> Alunos;

    public Turma(){}
    public Turma(String designa, ArrayList<Aluno> alunos)
    {
        this.Designacao = designa;
        this.Alunos =(ArrayList<Aluno>) alunos.clone();
    }

    public ArrayList<Aluno> getAlunos() {
        return Alunos;
    }

    public String getDesignacao() {
        return Designacao;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.Alunos = alunos;
    }

    public void setDesignacao(String designacao) {
        this.Designacao = designacao;
    }


    public double MediaTurma(){
        double media = 0;
        double total = 0;
        for(Aluno a: this.Alunos)
            total += a.Media();
        media = total/Alunos.size();
        return media;

    }

    public int AlunosNegativas(){
        int alunNega = 0;
        for(Aluno a: this.Alunos)
        {
            if(a.nNegativas() >= 3)
            alunNega++;
        }
        return alunNega;
    }

    public double MediaAlta(){
        double mediaAlta = 0;
        for(Aluno a: this.Alunos)
        {
            if(a.Media() > mediaAlta)
                mediaAlta = a.Media();
        }
        return mediaAlta;

    }








}
