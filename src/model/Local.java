package model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class Local {
    private String estadio;
    private DayOfWeek dia;
    private LocalDate data;
    private LocalTime hora;

    public Local(String estadio, DayOfWeek dia, LocalDate data, LocalTime hora) {
        this.estadio = estadio;
        this.dia = dia;
        this.data = data;
        this.hora = hora;
    }



    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Local{" +
                "estadio='" + estadio + '\'' +
                ", dia=" + dia +
                ", data=" + data +
                ", hora=" + hora +
                '}';
    }
}
