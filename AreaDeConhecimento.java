public class AreaDeConhecimento{
  private String titulo;
  private String descricao;

  public AreaDeConhecimento(String titulo, String descricao){
    this.descricao = descricao;
    this.titulo = titulo;
  }



public String getTitulo(){
   return this.titulo;
   
  }
  
  public void setTitulo(String titulo){
   this.titulo = titulo;
   
  }

  public void setDescricao(String descricao){
  this.descricao = descricao;
}
  
}