package br.edu.utfpr.cp.java.helloworld.excecao;

public class PaisJaExisteException extends Exception { 

    public PaisJaExisteException() {
        super("Já existe um país com esse nome!");
    }
}