import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
            System.out.print(letrasAdivinadas[i]);
        }

        System.out.println("");
        System.out.println(palabraSecreta);

        while (!palabraAdivinada && intentos < intentosMaximos) {
            System.out.println("Palabra a adivinar:" + String.valueOf(letrasAdivinadas) + " " + palabraSecreta.length()
                    + " letras");
            System.out.println("Introduce una letra, por favor:");

            char letra = scanner.next().charAt(0);
            letra = Character.toLowerCase(letra);

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("Letra incorrecta. Intentos restantes: " + (intentosMaximos - intentos));
            }
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("¡Felicidades! Has adivinado la palabra secreta: " + palabraSecreta);
            }
        }

        if (!palabraAdivinada) {
            System.out.println("¡Lo siento! Has agotado todos tus intentos. La palabra secreta era: " + palabraSecreta
                    + " GAME OVER");
        }
        scanner.close();
    }
}
