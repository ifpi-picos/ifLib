import java.time.LocalDate;

public class Livro {
    private String titulo;
    private String autor;
    private AreaConhecimento areaConhecimento;
    private LocalDate dataDePublicacao;
    private int qtdDeCopias;

    public Livro(String titulo, String autor, AreaConhecimento areaConhecimento, int qtdDeCopias,
            LocalDate dataDePublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.areaConhecimento = areaConhecimento;
        this.dataDePublicacao = dataDePublicacao;
        this.qtdDeCopias = qtdDeCopias;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getQtdDeCopias() {
        return this.qtdDeCopias;
    }

    public AreaConhecimento getAreaConhecimento() {
        return this.areaConhecimento;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
        System.out.println("Título alterado com sucesso!");
    }

    public void setAutor(String autor) {
        this.autor = autor;
        System.out.println("Autor alteradado com sucesso!\n");
    }

    public void setQtdDeCopias(int qtdDeCopias) {
        this.qtdDeCopias = qtdDeCopias;
    }

    public void setTituloAreaConhecimento(String titulo) {
        areaConhecimento.setTitulo(titulo);

    }

    public void setDescricaoAreaConhecimento(String descricao) {
        areaConhecimento.setDescricao(descricao);
    }

    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

}
