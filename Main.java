import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CatalogoManager catalogoManager = new CatalogoManager();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Menu de Opções ---");
            System.out.println("1. Listar discos");
            System.out.println("2. Listar artistas");
            System.out.println("3. Adicionar gênero");
            System.out.println("4. Cadastrar novo(a) artista");
            System.out.println("5. Adicionar disco");
            System.out.println("6. Editar disco");
            System.out.println("7. Remover disco");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    catalogoManager.listarDiscos();
                    break;
                case 2:
                    catalogoManager.listarArtistasComGeneros();
                    break;
                case 3:
                    catalogoManager.adicionarGenero();
                    break;
                case 4:
                    System.out.print("Digite o nome do(a) artista: ");
                    String nomeArtista = scanner.nextLine();
                    System.out.print("Digite o nome do gênero: ");
                    String nomeGenero = scanner.nextLine();
                    catalogoManager.cadastrarArtista(nomeArtista, nomeGenero);
                    break;
                case 5:
                    catalogoManager.adicionarDisco();
                    break;
                case 6:
                    catalogoManager.editarDisco();
                    break;
                case 7:
                    catalogoManager.removerDisco();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Finalizando a Sessão.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        scanner.close();
    }
}
