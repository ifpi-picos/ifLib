import java.time.LocalDate;

public class Usuario {
    private String nome;
    private String email;
    private LocalDate dataDeNascimento;
    private Endereco endereco;
    private boolean naoTemLivroEmprestado;

    public Usuario(String nome, String email, LocalDate dataDeNascimento, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDate getDataDeNascimento() {
        return this.dataDeNascimento;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public Boolean getNaoTemLivroEmprestado() {
        return naoTemLivroEmprestado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setNaoTemLivroEmprestado(Boolean naoTemLivroEmprestado) {
        this.naoTemLivroEmprestado = naoTemLivroEmprestado;
    }
}
