package controller;

import model.Local;

public interface ControllerLocais<T extends Local> {

    public T inserirLocal(T locais);
    public void verLocal(T locais);
    public void editarLocal(T locais);
    public boolean excluirLocal(T locais);

}
