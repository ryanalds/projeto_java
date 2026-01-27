public class Usuario {

    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha){
        this.nome= nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public boolean validarEmail(String emailDigitado){
        return  this.email.equals((emailDigitado));
    }

    public boolean validarSenha(String senhaDigitada){
        return this.senha.equals(senhaDigitada);
    }

}
