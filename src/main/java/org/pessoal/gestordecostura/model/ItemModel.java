package org.pessoal.gestordecostura.model;

public class ItemModel {
    private String nome;
    private double valor;

    @Override
    public String toString() {
        return  "==" +"nome='" + nome + '\'' +
                ", valor=" + valor;
    }
}
