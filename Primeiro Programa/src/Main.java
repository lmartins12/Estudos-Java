import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        int y = 32;
        double x = 12.5756798;

        System.out.println("Olá, Mundo!");
        System.out.println(y);
        System.out.println(x);
        System.out.printf("%.2f%n", x); // printf formata e %.xf%n abrevia casa decimal o formato , ou . é determinado pela configuração do meu computador


        System.out.println("Novos exemplos:");
        Locale.setDefault(Locale.US); // muda a formatação para o modelo estadunidense
        System.out.printf("Aqui um exemplo de 2 casas decimais %.2f%n", x); // aqui o formato vai estar com "." ao invés de ","
        System.out.printf("Aqui um exemplo de 4 casas decimais %.4f%n", x);

        System.out.println("Aqui um exemplo mais prático");

        String nome = "Lucas";
        int idade = 21;
        double renda = 56500.57;

        // %f = decimal | %d = inteiro | %s = texto | %n = quebra de linha
        System.out.printf("Olá, meu nome é %s, tenho %d anos e uma renda de %.2f reais%n", nome, idade, renda);
    }
}