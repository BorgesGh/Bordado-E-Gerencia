package org.pessoal.gestordecostura.exceptions;

public class MaiorDeIdadeException extends Exception{
    @Override
    public String getMessage() {
        return "Não é maior de Idade!";
    }
}
