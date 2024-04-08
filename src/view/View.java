package view;
import controller.IMPL.LocalIMPL;
import controller.IMPL.NumerosIMPL;
import controller.IMPL.TimesIMPL;
import model.Local;
import model.Numeros;
import model.Times;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class View<T> {

    private final LocalIMPL<Local> localController;
    private final NumerosIMPL<Numeros> numerosController;
    private final TimesIMPL<Times> timesController;

    private final ExecutorService executorService;

    public View(LocalIMPL<Local> localController, NumerosIMPL<Numeros> numerosController, TimesIMPL<Times> timesController) {
        this.localController = localController;
        this.numerosController = numerosController;
        this.timesController = timesController;
        this.executorService = Executors.newCachedThreadPool();
    }

    public void inserirLocal(T local) {
        executorService.submit(() -> {
            localController.inserirLocal((Local) local);
            escreverArquivo(local.toString(), "dados.txt");
        });
    }

    public void inserirNumeros(T numeros) {
        executorService.submit(() -> {
            numerosController.inserirNumeros((Numeros) numeros);
            escreverArquivo(numeros.toString(), "dados.txt");
        });
    }

    public void inserirTime(T time) {
        executorService.submit(() -> {
            timesController.inserirTime((Times) time);
            escreverArquivo(time.toString(), "dados.txt");
        });
    }

    public void excluirLocal(T local) {
        executorService.submit(() -> {
            localController.excluirLocal((Local) local);
            escreverArquivo(local.toString(), "dados.txt"); // Atualiza o arquivo após a exclusão
        });

    }

    public void excluirNumeros(T numeros) {
        executorService.submit(() -> {
            numerosController.excluirNumeros((Numeros) numeros);
            escreverArquivo(numeros.toString(), "dados.txt"); // Atualiza o arquivo após a exclusão
        });
    }

    public void excluirTime(T time) {
        executorService.submit(() -> {
            timesController.excluirTime((Times) time);
            escreverArquivo(time.toString(), "dados.txt"); // Atualiza o arquivo após a exclusão
        });
    }

    public void exibirLocais() {
        System.out.println("Locais:");
        localController.getTodosOsLocais().stream()
                .map(Local::toString)
                .forEach(System.out::println);
        shutdown();
    }

    public void exibirNumeros() {
        System.out.println("\nNúmeros:");
        numerosController.getTodosOsNumeros().stream()
                .map(Numeros::toString)
                .forEach(System.out::println);
        shutdown();
    }

    public void exibirTimes() {
        System.out.println("\nTimes:");
        timesController.getTodosOsTimes().stream()
                .map(Times::toString)
                .forEach(System.out::println);
        shutdown();
    }

    public void shutdown() {
        executorService.shutdown();
    }

    private void escreverArquivo(String linha, String arquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo, true))) {
            writer.println(linha);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

