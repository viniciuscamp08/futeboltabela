package controller.IMPL;

import controller.ControllerNumeros;
import model.Numeros;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumerosIMPL<T extends Numeros> implements ControllerNumeros<T> {

    public List<T> todosOsNumeros;

    public NumerosIMPL() {
        this.todosOsNumeros = new ArrayList<>();
    }


    @Override
    public T inserirNumeros(T numeros) {
        if (!todosOsNumeros.contains(numeros)){
            todosOsNumeros.add(numeros);
        }

        return numeros;
    }

    @Override
    public void verNumeros(T numeros) {
        for (T t : todosOsNumeros){
            System.out.println(numeros.toString());
        }
    }

    @Override
    public void editarNumeros(T numeros) {
        todosOsNumeros = todosOsNumeros.stream()
                .map(t -> t.equals(numeros) ? numeros : t)
                .collect(Collectors.toList());

    }

    @Override
    public boolean excluirNumeros(T numeros) {
        return todosOsNumeros.removeIf(t -> t.equals(numeros));
    }

    @Override
    public String toString() {
        return "TimesIMPL{" +
                "todosOsTimes=" + todosOsNumeros +
                '}';
    }

    public List<T> getTodosOsNumeros() {
        return todosOsNumeros;
    }
}
