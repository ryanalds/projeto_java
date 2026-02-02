package ecomerce;

import auth.AuthService;
import java.io.IOException;
import java.util.*;
import model.*;
import telas.*;


public class Main {

    public static void main(String[] args) throws IOException {


        // Login do Usuario:

        Scanner input = new Scanner(System.in);

        BancoUsuarios banco = new BancoUsuarios();  // banco de usuarios instanciado.
        banco.carregarDeArquivo("Usuarios.txt");  // Carrega os usuários salvos no arquivo .txt

        Cadastro sistemaCadastro = new Cadastro(banco); // banco de usuários compartilhado com o sistema de cadastro

        // Opções do Menu:

        ProdutosEstoque estoque = new ProdutosEstoque(); // Criando lsta global, para armazenar os produtos
        estoque.carregarDeArquivo("produtos.txt"); // Carrega lista com produtos salvos no arquivo .txt

        while(true) {
            System.out.println("Bem vindo ao E-commerce!");
            System.out.println("1 --- Fazer Login");
            System.out.println("2 --- Criar nova conta");
            System.out.println("3 --- Sair");
            System.out.println("Escolha uma opção: ");

            if (!input.hasNextInt()){ // verifica se a entrada é um numero inteiro
                input.nextLine();
                continue;
            }

            int opcaoInicial = input.nextInt();
            input.nextLine(); // limpar buffer

            if (opcaoInicial == 1) {  // Login:
           
                System.out.print("E-mail: ");
                String email = input.nextLine();
                System.out.print("Senha: ");
                String senha = input.nextLine();

                // Verifica na lista do banco
                Usuario logado = AuthService.autenticar(email, senha, banco.getListaUsuarios());

                if (logado != null) {
                    System.out.println("Login com sucesso! Olá, " + logado.getNome());
                    break; // vai para o loop da loja
                    
                }
                else {
                    System.out.println("Email ou senha incorretos.");
                }

            }

            else if (opcaoInicial == 2) {  // Cadastro:

                System.out.print("Nome: ");
                String nome = input.nextLine();
                System.out.print("E-mail: ");
                String email = input.nextLine();
                System.out.print("Senha: ");
                String senha = input.nextLine();

                sistemaCadastro.cadastrarUsuario(nome, email, senha);
                banco.salvarEmArquivo("Usuarios.txt");
            }

            else if (opcaoInicial == 3) {   // Sair e salvar

                System.out.println("Salvando dados e saindo...");
                break; // Encerra o programa
            }
            else {
                System.out.println("Opção inválida.");
            }
        }
        // Loop para o codigo voltar ao menu a depender da escolha do usuario
        
        while (true) {
            System.out.println("Bem vindo! Digite o número da opção que deseja:");
            System.out.println(System.lineSeparator());
            System.out.println("1 --- Comprar");
            System.out.println("2 --- Vender");
            System.out.println("3 --- Sair");
            
            
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
        input.close();
    }
        
    
}