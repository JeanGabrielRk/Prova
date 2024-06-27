package br.edu.up.controles;

import br.edu.up.modelos.Aluno;
import java.util.List;

public class ControleAluno {

    public void processarDados(List<Aluno> listaDeAlunos) {
        int quantidadeDeAlunos = listaDeAlunos.size();
        int aprovados = 0;
        int reprovados = 0;
        double menorNota = Double.MAX_VALUE;
        double maiorNota = Double.MIN_VALUE;
        double somaDasNotas = 0.0;

        for (Aluno aluno : listaDeAlunos) {
            double nota = aluno.getNota();
            if (nota >= 6.0) {
                aprovados++;
            } else {
                reprovados++;
            }
            if (nota < menorNota) {
                menorNota = nota;
            }
            if (nota > maiorNota) {
                maiorNota = nota;
            }
            somaDasNotas += nota;
        }

        double mediaGeral = somaDasNotas / quantidadeDeAlunos;

        System.out.println("Quantidade de alunos: " + quantidadeDeAlunos);
        System.out.println("Aprovados: " + aprovados);
        System.out.println("Reprovados: " + reprovados);
        System.out.println("Menor nota: " + menorNota);
        System.out.println("Maior nota: " + maiorNota);
        System.out.println("Média geral: " + mediaGeral);
    }
}
