package br.com.alura.Threads;

public class Principal {
    public static void main(String[] args) throws Exception {

        String nome = "a";

        Thread threadAssinaturas1 = new Thread(new TarefaBuscaTextual("assinaturas1.txt" , nome));
        Thread threadAssinaturas2 = new Thread(new TarefaBuscaTextual("assinaturas2.txt" , nome));
        Thread autores = new Thread(new TarefaBuscaTextual("autores.txt" , nome));
        
        threadAssinaturas1.start();
        threadAssinaturas2.start();
        autores.start();
        
        // new Thread(new ImprimeIdThreads()).start();
        // new Thread(new ImprimeIdThreads()).start();
    }
}
