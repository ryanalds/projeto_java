package auth;
import model.*;
import java.util.List;

public class AuthService {

    public static Usuario autenticar(
            String email,
            String senha,
            List<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            if (u.validarEmail(email) && u.validarSenha(senha)) {
                return u; // logado com sucesso
            }
        }
        return null; // falha ao logar
    }
}
