import java.time.LocalDate;

public class Livro{
  private String titulo;
  private String autor;
  private AreaDeConhecimento areaDeConhecimento;
  private LocalDate dataDePublicacao;
  private int qtdDeCopias;

  public Livro(String titulo, String autor, AreaDeConhecimento areaDeConhecimento, int qtdDeCopias, LocalDate dataDePublicacao){
  this.titulo=titulo;
  this.autor= autor;
  this.areaDeConhecimento = areaDeConhecimento;
  this.dataDePublicacao = dataDePublicacao;
  this.qtdDeCopias = qtdDeCopias;
  }

  public String getTitulo(){
    return this.titulo;
  }

  public String getAutor(){
    return this.autor;
  }

  public int getQtdDeCopias(){
    return this.qtdDeCopias;
  }

  public AreaDeConhecimento getAreaDeConhecimento(){
    return this.areaDeConhecimento;
  }

  public LocalDate getDataDePublicacao(){
    return dataDePublicacao;
  }
  
  

  public void setTitulo(String titulo){
   this.titulo=titulo;
   System.out.println("Titulo alteradado com sucesso! ");
  }

  public void setAutor(String autor){
    this.autor=autor;
    System.out.println("Autor alteradado com sucesso! ");
  }

  public void setQtdDeCopias(int qtdDeCopias){
  this.qtdDeCopias = qtdDeCopias;
  System.out.println("Quantidade de cópias alteradada com sucesso! ");
  }

  public void setTituloAreaDeConhecimento(String titulo){
   areaDeConhecimento.setTitulo(titulo);
   
  }

public void setDescricaoAreaDeConhecimento(String descricao){
  areaDeConhecimento.setDescricao(descricao);
}

  public void setDataDePublicacao(LocalDate dataDePublicacao){
    this.dataDePublicacao = dataDePublicacao;
  }
  
}