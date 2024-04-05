package controller.IMPL;

import controller.ControllerTimes;
import model.Times;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TimesIMPL<T extends Times> implements ControllerTimes<T> {

    public List<T> todosOsTimes;

    public TimesIMPL() {
        this.todosOsTimes = new ArrayList<>();
    }


    @Override
    public T inserirTime(T times) {
        if (!todosOsTimes.contains(times)){
            todosOsTimes.add(times);
        }

        return times;
    }

    @Override
    public void verTime(T times) {
        for (T t : todosOsTimes){
            System.out.println(times.toString());
        }
    }

    @Override
    public void editarTime(T times) {
        todosOsTimes = todosOsTimes.stream()
                .map(t -> t.equals(times) ? times : t)
                .collect(Collectors.toList());

    }

    @Override
    public boolean excluirTime(T times) {
        return todosOsTimes.removeIf(t -> t.equals(times));
    }


    @Override
    public String toString() {
        return "TimesIMPL{" +
                "todosOsTimes=" + todosOsTimes +
                '}';
    }

    public List<T> getTodosOsTimes() {
        return todosOsTimes;
    }
}
