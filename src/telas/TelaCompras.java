package telas;

public class TelaCompras implements Tela {

    @Override
    public void mostrar() {
        System.out.println("=== Area de Compras ===");
        System.out.println(System.lineSeparator());
        System.out.println("1 --- Listar produtos");
        System.out.println("2 --- Comprar produto");
        System.out.println("3 --- Voltar");

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
        System.out.println("....");
    }

    public void comprarProduto(){
        System.out.println("....");
    }

    public void voltar() {
        System.out.println("....");
    }

}
