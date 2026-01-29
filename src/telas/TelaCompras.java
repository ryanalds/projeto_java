package telas;

import model.ProdutosEstoque;
import model.Produto;
import  java.util.Scanner;


public class TelaCompras implements Tela {

    Scanner input = new Scanner(System.in);
    private ProdutosEstoque produtos; // declarando lista local baseada na lista global

    public TelaCompras(ProdutosEstoque estoque) {
        this.produtos = estoque;
    }


    @Override
    public void mostrar() {

        System.out.println();
        System.out.println("=== Area de Compras ===");
        System.out.println();
        System.out.println("1 --- Listar produtos");
        System.out.println("2 --- Comprar produto");
        System.out.println("3 --- Voltar");
        System.out.println();
        System.out.print("Digite a opção que deseja: ");

    }

    @Override
    public void executarOpcao(int opcao) {
        switch (opcao){
            case 1 -> listarProdutos();
            case 2 -> comprarProduto();
            case 3 -> voltar();
            default -> System.out.println("Opção invalida");
        }
    }

    public void listarProdutos() {

        System.out.println();
        produtos.getProdutos();
    }

    public void comprarProduto(){

        System.out.println();
        produtos.getProdutos();
        System.out.println();
        System.out.print("Selecione o produto que vocÊ deseja comprar: ");
        int selecionado = input.nextInt();
        System.out.println();

        Produto compra = produtos.getProduto(selecionado);
        System.out.println("Produto: " + compra.getNome() + "\nValor: " + compra.getValor());
        System.out.println();

        System.out.println("Qual a forma de pagamento?");
        System.out.println("1 --- Credito");
        System.out.println("2 --- Debito");
        System.out.println("3 --- Pix");
        System.out.println();
        System.out.print("Selecione a forma de pagamento: ");
        int pagamentoSelecionado = input.nextInt();
        System.out.println();
        System.out.println("Pagamento realizado com sucesso!");
        return;


    }

    public void voltar() {
        return;
    }

}
