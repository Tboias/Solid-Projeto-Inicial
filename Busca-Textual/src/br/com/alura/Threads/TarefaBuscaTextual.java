package br.com.alura.Threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {

    private String nomeArquivo;
    private String nome;

    public TarefaBuscaTextual(String nomeArquivo, String nome) {
        this.nomeArquivo = nomeArquivo;
        this.nome = nome;
    }
    
    @Override
    public void run() {
        try {
            Scanner scanner = ImprimeArquivoLinhaNome();
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    private Scanner ImprimeArquivoLinhaNome() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(nomeArquivo));
        
        int numeroDaLinha = 1;
        // int totalNome = 1;
        
        while (scanner.hasNextLine()) {

            String linha = scanner.next();
            
            if (linha.toLowerCase().contains(nome.toLowerCase())) {
                
                System.out.println(nomeArquivo + " - " + numeroDaLinha + " - " + linha);
                // totalNome++;
                
            }
            numeroDaLinha++;
        }
        // System.out.println("A tantos " + totalNome + " " + nome + " no total");
        return scanner;
    }
    
}
