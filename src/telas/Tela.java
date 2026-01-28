package telas;

import java.io.IOException;

public interface Tela {
    void mostrar();
    void executarOpcao(int opcao) throws IOException;
}
