package br.edu.utfpr.cp.java.helloworld.pais;

public class PaisJaExisteException extends Exception { 

    public PaisJaExisteException() {
        super("Já existe um país com esse nome!");
    }
}