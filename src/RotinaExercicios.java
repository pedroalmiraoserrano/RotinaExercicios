import java.util.Scanner;

public class RotinaExercicios {
    private static int Id = 1;

    public static void adicionarExercicio(String[] exercicios, int[] ids, boolean[] concluidos, int tamanho) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome do exercício: ");
        String nomeExercicio = scanner.nextLine();

        System.out.println("Insira a carga do exercício em kg: ");
        String cargaExercicio = scanner.nextLine();

        System.out.println("Insira quantas repetições deverão ser feitas: ");
        String repeticaoExercicio = scanner.nextLine();

        System.out.println("Insira o número de séries: ");
        int seriesExercicio = scanner.nextInt();

        int id = Id;
        Id++;

        for (int i = 0; i < tamanho; i++) {
            if (exercicios[i] == null) {
                exercicios[i] = "ID: " + id + " | " + nomeExercicio + " | Carga: " + cargaExercicio + " kg | Repetições: " + repeticaoExercicio + "| Séries: " + seriesExercicio;
                ids[i] = id;
                concluidos[i] = false;
                System.out.println("Exercício adicionado.");
                return;
            }
        }

        System.out.println("Não foi possível adicionar o exercício. A lista está cheia.");
    }

    public static void mostrarExercicios(String[] exercicios, boolean[] concluidos) {
        System.out.println("Exercícios:");
        for (int i = 0; i < exercicios.length; i++) {
            if (exercicios[i] != null) {
                System.out.println(exercicios[i] + " | Concluído: " + (concluidos[i] ? "Sim" : "Não"));
            }
        }
    }

    public static void marcarConcluido(String[] exercicios, boolean[] concluidos, int tamanho) {
        System.out.println("Exercícios não concluídos:");
        boolean ExerciciosNaoConcluidos = false;
        for (int i = 0; i < tamanho; i++) {
            if (exercicios[i] != null && !concluidos[i]) {
                System.out.println(exercicios[i]);
                ExerciciosNaoConcluidos = true;
            }
        }

        if (!ExerciciosNaoConcluidos) {
            System.out.println("Não há exercícios não concluídos.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o ID do exercício a ser marcado como concluído: ");
        int idExercicio = scanner.nextInt();

        for (int i = 0; i < tamanho; i++) {
            if (exercicios[i] != null && exercicios[i].startsWith("ID: " + idExercicio)) {
                concluidos[i] = true;
                System.out.println("Exercício marcado como concluído.");
                return;
            }
        }

        System.out.println("Exercício não encontrado.");
    }

    public static void mostrarExerciciosConcluidos(String[] exercicios, boolean[] concluidos) {
        System.out.println("Exercícios concluídos:");
        boolean haExerciciosConcluidos = false;
        for (int i =0; i < exercicios.length; i++) {
            if (exercicios[i] != null && concluidos[i]) {
                System.out.println(exercicios[i]);
                haExerciciosConcluidos = true;
            }
        }

        if (!haExerciciosConcluidos) {
            System.out.println("Não há exercícios concluídos.");
        }
    }

    public static void main(String[] args) {
        int maxExercicios = 10;
        String[] listaExercicios = new String[maxExercicios];
        int[] listaIds = new int[maxExercicios];
        boolean[] listaConcluidos = new boolean[maxExercicios];
        int opcao;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nSelecione uma opção: ");
            System.out.println("1 - Adicionar exercícios");
            System.out.println("2 - Mostrar lista de exercícios");
            System.out.println("3 - Marcar exercício como concluído");
            System.out.println("4 - Mostrar exercícios concluídos");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Obrigado por usar esse programa!");
                    break;
                case 1:
                    adicionarExercicio(listaExercicios, listaIds, listaConcluidos, maxExercicios);
                    break;
                case 2:
                    mostrarExercicios(listaExercicios, listaConcluidos);
                    break;
                case 3:
                    marcarConcluido(listaExercicios, listaConcluidos, maxExercicios);
                    break;
                case 4:
                    mostrarExerciciosConcluidos(listaExercicios, listaConcluidos);
                    break;
                default:
                    System.out.println("Favor inserir opção válida.");
            }
        } while (opcao != 0);
    }
}
