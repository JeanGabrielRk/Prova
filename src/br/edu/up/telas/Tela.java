package br.edu.up.telas;

public class Tela {

    private boolean resumoJaExibido = false;

    public void exibirResumo(int quantidadeDeAlunos, int aprovados, int reprovados, double menorNota, double maiorNota, double mediaGeral) {
        if (!resumoJaExibido) {
            System.out.println("Quantidade de alunos: " + quantidadeDeAlunos);
            System.out.println("Aprovados: " + aprovados);
            System.out.println("Reprovados: " + reprovados);
            System.out.println("Menor nota: " + menorNota);
            System.out.println("Maior nota: " + maiorNota);
            System.out.println("Média geral: " + mediaGeral);
            
            System.out.println("Resumo da Turma:");
            System.out.println("Quantidade de alunos: " + quantidadeDeAlunos);
            System.out.println("Aprovados: " + aprovados);
            System.out.println("Reprovados: " + reprovados);
            System.out.println("Menor nota: " + menorNota);
            System.out.println("Maior nota: " + maiorNota);
            System.out.println("Média geral: " + mediaGeral);

            resumoJaExibido = true;
        }
    }
}
