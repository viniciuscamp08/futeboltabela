package controller.IMPL;

import controller.ControllerLocais;
import model.Local;
import model.Numeros;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LocalIMPL<T extends Local> implements ControllerLocais<T> {

    public List<T> todosOsLocais;

    public LocalIMPL() {
        this.todosOsLocais = new ArrayList<>();
    }

    @Override
    public T inserirLocal(T locais) {
        if (!todosOsLocais.contains(locais)){
            todosOsLocais.add(locais);
        }
        return locais;
    }

    @Override
    public void verLocal(T locais) {
        System.out.println(locais.toString());
    }

    @Override
    public void editarLocal(T locais) {
        todosOsLocais = todosOsLocais.stream()
                .map(t -> t.equals(locais) ? locais : t)
                .collect(Collectors.toList());
    }

    @Override
    public boolean excluirLocal(T locais) {
        return todosOsLocais.removeIf(t -> t.equals(locais));
    }

    public List<T> getTodosOsLocais() {
        return todosOsLocais;
    }
}
