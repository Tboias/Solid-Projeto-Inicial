package br.com.alura.bytebank;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteBlibioteca {
    public static void main(String[] args) {
        Conta c = new ContaCorrente(123, 321);
        c.depositar(100);
        
        try {
        	c.sacar(101);
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
        }
        
    }
}

