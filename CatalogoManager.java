import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogoManager {
    private List<Disco> discos = new ArrayList<>();
    private List<Artista> artistas = new ArrayList<>();
    private List<Genero> generos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public CatalogoManager() {
        // Inicializa alguns gêneros padrão
        Genero rap = new Genero("Rap");
        Genero hipHop = new Genero("Hip-Hop");
        generos.add(rap);
        generos.add(hipHop);

        // Inicializa alguns artistas padrão
        Artista mitovani = new Artista("Mitovani", rap);
        Artista barba = new Artista("Barba", hipHop);
        artistas.add(mitovani);
        artistas.add(barba);

        // Inicializa alguns discos padrão
        List<String> faixasLife4Real = new ArrayList<>();
        faixasLife4Real.add("Imagina");
        faixasLife4Real.add("Esculpido por facas");
        faixasLife4Real.add("3x1");
        faixasLife4Real.add("Vivencia do corre");
        faixasLife4Real.add("Novo pt2");
        Disco life4Real = new Disco("Life4Real", 2018, faixasLife4Real, mitovani);

        List<String> faixasWAR = new ArrayList<>();
        faixasWAR.add("Cara a Cara");
        faixasWAR.add("Bem vindo");
        faixasWAR.add("Minha vida");
        faixasWAR.add("Liberdade");
        Disco war = new Disco("WAR", 2020, faixasWAR, barba);

        discos.add(life4Real);
        discos.add(war);
    }

    public void listarDiscos() {
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
        } else {
            for (Disco disco : discos) {
                System.out.println(disco);
            }
        }
    }

    public void adicionarDisco() {
        System.out.println("Digite o título do disco: ");
        String titulo = scanner.nextLine();
        System.out.println("Digite o ano de lançamento: ");
        int ano = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite as faixas separadas por vírgula: ");
        String faixasInput = scanner.nextLine();
        
        // Usando ArrayList para faixas
        List<String> faixas = new ArrayList<>();
        String[] faixasArray = faixasInput.split(",");
        for (String faixa : faixasArray) {
            faixas.add(faixa.trim()); // Adiciona cada faixa ao ArrayList
        }

        // Mostrar lista de gêneros disponíveis
        System.out.println("Escolha o gênero do artista (digite o número):");
        for (int i = 0; i < generos.size(); i++) {
            System.out.println((i + 1) + ": " + generos.get(i).getNome());
        }
        int generoEscolhido = Integer.parseInt(scanner.nextLine()) - 1;

        // Escolher o gênero
        Genero genero = generos.get(generoEscolhido);

        // Escolher o artista relacionado ao gênero
        System.out.println("Escolha o artista (digite o número):");
        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).getGenero().equals(genero)) {
                System.out.println((i + 1) + ": " + artistas.get(i).getNome());
            }
        }
        int escolhaArtista = Integer.parseInt(scanner.nextLine()) - 1;
        Artista artista = artistas.get(escolhaArtista);

        // Criar e adicionar o disco
        Disco novoDisco = new Disco(titulo, ano, faixas, artista);
        discos.add(novoDisco);
        System.out.println("Disco adicionado com sucesso!");
    }

    public void adicionarGenero() {
        System.out.println("Digite o nome do novo gênero: ");
        String nomeGenero = scanner.nextLine();

        // Verificar se o gênero já existe
        for (Genero genero : generos) {
            if (genero.getNome().equalsIgnoreCase(nomeGenero)) {
                System.out.println("Esse gênero já existe!");
                return;
            }
        }

        // Se não existe, adicionar o novo gênero
        Genero novoGenero = new Genero(nomeGenero);
        generos.add(novoGenero);
        System.out.println("Gênero adicionado com sucesso!");
    }

    // Método para cadastrar gênero, com suporte ao que você mencionou
    public void cadastrarGenero(String generoNome) {
        // Verificar se o gênero já existe
        for (Genero genero : generos) {
            if (genero.getNome().equalsIgnoreCase(generoNome)) {
                throw new UnsupportedOperationException("Gênero já existe.");
            }
        }

        // Se não existe, cadastrar o novo gênero
        Genero novoGenero = new Genero(generoNome);
        generos.add(novoGenero);
        System.out.println("Gênero " + generoNome + " cadastrado com sucesso!");
    }

    // Método para cadastrar novo artista
    public void cadastrarArtista(String nomeArtista, String nomeGenero) {
        // Verificar se o gênero já existe
        Genero genero = null;
        for (Genero gen : generos) {
            if (gen.getNome().equalsIgnoreCase(nomeGenero)) {
                genero = gen;
                break;
            }
        }

        if (genero == null) {
            System.out.println("Gênero não encontrado.");
            return;
        }

        // Criar o novo artista e adicionar ao catálogo
        Artista novoArtista = new Artista(nomeArtista, genero);
        artistas.add(novoArtista);
        System.out.println("Artista " + nomeArtista + " cadastrado com sucesso!");
    }

    public void editarDisco() {
        System.out.println("Digite o título do disco a ser editado: ");
        String titulo = scanner.nextLine();
        Disco discoEncontrado = null;
        for (Disco disco : discos) {
            if (disco.getTitulo().equalsIgnoreCase(titulo)) {
                discoEncontrado = disco;
                break;
            }
        }

        if (discoEncontrado != null) {
            System.out.println("Novo título: ");
            discoEncontrado.setTitulo(scanner.nextLine());
            System.out.println("Novo ano de lançamento: ");
            discoEncontrado.setAno(Integer.parseInt(scanner.nextLine()));
            System.out.println("Novas faixas (separadas por vírgula): ");
            String faixasInput = scanner.nextLine();
            
            // Atualizando as faixas usando ArrayList
            List<String> faixas = new ArrayList<>();
            String[] faixasArray = faixasInput.split(",");
            for (String faixa : faixasArray) {
                faixas.add(faixa.trim()); // Adiciona cada faixa ao ArrayList
            }
            discoEncontrado.setFaixas(faixas);
            System.out.println("Disco editado com sucesso!");
        } else {
            System.out.println("Disco não encontrado!");
        }
    }

    public void removerDisco() {
        System.out.println("Digite o título do disco a ser removido: ");
        String titulo = scanner.nextLine();
        Disco discoRemovido = null;
        for (Disco disco : discos) {
            if (disco.getTitulo().equalsIgnoreCase(titulo)) {
                discoRemovido = disco;
                break;
            }
        }

        if (discoRemovido != null) {
            discos.remove(discoRemovido);
            System.out.println("Disco removido com sucesso!");
        } else {
            System.out.println("Erro! Disco não encontrado.");
        }
    }

    public void listarArtistasComGeneros() {
        if (artistas.isEmpty()) {
            System.out.println("Artista não esta cadastrado.");
        } else {
            for (Artista artista : artistas) {
                System.out.println(artista.getNome() + " - " + artista.getGenero().getNome());
            }
        }
    }
}
