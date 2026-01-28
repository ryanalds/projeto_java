package model;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ProdutosEstoque {

    protected List<Produto> produtos = new ArrayList<>();

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removeProduto(Produto produto) {
        produtos.remove(produto);
    }

    public void getProdutos() {
        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            System.out.println(i + " --- " + p.getNome() + " - R$ " + p.getValor());
        }
    }

    public void removeProduto(int indice) {
        produtos.remove(indice);
    }
}
