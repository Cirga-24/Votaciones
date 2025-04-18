import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner teclado = new Scanner(System.in);
    private static List<Votos> lstCandidatos = new ArrayList<Votos>();

    public static void main(String[] args) throws InterruptedException{
        Votos candidato1 = new Votos("01", "Cristian Castillo", 60, 55, 40, 50, 65, 40);
        Votos candidato2 = new Votos("24", "Raul Vega", 70, 45, 50, 60, 40, 65);
        Votos candidato3 = new Votos("06", "Laura Castañeda", 80, 35, 45, 55, 55, 50);
        lstCandidatos.add(candidato1);
        lstCandidatos.add(candidato2);
        lstCandidatos.add(candidato3);
        mostrarMenu();
    }

    public static void mostrarMenu() throws InterruptedException{
        System.out.println("Votación representante de Premier" +
                "\nQue desea hacer?" +
                "\n1. Realizar un voto" +
                "\n2. Conocer estadísticas de un candidato" +
                "\n3. Vaciar Urnas de votacion");
        int opc = teclado.nextInt();
        switch (opc) {
            case 1 -> realizarVotacion();
            case 2 -> verEstadisticas();
            case 3 -> vaciarUrnas();
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
        candidatoMod.setTotalVotos();
        candidatoMod.setPrecioCampania();
        System.out.println("Su voto se registro. Gracias.\n");
        Thread.sleep(1000);
        mostrarMenu();
    }

    public static void verEstadisticas() throws InterruptedException {
        int votosCandidatos = calcularTotalCandidatos();
        System.out.println("De quien desea ver las estadísticas?");
        int i = 1, opc;
        for (Candidatos c : lstCandidatos) {
            System.out.println(i + ". " + c.getNombre() + "|| #" + c.getNumeral());
            i++;
        }
        opc = teclado.nextInt();
        switch (opc) {
            case 1 -> {
                lstCandidatos.getFirst().setPorcentaje(votosCandidatos);
                lstCandidatos.getFirst().setPrecioCampania();
                System.out.println("Precio Campania: " + lstCandidatos.getFirst().getPrecioCampania() +
                            "\nTotal Votos de todos los candidatos: " + votosCandidatos +
                            "\nTotal Votos de " + lstCandidatos.getFirst().getNombre() + ": " + lstCandidatos.getFirst().getTotalVotos() +
                            "\nPromedio de votos: " + lstCandidatos.getFirst().getPorcentaje() + "\n");
            }
            case 2 -> {
                lstCandidatos.get(1).setPorcentaje(votosCandidatos);
                lstCandidatos.get(1).setPrecioCampania();
                System.out.println("Precio Campania: " + lstCandidatos.get(1).getPrecioCampania() +
                        "\nTotal Votos de todos los candidatos: " + votosCandidatos +
                        "\nTotal Votos de " + lstCandidatos.get(1).getNombre() + ": " + lstCandidatos.get(1).getTotalVotos() +
                        "\nPromedio de votos: " + lstCandidatos.get(1).getPorcentaje() + "\n");
            }
            case 3 -> {
                lstCandidatos.getLast().setPorcentaje(votosCandidatos);
                lstCandidatos.getLast().setPrecioCampania();
                System.out.println("Precio Campania: " + lstCandidatos.getLast().getPrecioCampania() +
                        "\nTotal Votos de todos los candidatos: " + votosCandidatos +
                        "\nTotal Votos de " + lstCandidatos.getLast().getNombre() + ": " + lstCandidatos.getLast().getTotalVotos() +
                        "\nPromedio de votos: " + lstCandidatos.getLast().getPorcentaje() + "\n");
            }
        }
        Thread.sleep(3000);
        mostrarMenu();
    }

    public static int calcularTotalCandidatos() {
        int votosCandidatos = 0;
        for (int i = 0; i < 3; i++) {
            votosCandidatos += lstCandidatos.get(i).getTotalVotos();
        }
        return votosCandidatos;
    }

    public static void vaciarUrnas() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            lstCandidatos.get(i).vaciarUrnas();
            lstCandidatos.get(i).setTotalVotos();
            lstCandidatos.get(i).setPorcentaje(0);
        }
        System.out.println("Se han vaciado las Urnas de votacion\n");
        Thread.sleep(3000);
        mostrarMenu();
    }
}