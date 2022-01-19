import java.time.LocalDate;

public class Emprestimo{
  private Usuario usuario;
  private Livro livro;
  private LocalDate data;

  public Emprestimo(Usuario usuario, Livro livro, LocalDate data){
   if  (livro.getQtdDeCopias() > 0 && usuario.getNaoTemLivroEmprestado()){
     this.usuario = usuario;
     this.livro = livro;
     this.data = data;
     usuario.setNaoTemLivroEmprestado(false);
     livro.setQtdDeCopias(livro.getQtdDeCopias()-1);
     
   }else{
     System.out.println("OPS! Algo de errado\nVerifique se há cópias disponíveis deste livro, ou se você já não pegou um livro emprestado nesta livraria (Só só pode pegar emprestado um livro por vez)");
   }
    
  }

  public void devolver(Usuario usuario, Livro livro){
      livro.setQtdDeCopias(livro.getQtdDeCopias()+1);
    usuario.setNaoTemLivroEmprestado(true); 
     System.out.println("Livro devolvido!");
  }

  public Usuario getUsuario(){
    return this.usuario;
  }

  public Livro getLivro(){
    return this.livro;
  }

  public LocalDate getData(){
    return this.data;
  }
}