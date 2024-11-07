import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtletasApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Atleta> atletas = new ArrayList<>();

        System.out.print("Qual a quantidade de atletas? ");
        int quantidadeAtletas = scanner.nextInt();
        scanner.nextLine();  

        for (int i = 1; i <= quantidadeAtletas; i++) {
            System.out.println("Digite os dados do atleta numero " + i + ":");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            char sexo;
            do {
                System.out.print("Sexo (M/F): ");
                sexo = scanner.next().charAt(0);
                if (sexo != 'M' && sexo != 'F') {
                    System.out.println("Valor invalido! Favor digitar F ou M.");
                }
            } while (sexo != 'M' && sexo != 'F');

            double altura;
            do {
                System.out.print("Altura: ");
                altura = scanner.nextDouble();
                if (altura <= 0) {
                    System.out.println("Valor invalido! Favor digitar um valor positivo.");
                }
            } while (altura <= 0);

            double peso;
            do {
                System.out.print("Peso: ");
                peso = scanner.nextDouble();
                if (peso <= 0) {
                    System.out.println("Valor invalido! Favor digitar um valor positivo.");
                }
            } while (peso <= 0);

            atletas.add(new Atleta(nome, sexo, altura, peso));
            scanner.nextLine();  
        }

        gerarRelatorio(atletas);
    }

    public static void gerarRelatorio(List<Atleta> atletas) {
        double pesoTotal = 0;
        int homens = 0;
        int mulheres = 0;
        double alturaTotalMulheres = 0;
        Atleta atletaMaisAlto = null;

        for (Atleta atleta : atletas) {
            pesoTotal += atleta.getPeso();

            if (atleta.getSexo() == 'M') {
                homens++;
            } else {
                mulheres++;
                alturaTotalMulheres += atleta.getAltura();
            }

            if (atletaMaisAlto == null || atleta.getAltura() > atletaMaisAlto.getAltura()) {
                atletaMaisAlto = atleta;
            }
        }

        double pesoMedio = pesoTotal / atletas.size();
        double porcentagemHomens = (homens * 100.0) / atletas.size();
        double alturaMediaMulheres = mulheres > 0 ? alturaTotalMulheres / mulheres : 0;

        System.out.println("\n### RELATÓRIO ###");
        System.out.printf("Peso médio dos atletas: %.2f%n", pesoMedio);
        System.out.println("Atleta mais alto: " + (atletaMaisAlto != null ? atletaMaisAlto.getNome() : "N/A"));
        System.out.printf("Porcentagem de homens: %.1f %% %n", porcentagemHomens);
        if (mulheres > 0) {
            System.out.printf("Altura média das mulheres: %.2f%n", alturaMediaMulheres);
        } else {
            System.out.println("Não há mulheres cadastradas");
        }
    }
}