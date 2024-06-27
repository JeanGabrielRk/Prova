package br.edu.up.daos;

import br.edu.up.modelos.Aluno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeArquivos {

    public List<Aluno> lerArquivoDeAlunos(String caminhoDoArquivo) {
        List<Aluno> listaDeAlunos = new ArrayList<>();
    
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String linha;
            boolean primeiraLinha = true; 
            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue; 
                }
                if (linha.trim().isEmpty()) continue; 
                String[] dados = linha.split(";");
                if (dados.length < 3) continue; 
                int matricula = Integer.parseInt(dados[0].trim());
                String nome = dados[1].trim();
                double nota = Double.parseDouble(dados[2].replace(",", ".").trim()); 
    
                Aluno aluno = new Aluno(matricula, nome, nota);
                listaDeAlunos.add(aluno);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    
        return listaDeAlunos;
    }
    

    public void gravarResumo(String caminhoDoArquivo, int quantidadeDeAlunos, int aprovados, int reprovados, double menorNota, double maiorNota, double mediaGeral) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(caminhoDoArquivo))) {
            pw.println("Quantidade de alunos, Aprovados, Reprovados, Menor nota, Maior nota, Média geral");
            pw.printf("%d, %d, %d, %.2f, %.2f, %.2f%n", quantidadeDeAlunos, aprovados, reprovados, menorNota, maiorNota, mediaGeral);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
