package model;

public class Numeros {
    Integer placar;
    Integer rodada;
    Integer jogo; //Número do jogo

    public Numeros(Integer placar, Integer rodada, Integer jogo) {
        this.placar = placar;
        this.rodada = rodada;
        this.jogo = jogo;
    }

    public Integer getPlacar() {
        return placar;
    }

    public void setPlacar(Integer placar) {
        this.placar = placar;
    }

    public Integer getRodada() {
        return rodada;
    }

    public void setRodada(Integer rodada) {
        this.rodada = rodada;
    }

    public Integer getJogo() {
        return jogo;
    }

    public void setJogo(Integer jogo) {
        this.jogo = jogo;
    }

    @Override
    public String toString() {
        return "Numeros{" +
                "placar=" + placar +
                ", rodada=" + rodada +
                ", jogo=" + jogo +
                '}';
    }
}
