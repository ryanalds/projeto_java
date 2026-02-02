package model;


public class Cadastro {
    
    private BancoUsuarios bancodeDados;
    
    public Cadastro(BancoUsuarios bancoCompartilhado) { // Construtor que recebe o banco de dados compartilhado
        this.bancodeDados = bancoCompartilhado;
    }

    public boolean cadastrarUsuario(String nome, String email, String senha) {

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {  // verifica se algum campo está vazio.
            System.out.println("Todos os campos devem ser preenchidos.");
            return false;
        }
        // verifica se o email é válido
        if (!email.contains("@")) {
            System.out.println("Email inválido.");
            return false;
        }
        Usuario existente = bancodeDados.buscarPorEmail(email);

        if (existente != null) { // verifica se o email já está cadastrado
            System.out.println("O email " + email + " já cadastrado.");
            return false;

        }
        Usuario novoUsuario = new Usuario(nome, email, senha);
        bancodeDados.adicionarUsuario(novoUsuario); // Adiciona o novo usuário ao bando de dados compartilhado.

        System.out.println("Sucesso! Usuário " + nome + " cadastrado.");
        return true;
    }

}