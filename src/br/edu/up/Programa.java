package br.edu.up;

import br.edu.up.modelos.Aluno;
import br.edu.up.daos.GerenciadorDeArquivos;
import br.edu.up.controles.ControleAluno;
import br.edu.up.telas.Tela;

import java.util.List;

public class Programa {
    public static void main(String[] args) {
        String caminhoDoArquivoAlunos = "alunos.csv";
        String caminhoDoArquivoResumo = "src/br/edu/up/resumo.csv";

        GerenciadorDeArquivos gerenciador = new GerenciadorDeArquivos();
        List<Aluno> listaDeAlunos = gerenciador.lerArquivoDeAlunos(caminhoDoArquivoAlunos);

        if (listaDeAlunos.isEmpty()) {
            System.out.println("Não foram encontrados alunos no arquivo.");
            return;
        }

        ControleAluno controle = new ControleAluno();
        controle.processarDados(listaDeAlunos);

        int quantidadeDeAlunos = listaDeAlunos.size();
        int aprovados = (int) listaDeAlunos.stream().filter(aluno -> aluno.getNota() >= 6.0).count();
        int reprovados = quantidadeDeAlunos - aprovados;
        double menorNota = listaDeAlunos.stream().mapToDouble(Aluno::getNota).min().orElse(Double.NaN);
        double maiorNota = listaDeAlunos.stream().mapToDouble(Aluno::getNota).max().orElse(Double.NaN);
        double mediaGeral = listaDeAlunos.stream().mapToDouble(Aluno::getNota).average().orElse(Double.NaN);

        gerenciador.gravarResumo(caminhoDoArquivoResumo, quantidadeDeAlunos, aprovados, reprovados, menorNota, maiorNota, mediaGeral);

        Tela tela = new Tela();
        tela.exibirResumo(quantidadeDeAlunos, aprovados, reprovados, menorNota, maiorNota, mediaGeral);
    }
}
