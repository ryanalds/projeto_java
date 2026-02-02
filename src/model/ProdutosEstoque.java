package model;

import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;



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

    public  Produto getProduto(int indice){
        Produto p = produtos.get(indice);
        return p;
    }

    public void removeProduto(int indice) {
        produtos.remove(indice);
    }

    public void salvarEmArquivo (String caminho) throws IOException {

        try (PrintWriter writer = new PrintWriter(new FileWriter(caminho))){

            for (Produto p : produtos){
                writer.println(p.getNome() + ";" + p.getValor());
            }
        }catch (IOException e) {
            System.out.println("Error ao salvar aquivo:"+ e.getMessage());
        }
    }

    public void carregarDeArquivo(String caminho) {
        produtos.clear(); // limpa lista atual

        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {

            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");

                String nome = partes[0];
                double valor = Double.parseDouble(partes[1]);

                Produto p = new Produto(nome, valor);
                produtos.add(p);
            }

        } catch (IOException e) {
            System.out.println("Arquivo não encontrado, começando vazio.");
        }
    }

}
