package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Jogo> jogos;

    public Biblioteca() {
        jogos = new ArrayList<>();
    }

    public void adicionarJogo(Jogo jogo) {
        jogos.add(jogo);
    }

    public void removerJogo(Jogo jogo) {
        jogos.remove(jogo);
    }

    public List<Jogo> listarJogosDisponiveis() {
        List<Jogo> disponiveis = new ArrayList<>();
        for (Jogo jogo : jogos) {
            if (jogo.isDisponivel()) {
                disponiveis.add(jogo);
            }
        }
        return disponiveis;
    }
}
