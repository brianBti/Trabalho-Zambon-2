public class Atleta {
    private String nome;
    private char sexo;
    private double altura;
    private double peso;

    public Atleta(String nome, char sexo, double altura, double peso) {
        this.nome = nome;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }
}