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
        IO.mostrar("1. Adicionar uma recomendação");
        IO.mostrar("2. Apagar uma recomendação");
        IO.mostrar("3. Criar um usuário");
        IO.mostrar("4. Deletar um usuário");
        IO.mostrar("5. Visualizar os usuários cadastrados");
        IO.mostrar("6. Adicionar aos seus favoritos");
        IO.mostrar("7. Remover favorito");
        IO.mostrar("8. Visualizar as recomendações cadastradas");
        IO.mostrar("9. Visualizar seus favoritos");
        IO.mostrar("10. Sair:");
        IO.mostrar("11. Descobrir filmes por gênero");

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
        IO.mostrar("Digite o título do filme");
        String titulo = IO.pegarLinha();
        IO.mostrar("Digite o gênero do filme");
        String genero = IO.pegarLinha();

        Filme filme = catalogo.adicionarFilme(titulo,genero,email);


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

    private static List<Filme> visualizarMinhasRecomendacoes() throws Exception {
        String email = perguntarEmail();
        List<Filme> lista = catalogo.minhasRecomendacoes(email);

        return lista;
    }

    private static void visualizarRecomendacoesPeloGenero() {
        IO.mostrar("Digite o gênero desejado");
        IO.mostrar("Os gêneros cadastrados em nosso sistema são: " + catalogo.pegarListaDeGeneros());
        String generoDesejado = IO.pegarLinha();
        List<String> lista = catalogo.pegarFilmesComOGenero(generoDesejado);
        IO.mostrar(lista.toString());
    }


    private static Filme adicionarAosSeusFavoritos() throws Exception {
        String email = perguntarEmail();
        Usuario usuario = listaDeUsuarios.pesquisarUsuarioPeloEmail(email);
        IO.mostrar("Digite o título do filme");
        String titulo = IO.pegarLinha();
        IO.mostrar("Digite o gênero do filme");
        String genero = IO.pegarLinha();

        Filme filme = usuario.getMeusFavoritos().adicionarFilme(titulo, genero, email);

        IO.mostrar("Filme adicionado na sua lista de favoritos.");

        return filme;

    }

    private static void removerFavorito() throws Exception {
        String email = perguntarEmail();

        IO.mostrar("Qual o título do filme?");
        String titulo = IO.pegarLinha();

        Usuario usuario = listaDeUsuarios.pesquisarUsuarioPeloEmail(email);
        usuario.getMeusFavoritos().removerFilme(titulo);

        IO.mostrar("Filme removido.");
    }

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
            adicionarRecomendacao();
        } else if (opcao == 2) {
            apagarRecomendacao();
        } else if (opcao == 3) {
            adicionarUsuario();
        } else if (opcao == 4) {
            deletarUsuario();
        } else if (opcao == 5) {
            visualizarUsuarios();
        } else if (opcao == 6) {
            adicionarAosSeusFavoritos();
        } else if (opcao == 7) {
            removerFavorito();
        } else if (opcao == 8) {
            visualizarRecomendacoes();
        } else if (opcao == 9) {
            visualizarFavoritos();
        } else if (opcao == 10) {
            continuaExecutando = false;
        } else if (opcao == 11){
            visualizarRecomendacoesPeloGenero();
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
