package model;

public class Times {
    private String nome;

    public Times(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Times{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
