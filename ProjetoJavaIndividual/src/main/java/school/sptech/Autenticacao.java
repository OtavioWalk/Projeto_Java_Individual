package school.sptech;

import java.util.List;

public class Autenticacao {
    private List<Usuario> listaUsuarios;

    public Autenticacao(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public boolean autenticarUsuario(String nomeUsuario, String senha) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNomeUsuario().equals(nomeUsuario) && usuario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}

