package view;

import controller.ControllerLocais;
import controller.ControllerNumeros;
import controller.ControllerTimes;
import controller.IMPL.LocalIMPL;
import controller.IMPL.NumerosIMPL;
import controller.IMPL.TimesIMPL;
import model.Local;
import model.Numeros;
import model.Times;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Consumer;

public class View<T> {

    private final LocalIMPL<Local> localController;
    private final NumerosIMPL<Numeros> numerosController;
    private final TimesIMPL<Times> timesController;

    public View(LocalIMPL<Local> localController, NumerosIMPL<Numeros> numerosController, TimesIMPL<Times> timesController) {
        this.localController = localController;
        this.numerosController = numerosController;
        this.timesController = timesController;
    }

    public void inserirLocal(T local) {
        localController.inserirLocal((Local) local);
        escreverArquivo(local.toString(), "dados.txt");
    }

    public void inserirNumeros(T numeros) {
        numerosController.inserirNumeros((Numeros) numeros);
        escreverArquivo(numeros.toString(), "dados.txt");
    }

    public void inserirTime(T time) {
        timesController.inserirTime((Times) time);
        escreverArquivo(time.toString(), "dados.txt");
    }

    public void exibirLocais() {
        System.out.println("Locais:");
        localController.getTodosOsLocais().stream()
                .map(Local::toString)
                .forEach(System.out::println);
    }

    public void exibirNumeros() {
        System.out.println("\nNúmeros:");
        numerosController.getTodosOsNumeros().stream()
                .map(Numeros::toString)
                .forEach(System.out::println);
    }

    public void exibirTimes() {
        System.out.println("\nTimes:");
        timesController.getTodosOsTimes().stream()
                .map(Times::toString)
                .forEach(System.out::println);
    }

    private void escreverArquivo(String linha, String arquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo, true))) {
            writer.println(linha);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

