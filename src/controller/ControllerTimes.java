package controller;

import model.Times;

import java.util.List;

public interface ControllerTimes<T extends Times>{

    public T inserirTime(T times);
    public void verTime(T times);
    public void editarTime(T times);
    public boolean excluirTime(T times);

}
