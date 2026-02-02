package telas;

import model.ProdutosEstoque;
import model.Produto;

import java.io.IOException;
import java.util.HashMap;
import java.util.*;

public class TelaVendas implements Tela {

    Scanner input = new Scanner(System.in);
    private ProdutosEstoque produtos; // declarando lista local baseada na lista global

    public TelaVendas(ProdutosEstoque estoque) {
        this.produtos = estoque;
    }

    @Override
    public void mostrar() {

        System.out.println();
        System.out.println("=== Area de Vendas ===");
        System.out.println();
        System.out.println("1 --- Cadastrar Produto");
        System.out.println("2 --- Deletar produto");
        System.out.println("3 --- Voltar");
        System.out.println();
        System.out.print("Digite a opção que deseja: ");

    }  // Tela de opções para o usuario escolher pelo número.

    @Override
    public void executarOpcao(int opcao) throws IOException {
        switch (opcao) {
            case 1 -> cadastrarProduto();
            case 2 -> deletarProduto();
            case 3 -> voltar();
            default -> System.out.println("Opção invalida");
        }
    } //  Switch para selecionar o metodo de acordo com a opção selecionada

    public void cadastrarProduto() throws IOException {

        System.out.println();
        System.out.println("Digite o nome do produto: ");
        String nomeProduto = input.nextLine();
        System.out.println("Digite o valor do produto: ");
        double valorProduto = input.nextDouble();
        input.nextLine();

        Produto produto = new Produto(nomeProduto, valorProduto);
        produtos.addProduto(produto);
        produtos.salvarEmArquivo("produtos.txt");
        System.out.println("Produto cadastrado com sucesso!");
        return;

    }

    public void deletarProduto() throws IOException {

        System.out.println();
        produtos.getProdutos();
        System.out.println();
        System.out.print("Digite o número do item que deseja deletar: ");
        int excluido = input.nextInt();
        System.out.println();

        produtos.removeProduto(excluido);
        produtos.salvarEmArquivo("produtos.txt");
        System.out.println("Produto removido com sucesso!");
        System.out.println();
        return;
    }

    public void voltar() {
        return;
    }


}