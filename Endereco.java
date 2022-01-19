public class Endereco{
 private String logradouro;
 private String uf;
 private String cidade;
 private int numeroCasa;

 public Endereco(String logradouro,String uf,String cidade, int numeroCasa){
    this.logradouro=logradouro;
    this.cidade=cidade;
    this.uf=uf;
    this.numeroCasa= numeroCasa;
 }

  public String getLogradouro() {
    return logradouro;
  }
   public String getUf() {
    return uf;
  }
   public String getCidade() {
    return cidade;
  }
   public int getNumeroCasa() {
    return numeroCasa;
  }

  }