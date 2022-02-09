package Aulas.Jogadores;

import Aulas.Alunos.Aluno;

import java.util.ArrayList;

public class Clubes {
    public String Designação;
    public ArrayList<Jogadores> ConjutJogadores;

    public Clubes(){}

    public Clubes(String designação, ArrayList<Jogadores> conjJogadores )
    {
        this.ConjutJogadores = (ArrayList<Jogadores>) conjJogadores.clone();
        this.Designação = designação;
    }

    public ArrayList<Jogadores> getConjutJogadores() {
        return ConjutJogadores;
    }

    public String getDesignação() {
        return Designação;
    }

    public void setConjutJogadores(ArrayList<Jogadores> conjutJogadores) {
        this.ConjutJogadores = conjutJogadores;
    }

    public void setDesignação(String designação) {
        this.Designação = designação;
    }

    @Override
    public String toString() {
        return "Jogadores: " + ConjutJogadores + ".";

    }
}
