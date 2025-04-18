import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner teclado = new Scanner(System.in);
    private static List<Votos> lstCandidatos = new ArrayList<Votos>();

    public static void main(String[] args) throws InterruptedException{
        Votos candidato1 = new Votos("01", "Cristian Castillo", 20, 50, 30, 15, 65, 20);
        Votos candidato2 = new Votos("24", "Raul Vega", 20, 50, 30, 15, 65, 20);
        Votos candidato3 = new Votos("06", "Laura Castañeda", 20, 50, 30, 15, 65, 20);
        lstCandidatos.add(candidato1);
        lstCandidatos.add(candidato2);
        lstCandidatos.add(candidato3);
        mostrarMenu();
    }

    public static void mostrarMenu() throws InterruptedException{
        System.out.println("Votación representante de Premier" +
                "Desea realizar un voto o conocer las estadísticas de la votación?" +
                "\n1. Realizar un voto" +
                "\n2. Conocer estadísticas" +
                "\n3. Conocer precio de la campaña");
        int opc = teclado.nextInt();
        switch (opc) {
            case 1 -> realizarVotacion();
            case 2 -> verEstadisticas();
            case 3 -> verPrecio();
            default -> {
                System.out.println("Esa no es una opción");
                Thread.sleep(1000);
                mostrarMenu();
            }
        }
    }

    public static void realizarVotacion() throws InterruptedException {
        System.out.println("Por quien desea votar?");
        int i = 1, opc;
        for (Candidatos c : lstCandidatos) {
            System.out.println(i + ". " + c.getNombre() + "|| #" + c.getNumeral());
            i++;
        }
        opc = teclado.nextInt();
        switch (opc) {
            case 1 -> votacionEleccion(0);
            case 2 -> votacionEleccion(1);
            case 3 -> votacionEleccion(2);
        }

    }

    public static void votacionEleccion(int candidato) throws InterruptedException {
        Votos candidatoMod = lstCandidatos.get(candidato);
        System.out.println("En que urna se ubica?" +
                "\n1. Urna Norte" +
                "\n2. Urna Sur" +
                "\n3. Urna Occidente");
        int urna = teclado.nextInt();
        System.out.println("Por que medio conocio al candidato?" +
                "\n1. Internet" +
                "\n2. Radio" +
                "\n3. Television");
        int medio = teclado.nextInt();
        candidatoMod.aumentarVotos(urna, medio);
        System.out.println("Su voto se registro. Gracias.");
        mostrarMenu();
    }

    public static void verEstadisticas() throws InterruptedException {
        System.out.println("De quien desea ver las estadísticas?");
        int i = 1, opc;
        for (Candidatos c : lstCandidatos) {
            System.out.println(i + ". " + c.getNombre() + "|| #" + c.getNumeral());
            i++;
        }
        opc = teclado.nextInt();

        switch (opc) {
            case 1 -> {
                Candidatos c = lstCandidatos.getFirst();
                System.out.println(c.toString());
            }
            case 2 -> {
                Candidatos c = lstCandidatos.get(1);
                System.out.println(c.toString());
            }
            case 3 -> {
                Candidatos c = lstCandidatos.get(2);
                System.out.println(c.toString());
            }
        }
        mostrarMenu();
    }

    public static void verPrecio(){

    }
}