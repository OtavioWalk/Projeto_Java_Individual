package school.sptech;

public class Jogo {
    private String titulo;
    private String genero;
    private int anoLancamento;
    private String desenvolvedor;
    private boolean disponivel;

    public Jogo(String titulo, String genero, int anoLancamento, String desenvolvedor) {
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.desenvolvedor = desenvolvedor;
        this.disponivel = true;
    }


    public boolean isDisponivel() {
        return disponivel;
    }

    String disp = "Sim";

    public String toString() {

        if (disponivel == true) {

            disp = "Sim";

        } else {

            disp = "Não";

        }

        return """
                 Título: %s
                 Gênero: %s
                 Ano de Lançamento: %d
                 Desenvolvedor: %s
                 Disponível: %s
                 
                -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
                 """.formatted(titulo, genero, anoLancamento, desenvolvedor, disp);

    }

    public String getTitulo() {
        return titulo;
    }
}

