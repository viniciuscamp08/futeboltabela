import controller.IMPL.LocalIMPL;
import controller.IMPL.NumerosIMPL;
import controller.IMPL.TimesIMPL;
import model.Local;
import model.Numeros;
import model.Times;
import view.View;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        List<LocalIMPL> locais = new ArrayList<>();
//        List<NumerosIMPL> numeros = new ArrayList<>();
//        List<TimesIMPL> timeDaCasa = new ArrayList<>();
//        List<TimesIMPL> timeVisitante = new ArrayList<>();
//
//
//        View agenda = new View(locais, numeros, timeDaCasa, timeVisitante);
//        agenda.criarAgendaJogos();
//        agenda.salvarAgendaJogos("agenda_jogos.txt");

        LocalIMPL<Local> localController = new LocalIMPL<>();
        NumerosIMPL<Numeros> numerosController = new NumerosIMPL<>();
        TimesIMPL<Times> timesController = new TimesIMPL<>();


        View<Object> view = new View<>(localController, numerosController, timesController);


        view.inserirLocal(new Local("Santiago Bernabeu", LocalDate.of(2021, 11, 21), LocalDate.of(2018, 11, 10), LocalTime.of(15, 30)));
        view.inserirNumeros(new Numeros(1, 1, 2));
        view.inserirTime(new Times("Boca Juniors"));


        view.exibirLocais();
        view.exibirNumeros();
        view.exibirTimes();
    }
}