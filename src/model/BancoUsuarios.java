package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BancoUsuarios {
    private final List<Usuario> listaUsuarios =  new ArrayList<>();

    public List<Usuario> getListaUsuarios() {
        return this.listaUsuarios;
    }

    public void adicionarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        listaUsuarios.remove(usuario);
    }

    public Usuario buscarPorEmail(String emailAlvo) {
        for (Usuario u : listaUsuarios) {
            if (u.getEmail().equalsIgnoreCase(emailAlvo)) {
                return u;
            }
        }
        return null;
    }

    public void salvarEmArquivo(String nomeArquivo) throws IOException { // método para salvar arquivo

        BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));

        for (Usuario u : listaUsuarios) {  // formato nome;email;senha
            String linha = u.getNome() + "," + u.getEmail() + "," + u.getSenha();
            writer.write(linha);
            writer.newLine();
        }
        writer.close();  // fecha e salva o arquivo.
    }

    public void carregarDeArquivo(String nomeArquivo) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
        String linha;

        while ((linha = reader.readLine()) != null){
            String[] dados = linha.split(",");

            if (dados.length == 3){  // garante que os dados tem 3 partes
                String nome = dados[0];
                String email = dados[1];
                String senha = dados[2];    

                Usuario usuario = new Usuario (nome, email, senha);
                listaUsuarios.add(usuario);
            }
        }
        reader.close();
    }
} 
