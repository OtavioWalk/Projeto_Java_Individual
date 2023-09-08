package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AplicacaoAutenticacao {

    public static void main(String[] args) {
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("Otávio", "senha123"));
        listaUsuarios.add(new Usuario("João", "senha321"));

        Autenticacao autenticacao = new Autenticacao(listaUsuarios);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bem-vindo à aplicação de autenticação");
            System.out.print("Nome de usuário: ");
            String nomeUsuario = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            if (autenticacao.autenticarUsuario(nomeUsuario, senha)) {

                Biblioteca biblioteca = new Biblioteca();

                if (Objects.equals(nomeUsuario, "Otávio")) {

                    Jogo jogo1 = new Jogo("Call of Duty: Black Ops 2", "FPS", 2012, "Treyarch");
                    biblioteca.adicionarJogo(jogo1);

                    Jogo jogo2 = new Jogo("Grand Theft Auto V", "Ação/Aventura", 2013, "Rockstar Games");
                    biblioteca.adicionarJogo(jogo2);

                    Jogo jogo3 = new Jogo("Hades", "Roguelike/Ação", 2019, "Supergiant Games");
                    biblioteca.adicionarJogo(jogo3);

                }
                ;

                if (Objects.equals(nomeUsuario, "João")) {

                    Jogo jogo1 = new Jogo("Call of Duty Modern Warfare 2", "FPS", 2022, "Infinity Ward");
                    biblioteca.adicionarJogo(jogo1);

                    Jogo jogo2 = new Jogo("Outer Wilds", "Aventura/Exploração", 2019, "Mobius Digital");
                    biblioteca.adicionarJogo(jogo2);

                    Jogo jogo3 = new Jogo("Cyberpunk 2077", "RPG de Ação/Ficção Científica", 2020, "CD Projekt Red");
                    biblioteca.adicionarJogo(jogo3);

                }
                ;

                while (true) {

                    exibirMenu();

                    int escolha = scanner.nextInt();
                    scanner.nextLine(); // Limpar a quebra de linha


                    switch (escolha) {
                        case 1:
                            System.out.println("\nVocê escolheu a opção 1.\n");

                            Scanner scanner1 = new Scanner(System.in);

                            while (true) {
                                System.out.println("Biblioteca de Jogos - Menu:");
                                System.out.println("1. Adicionar Jogo");
                                System.out.println("2. Remover Jogo");
                                System.out.println("3. Listar Jogos Disponíveis");
                                System.out.println("4. Sair\n");
                                System.out.print("Escolha uma opção: ");

                                int opcao = scanner1.nextInt();
                                scanner1.nextLine(); // Consumir a quebra de linha

                                switch (opcao) {
                                    case 1:
                                        System.out.print("\nTítulo do Jogo: ");
                                        String titulo = scanner1.nextLine();
                                        System.out.print("Gênero: ");
                                        String genero = scanner1.nextLine();
                                        System.out.print("Ano de Lançamento: ");
                                        int ano = scanner1.nextInt();
                                        scanner1.nextLine(); // Consumir a quebra de linha
                                        System.out.print("Desenvolvedor: ");
                                        String desenvolvedor = scanner1.nextLine();

                                        Jogo jogo = new Jogo(titulo, genero, ano, desenvolvedor);
                                        biblioteca.adicionarJogo(jogo);
                                        System.out.println("\nJogo adicionado com sucesso!\n");
                                        break;

                                    case 2:

                                        System.out.print("\nTítulo do Jogo a ser removido: ");
                                        String tituloRemover = scanner1.nextLine();

                                        // Verificar se o jogo existe na biblioteca
                                        boolean jogoEncontrado = false;
                                        for (Jogo j : biblioteca.listarJogosDisponiveis()) {
                                            if (j.getTitulo().equalsIgnoreCase(tituloRemover)) {
                                                biblioteca.removerJogo(j);
                                                jogoEncontrado = true;
                                                System.out.println("Jogo removido com sucesso!\n");
                                                break;
                                            }
                                        }

                                        if (!jogoEncontrado) {
                                            System.out.println("Jogo não encontrado na biblioteca.\n");
                                        }
                                        break;

                                    case 3:
                                        List<Jogo> jogosDisponiveis = biblioteca.listarJogosDisponiveis();
                                        if (jogosDisponiveis.isEmpty()) {
                                            System.out.println("\nNão há jogos disponíveis.\n");
                                        } else {
                                            System.out.println("\nJogos Disponíveis:\n");
                                            for (Jogo j : jogosDisponiveis) {
                                                System.out.println(j);
                                            }
                                        }
                                        break;

                                    case 4:
                                        System.out.println("\nSaindo do programa. Obrigado!");
                                        scanner.close();
                                        System.exit(0);

                                    default:
                                        System.out.println("Opção inválida. Tente novamente.");
                                        break;
                                }
                            }

                        case 2:
                            System.out.println("Saindo da aplicação.");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("\nOpção inválida. Tente novamente.\n");
                            break;
                    }
                }
            } else {
                System.out.println("\nNome de usuário ou senha incorretos. Tente novamente.\n");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nMenu Principal");
        System.out.println("1. Entrar na biblioteca de jogos");
        System.out.println("2. Sair da aplicação\n");
        System.out.print("Escolha uma opção: ");
    }
}
