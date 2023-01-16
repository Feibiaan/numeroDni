import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Ejercicio 9, Obtener la letra del DNI y mostrarlo tanto por pantalla como escribiendo un archivo TXT,
    // todo esto utilizando InputStream, Scanner, ArrayList, una pequeña operación matemática y PrintStream.

    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<String>();
        String letra = null;
        Integer resto = null;

        try {

            // Introducimos los números a comparar
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce tu DNI sin la letra: ");
            int numerosDni = scanner.nextInt();

            // Leemos un fichero con las letras para comparar con el resto
            InputStream letraDni = new FileInputStream("letrasDni.txt");
            Scanner b = new Scanner(letraDni);
            b.useDelimiter(";");
            while (b.hasNext()){
                lista.add(b.next());
            }

            // La operación matemática
            resto = numerosDni % 23;


            // Y una comprobación antes de realizar el resto del código
            if(numerosDni < 0 || numerosDni > 99999999) {
                System.out.println("El número indicado no es válido");
            } else {
                for (int i = 0; i < lista.size(); i++) {
                    letra = lista.get(resto);
                }
                PrintStream fileOut = new PrintStream("dniCompleto.txt");
                fileOut.println(numerosDni + letra);
                System.out.println("La letra de tu DNI("+ numerosDni +")" + " es: " + letra);


            }

            letraDni.close();

        } catch (Exception e) {
            System.out.println("Incorrecto: " + e.getMessage());
        }
    }
}