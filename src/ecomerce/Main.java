package ecomerce;

import auth.AuthService;
import model.*;

import telas.*;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        // Login do Usuario:

        Scanner input = new Scanner(System.in);

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Ryan Almeida", "ryanalds21@gmail.com", "poo123@"));


        System.out.println("Digite seu e-mail: ");
        String email = input.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = input.nextLine();

        Usuario logado = AuthService.autenticar(email, senha, usuarios);
        if (logado != null) {
            System.out.println("Login realizado com sucesso");
        } else {
            System.out.println("E-mail ou Senha invalidos");
            return;
        }

        // Opções do Menu:

        ProdutosEstoque estoque = new ProdutosEstoque(); // Criando lsta global, para armazenar os produtos
        estoque.carregarDeArquivo("produtos.txt"); // Carrega lista com produtos salvos no arquivo .txt

        // Loop para o codigo voltar ao menu a depender da escolha do usuario

        while (true) {
            System.out.println();
            System.out.println("=== MENU ===");
            System.out.println();
            System.out.println("1 --- Comprar");
            System.out.println("2 --- Vender");
            System.out.println("3 --- Sair");
            System.out.println();
            System.out.print("Bem vindo! Digite o número da opção que deseja: ");


            int escolha = input.nextInt();
            Tela telaAtual;

            if (escolha == 1) {
                telaAtual = new TelaCompras(estoque);

                telaAtual.mostrar();
                int opcao = input.nextInt();
                telaAtual.executarOpcao(opcao);

            } else if (escolha == 2) {
                telaAtual = new TelaVendas(estoque);
                telaAtual.mostrar();
                int opcao = input.nextInt();
                telaAtual.executarOpcao(opcao);

            } else if ( escolha == 3) {
                System.out.println("Obrigado e volte sempre!");
                break;

            } else {
                System.out.println("Oção invalida");
                continue;
            }
        }


    }
}