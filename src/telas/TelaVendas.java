package telas;

public class TelaVendas implements Tela {

    @Override
    public void mostrar() {
        System.out.println("=== Area de Vendas ===");
        System.out.println(System.lineSeparator());
        System.out.println("1 --- Cadastrar model.Produto");
        System.out.println("2 --- Deletar produto");
        System.out.println("3 --- Voltar");

    }

    @Override
    public void executarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarProduto();
            case 2 -> deletarProduto();
            case 3 -> voltar();
            default -> System.out.println("Opção invalida");
        }
    }

    public void cadastrarProduto() {
        System.out.println("....");
    }

    public void deletarProduto() {
        System.out.println("....");
    }

    public void voltar() {
        System.out.println("....");
    }


}
