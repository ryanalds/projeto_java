package model;
import java.util.List;
import java.util.ArrayList;

public class ProdutosEstoque {

    private List<Produto> produtos = new ArrayList<>();

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
