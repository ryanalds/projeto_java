import java.util.*;

public class Main {

    public static void main (String[] args){

        // Login do Usuario:

        Scanner input = new Scanner(System.in);

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Ryan Almeida", "ryanalds21@gmail.com", "poo123@"));

        System.out.println("Digite seu e-mail: ");
        String email = input.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = input.nextLine();

        Usuario logado = AuthService.autenticar(email, senha, usuarios);
        if (logado != null){
            System.out.println("Login realizado com sucesso");
        }
        else {
            System.out.println("E-mail ou Senhas invalidos");
        }

        // Opções do Menu:

        System.out.println("Bem vindo! Digite o número da opção que deseja:");
        System.out.println(System.lineSeparator() + System.lineSeparator());
        System.out.println("1 --- Comprar");
        System.out.println("2 --- Vender");

        int escolha = input.nextInt();
        Tela telaAtual = null;

        if (escolha == 1 ){
            telaAtual = new TelaCompras();
        }else {
            telaAtual = new TelaVendas();
        }

        telaAtual.mostrar();
        int opcao = input.nextInt();
        telaAtual.executarOpcao(opcao);









    }
}