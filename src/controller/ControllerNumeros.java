package controller;

import model.Numeros;

public interface ControllerNumeros<T extends Numeros> {

    public T inserirNumeros(T numeros);
    public void verNumeros(T numeros);
    public void editarNumeros(T numeros);
    public boolean excluirNumeros(T numeros);

}
