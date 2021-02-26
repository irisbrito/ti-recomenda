package com.br.zup;

import java.util.List;

/**
 * Classe que gerencia todas as partes do sistema
 */
public class Sistema {
    private static boolean continuaExecutando;
    private static Catalogo catalogo;
    private static ListaDeUsuarios listaDeUsuarios;


    /**
     * Imprime o menu de opções para o usuário
     */
    private static void imprimirMenu() {
        IO.mostrar("Escolha uma opção:");
        IO.mostrar("1. Descobrir filmes por gênero");
        IO.mostrar("2. Adicionar uma recomendação");
        IO.mostrar("3. Apagar uma recomendação");
        IO.mostrar("4. Criar um usuário");
        IO.mostrar("5. Deletar um usuário");
        IO.mostrar("6. Visualizar os usuários cadastrados");
        IO.mostrar("7. Adicionar aos seus favoritos");
        IO.mostrar("8. Remover favorito");
        IO.mostrar("9. Visualizar todos os filmes");
        IO.mostrar("10. Visualizar seus favoritos");
        IO.mostrar("11. Visualizar minhas recomendações");
        IO.mostrar("12. Sair");

    }

    /**
     * Pergunta o email para o usuário
     * @return uma string com o email
     * @throws Exception quando o email digitado pelo usuário não é válido
     */
    private static String perguntarEmail() throws Exception {
        IO.mostrar("Digite email");
        String email = IO.pegarLinha();
        listaDeUsuarios.isEmailvalido(email);
        return email;
    }

    /**
     * Pergunta para o usuário os dados e adiciona uma recomendação na lista de recomendações do sistema
     * @return um objeto filme adicionado no sistema
     * @throws Exception quando o email do usuário não é válido
     */
    public static Filme adicionarRecomendacao() throws Exception {
        String email = perguntarEmail();

        Usuario usuario = listaDeUsuarios.pesquisarUsuarioPeloEmail(email); // Bloqueia usuário não cadastrado poder adicionar filme

        IO.mostrar("Digite o título do filme");
        String titulo = IO.pegarLinha();
        IO.mostrar("Digite o gênero do filme");
        String genero = IO.pegarLinha();

        Filme filme;

        try {
            filme = catalogo.pesquisarFilme(titulo);
            IO.mostrar("Filme já existe!");
        } catch (Exception e) {
            filme = catalogo.adicionarFilme(titulo, genero, email);
        }

        return filme;
    }

    /**
     * Apaga uma recomendação do sistema
     * @throws Exception quando o email do usuário que quer apagar a recomendação não é válido
     */
    private static void apagarRecomendacao() throws Exception {
        String email = perguntarEmail();
        IO.mostrar("Digite o título do filme");
        String titulo = IO.pegarLinha();

        Filme filme = catalogo.removerFilme(titulo);

        IO.mostrar("Filme removido.");

    }

    /**
     * Adiciona um usuário no sistema
     * @throws Exception quando o email que o usuário quer adicionar no sistema não é válido
     */
    private static void adicionarUsuario() throws Exception {
        IO.mostrar("Digite seu nome: ");
        String nome = IO.pegarLinha();
        String email = perguntarEmail();
        listaDeUsuarios.verificarSeEmailEstaCadastrado(email);
        listaDeUsuarios.adicionarUsuario(nome, email);
        IO.mostrar("Parabéns, usuário cadastrado");
    }

    /**
     * Método para deletar um usuário a partir do e-mail caadastrado
     * @throws Exception Usuário não encontrado
     */
    private static void deletarUsuario() throws Exception {
        String email = perguntarEmail();

        listaDeUsuarios.removerUsuarioPeloEmail(email);

        System.out.println("Usuário removido.");
    }

    /**
     * Mostra a lista de usuários para o usuário
     *
     */
    private static  void visualizarUsuarios() {
        IO.mostrar(listaDeUsuarios.getUsuarios().toString());
    }

    /**
     * Mostra as recomendações cadastradas no sistema para o usuário
     */
    private static void visualizarRecomendacoes() {
        IO.mostrar(catalogo.getFilmes().toString());
    }

    /**
     * Método para visualizar a lista de recomendações do usuário
     * @throws Exception
     */
    private static void visualizarMinhasRecomendacoes() throws Exception {
        String email = perguntarEmail();
        List<Filme> lista = catalogo.minhasRecomendacoes(email);
        IO.mostrar(lista.toString());
    }

    /**
     * Método que retorna uma lista de recomendações ao usuário de acordo com o gênero desejado
     */
    private static void visualizarRecomendacoesPeloGenero() {
        IO.mostrar("Digite o gênero desejado");
        IO.mostrar("Os gêneros cadastrados em nosso sistema são: " + catalogo.pegarListaDeGeneros());
        String generoDesejado = IO.pegarLinha();
        List<String> lista = catalogo.pegarFilmesComOGenero(generoDesejado);
        IO.mostrar(lista.toString());
    }

    /**
     * Método para adicionar um filme à lista de favoritos do usuário
     * @return filme
     * @throws Exception
     */
    private static Filme adicionarAosSeusFavoritos() throws Exception {
        String email = perguntarEmail();
        Usuario usuario = listaDeUsuarios.pesquisarUsuarioPeloEmail(email);
        IO.mostrar("Digite o título do filme");
        String titulo = IO.pegarLinha();

        Filme filme = catalogo.pesquisarFilme(titulo); // Bloqueia filme que não está no catálogo ir para a lista de favoritos

        usuario.getMeusFavoritos().adicionarFilme(titulo, filme.getGenero(), email);

        IO.mostrar("Filme adicionado na sua lista de favoritos.");

        return filme;

    }

    /**
     * Método para remover um filme favorito da lista do usuário
     * @throws Exception
     */
    private static void removerFavorito() throws Exception {
        String email = perguntarEmail();

        IO.mostrar("Qual o título do filme?");
        String titulo = IO.pegarLinha();

        Usuario usuario = listaDeUsuarios.pesquisarUsuarioPeloEmail(email);
        usuario.getMeusFavoritos().removerFilme(titulo);

        IO.mostrar("Filme removido.");
    }

    /**
     * Método para visualizar os favoritos do usuário de acordo com o e-mail
     * @throws Exception
     */
    private static void visualizarFavoritos() throws Exception {
        String email = perguntarEmail();

        Usuario usuario = listaDeUsuarios.pesquisarUsuarioPeloEmail(email);
        IO.mostrar(usuario.getMeusFavoritos().getFilmes().toString());
    }

    /**
     * Permite ao usuário escolher qual opção ele quer realizar no sistema
     * @throws Exception quando alguma opção que o usuário tentou fazer dá um erro
     */
    private static void menu() throws Exception {
        imprimirMenu();

        int opcao = IO.pegarInt();

        if (opcao == 1) {
            visualizarRecomendacoesPeloGenero();
        } else if (opcao == 2) {
            adicionarRecomendacao();
        } else if (opcao == 3) {
            apagarRecomendacao();
        } else if (opcao == 4) {
            adicionarUsuario();
        } else if (opcao == 5) {
            deletarUsuario();
        } else if (opcao == 6) {
            visualizarUsuarios();
        } else if (opcao == 7) {
            adicionarAosSeusFavoritos();
        } else if (opcao == 8) {
            removerFavorito();
        } else if (opcao == 9) {
            visualizarRecomendacoes();
        } else if (opcao == 10) {
            visualizarFavoritos();
        } else if (opcao == 11) {
            visualizarMinhasRecomendacoes();
        } else if (opcao == 12){
            continuaExecutando = false;
        }
    }

    /**
     * Executa o sistema propriamente dito
     *
     */
    public static void executarSistema() {
        continuaExecutando = true;

        try {
            catalogo = BancoDeDados.lerCatalogoDoArquivo("filmes.txt");
            listaDeUsuarios = BancoDeDados.lerListaDeUsuarios("usuarios.txt");
        } catch (Exception e) {
            IO.mostrar("Erro " + e.getMessage()+ " ao ler os dados do arquivo. Criando uma lista vazia...");
            catalogo = new Catalogo();
            listaDeUsuarios = new ListaDeUsuarios();
        }

        while (continuaExecutando) {
            try {
                menu();
            } catch (Exception e) {
                IO.mostrar(e.getMessage());
            }
        }

        try {
            BancoDeDados.salvarCatalogoParaArquivo("filmes.txt", catalogo);
            BancoDeDados.salvarListaDeUsuariosParaArquivo("usuarios.txt", listaDeUsuarios);
        } catch (Exception e) {
            IO.mostrar("Erro ao salvar os dados para arquivo: " + e.getMessage());
        }
    }
}
