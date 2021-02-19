package br.com.alura.Threads;

public class ImprimeIdThreads implements Runnable {

    @Override
    public void run() {
      for(int i = 0 ; i < 1000 ; i++){
        Thread threadAtual = Thread.currentThread();
        System.out.println(threadAtual.getId() + " - " + i);
      }
    }

}