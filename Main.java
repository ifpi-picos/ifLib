import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;


  
class Main {
  public static void main(String[] args) {

    List<Livro> livros = new ArrayList<>();
    List<Usuario> usuarios = new ArrayList<>();
    List<Emprestimo> emprestimos = new ArrayList<>();
    
  while (true){
   String opcao = JOptionPane.showInputDialog("Escolha uma opção:\n 1-Usuário\n 2-Livro\n 3-Empréstimo\n 0-Sair");

    //usuario
  if (opcao.equals("1")){
    String opcaoParaUsuario = JOptionPane.showInputDialog("Escolha uma opção:\n 1-Cadastrar Usuários\n 2-Listar Usuários\n 3-Alterar Usuário\n 4-Remover Usuário\n 0-Voltar");

  if (opcaoParaUsuario.equals("1")){
    String nome = JOptionPane.showInputDialog("Nome do usuário:");
    String email = JOptionPane.showInputDialog("Informe seu E-mail:");

    //data de nascimento
    String ano = JOptionPane.showInputDialog(" Digite seu ano de nascimento:");
    int anoConvertido = Integer.parseInt(ano);
    String mes = JOptionPane.showInputDialog(" Digite o número do seu mes de nascimento:");
    int mesConvertido = Integer.parseInt(mes);
    String dia = JOptionPane.showInputDialog(" Digite seu dia de nascimento:");
    int diaConvertido = Integer.parseInt(dia);
    
   //endereco
   String logradouro = JOptionPane.showInputDialog("Informe seu logradouro:");
   String uf = JOptionPane.showInputDialog("Estado(uf):");
   String cidade = JOptionPane.showInputDialog(" Cidade:");
 String numeroCasa=JOptionPane.showInputDialog("Numero da casa:");
int numeroCasaConvertido = Integer.parseInt(numeroCasa);
    
  Endereco endereco = new Endereco(logradouro, uf, cidade, numeroCasaConvertido);

  Usuario usuario = new Usuario(nome,email,LocalDate.of(anoConvertido, mesConvertido, diaConvertido), endereco ); 
  usuarios.add(usuario);
    }

    else if (opcaoParaUsuario.equals("2")){
    for (Usuario usuario : usuarios){
    System.out.println("Nome: "+usuario.getNome()+"; E-mail: "+usuario.getEmail()+"; Data de nascimento: "+usuario.getDataDeNascimento()+"\n");
    }
    }

    else if (opcaoParaUsuario.equals("3")){
 String buscarNome = JOptionPane.showInputDialog("Digite o nome do usuário que deseja alterar");
    
  boolean naoAchouNome = true;
    
  for(Usuario usuario : usuarios){
    String nome = usuario.getNome();
    if (nome.equals(buscarNome)){
     String escolhaObjetoParaAlterar = JOptionPane.showInputDialog("Escolha o que você deseja alterar:\n 1-Nome\n 2-Email\n 3- Data de Nascimento\n 4-Endereço\n 0-Voltar");
      
  naoAchouNome = false;

    if(escolhaObjetoParaAlterar.equals("1")){
  nome = JOptionPane.showInputDialog("Digite o novo nome:");
  usuario.setNome(nome);
    
    }

  else if(escolhaObjetoParaAlterar.equals("2")){
 String email = JOptionPane.showInputDialog("Digite o novo E-mail:");
  usuario.setEmail(email);
    }

    else if(escolhaObjetoParaAlterar.equals("3")){
          String ano = JOptionPane.showInputDialog(" Digite seu ano de nascimento:");
    int anoConvertido = Integer.parseInt(ano);
    String mes = JOptionPane.showInputDialog(" Digite o número do seu mês de nascimento:");
    int mesConvertido = Integer.parseInt(mes);
    String dia = JOptionPane.showInputDialog(" Digite seu dia de nascimento:");
    int diaConvertido = Integer.parseInt(dia);

    usuario.setDataDeNascimento(LocalDate.of(anoConvertido, mesConvertido, diaConvertido));
    }
    
    else if(escolhaObjetoParaAlterar.equals("4")){

  String logradouro = JOptionPane.showInputDialog("Digite o logradouro:");

  String uf = JOptionPane.showInputDialog("Digite o novo Estado(uf):");

  String cidade = JOptionPane.showInputDialog("Digite a Cidade:");

  String numeroCasa = JOptionPane.showInputDialog("Digite o Número da casa:");
  int numeroCasaConvertido = Integer.parseInt(numeroCasa);
      
  Endereco endereco = new Endereco(logradouro, uf, cidade, numeroCasaConvertido);
  usuario.setEndereco(endereco);
    }

    else if(escolhaObjetoParaAlterar.equals("0")){
    break;
    }
    }   
    }
      if (naoAchouNome){
        System.out.println("Usuario não encontrado!\nVerifique se digitou o nome corretamente!");
      }
    }
     

   else  if (opcaoParaUsuario.equals("4")){
    int cont = 0;
    for (Usuario usuario : usuarios){
    System.out.println(cont + "-Nome: "+usuario.getNome()+"; E-mail: "+usuario.getEmail()+"; Data de nascimento: "+usuario.getDataDeNascimento()+"\n");
    cont += 1;
    }
    String escolhaUsuario = JOptionPane.showInputDialog("Digite a posição(número na lista) do usuário que deseja remover:");
     int escolhaUsuarioConvertido = Integer.parseInt(escolhaUsuario);
    if (usuarios.get(escolhaUsuarioConvertido).getNaoTemLivroEmprestado()){
      usuarios.remove(escolhaUsuarioConvertido);
    }else{
      System.out.println("O usuário não pôde ser removido, pois está com um empréstimo em aberto!");
    }
     }
     
   else if (opcaoParaUsuario.equals("0")){
      break;
    }
  }

    
    //livro
  else if (opcao.equals("2")){
    String opcaoParaLivro = JOptionPane.showInputDialog("Escolha uma opção:\n 1-Cadastrar Livros\n 2-Listar Livros\n 3-Alterar Livro\n 4-Remover Livro\n 0-Voltar");
    
   if (opcaoParaLivro.equals("1")){
  String titulo=JOptionPane.showInputDialog("Título do livro:");
     String autor=JOptionPane.showInputDialog("Autor do livro:");
   String tituloDaArea=JOptionPane.showInputDialog("Título da área de conhecimento:");
   String descricao=JOptionPane.showInputDialog("Descrição da área de conhecimento:");
  AreaDeConhecimento areaDeConhecimento = new AreaDeConhecimento(tituloDaArea, descricao);
  //dataDePublicacao
 String ano =JOptionPane.showInputDialog(" Ano de publicação do livro:");
  int anoConvertido = Integer.parseInt(ano);
 String mes=JOptionPane.showInputDialog(" Mês de publicação do livro:");
 int mesConvertido = Integer.parseInt(mes);
 String dia = JOptionPane.showInputDialog("Di de publicação do livro:");
 int diaConvertido =  Integer.parseInt(dia);
 String qtdDeCopias=JOptionPane.showInputDialog("Quantidade de cópias do livro:");
int qtdDeCopiasConvertido = Integer.parseInt(qtdDeCopias);
  
Livro livro=new Livro(titulo,autor,areaDeConhecimento,qtdDeCopiasConvertido, LocalDate.of(anoConvertido, mesConvertido, diaConvertido)); 
  livros.add(livro);
       }
    
  else if (opcaoParaLivro.equals("2")){
    for (Livro livro : livros){
    System.out.println("Título: "+livro.getTitulo()+"; Autor: "+livro.getAutor()+ "; Data de publicação: "+livro.getDataDePublicacao()+"; Quantidade de acervos: "+livro.getQtdDeCopias()+"\n");
    }
      }

  else if (opcaoParaLivro.equals("3")){
 String buscarTitulo=JOptionPane.showInputDialog("Digite o título do livro que deseja alterar");
    
  boolean naoAchouTitulo = false;
    
  for(Livro livro : livros){
    String titulo=livro.getTitulo();
    if (titulo.equals(buscarTitulo)){
     String escolhaObjetoParaAlterar=JOptionPane.showInputDialog("Escolha o que você deseja alterar:\n 1-Titulo\n 2-Autor\n 3-Quantidade de cópias\n 4-Area de conhecimento\n 5-Data de publicação\n 0-Voltar");
      
  naoAchouTitulo = false;

    if(escolhaObjetoParaAlterar.equals("1")){
  titulo= JOptionPane.showInputDialog("Digite o novo título:");
  livro.setTitulo(titulo);
    
    }

  if(escolhaObjetoParaAlterar.equals("2")){
  String autor = JOptionPane.showInputDialog("Digite o novo autor:");
  livro.setAutor(autor);
    }

  if(escolhaObjetoParaAlterar.equals("3")){
   String qtdDeCopias = JOptionPane.showInputDialog("Digite a atual quantidade de cópias:");
 int qtdDeCopiasConvertido = Integer.parseInt(qtdDeCopias);
    livro.setQtdDeCopias(qtdDeCopiasConvertido);
    }

    if(escolhaObjetoParaAlterar.equals("4")){

String escolhaTituloDescricao=JOptionPane.showInputDialog("Escolha o que você deseja alterar:\n 1-Titulo da área de conhecimento\n 2-Descricao da área de conhecimento");

    if (escolhaTituloDescricao.equals("1")){
  String tituloDaArea = JOptionPane.showInputDialog("Digite o novo titulo da área de conhecimento:");
  livro.setTituloAreaDeConhecimento(tituloDaArea);
     }
    else if (escolhaTituloDescricao.equals("2")){
    String descricaoDaArea = JOptionPane.showInputDialog("Digite a nova descrição da área de conhecimento:");
  livro.setDescricaoAreaDeConhecimento(descricaoDaArea);
    }
    }

if(escolhaObjetoParaAlterar.equals("5")){
  String ano =JOptionPane.showInputDialog(" Digite o novo ano de publicação do livro:");
  int anoConvertido = Integer.parseInt(ano);
 String mes=JOptionPane.showInputDialog("O novo mês de publicação do livro:");
 int mesConvertido = Integer.parseInt(mes);
 String dia = JOptionPane.showInputDialog("O novo dia de publicação do livro:");
 int diaConvertido =  Integer.parseInt(dia);
  livro.setDataDePublicacao(LocalDate.of(anoConvertido, mesConvertido, diaConvertido));   }     
    if(escolhaObjetoParaAlterar.equals("0")){
    break;
    }
    
    }
    
  }
  if (naoAchouTitulo){
    System.out.println("Livro não encontrado!\nVerifique se digitou o título corretamente!");
  }
    }

  else if (opcaoParaLivro.equals("4")){
  int cont = 0;
   for (Livro livro : livros){
    System.out.println(cont + "-Título: "+livro.getTitulo()+"; Autor: "+livro.getAutor()+ "; Data de publicação: "+livro.getDataDePublicacao()+"; Quantidade de acervos: "+livro.getQtdDeCopias()+"\n");
    cont += 1;
    }
    String escolhaLivro= JOptionPane.showInputDialog("Digite a posição(número na lista) do ulivroque deseja remover:");
     int escolhaLivroConvertido = Integer.parseInt(escolhaLivro);

    List<String> nomesDosUsuariosQPegaramOLivro = new ArrayList<>();
    boolean livroEmprestado = false;
    for (Emprestimo emprestimo : emprestimos){   
     if (livros.get(escolhaLivroConvertido).equals(emprestimo.getLivro())){
     nomesDosUsuariosQPegaramOLivro.add(emprestimo.getUsuario().getNome());
     livroEmprestado = true;
     }
      }
    if (livroEmprestado){
      System.out.println("Impossível remover Livro!\nExistem cópias emprestadas para o(s) usuário(s): " + nomesDosUsuariosQPegaramOLivro);
    }else{      livros.remove(escolhaLivroConvertido);

    System.out.println("Livro removido!");
     }    
    } 
    
     else if (opcaoParaLivro.equals("0")){
    break;
  }
    }


    //emprestimo
  else if (opcao.equals("3")){
    String opcaoParaEmprestimo = JOptionPane.showInputDialog("Escolha uma opção:\n 1-Fazer empréstimo de livro\n 2-Listar empréstimos\n 3-Devolver livro\n 0-Voltar");

    if (opcaoParaEmprestimo.equals("1")){
     //usuário 
     for (int i = 0; i < usuarios.size(); i++) {
    System.out.println(i + usuarios.get(i).getNome());
}
    String escolhaUsuario = JOptionPane.showInputDialog("Continuar com qual usuário?");
    int escolhaUsuarioConvertido = Integer.parseInt(escolhaUsuario);
    Usuario usuario = usuarios.get(escolhaUsuarioConvertido);

    //livro
    for (int i = 0; i < livros.size(); i++) {
    System.out.println(i + livros.get(i).getTitulo()+"; Autor: " + livros.get(i).getAutor());
}
    String escolhaLivro = JOptionPane.showInputDialog("Qual livro deseja tomar emprestado?");
    int escolhaLivroConvertido = Integer.parseInt(escolhaLivro);
    Livro livro = livros.get(escolhaLivroConvertido);

    //data
    String ano = JOptionPane.showInputDialog(" Digite seu ano de nascimento:");
    int anoConvertido = Integer.parseInt(ano);
    String mes = JOptionPane.showInputDialog(" Digite o número do seu mês de nascimento:");
    int mesConvertido = Integer.parseInt(mes);
    String dia = JOptionPane.showInputDialog(" Digite seu dia de nascimento:");
    int diaConvertido = Integer.parseInt(dia);

    Emprestimo emprestimo = new Emprestimo(usuario, livro, LocalDate.of(anoConvertido, mesConvertido, diaConvertido));
    emprestimos.add(emprestimo);
      }


    else if (opcaoParaEmprestimo.equals("2")){
      for (int i = 0; i < emprestimos.size(); i++) {
    System.out.println(i + emprestimos.get(i).getUsuario().getNome() + " pegou o livro '" +  emprestimos.get(i).getLivro().getTitulo() + "', na data:" + emprestimos.get(i).getData());
    }
  }
      
    else if (opcaoParaEmprestimo.equals("3")){
      for (int i = 0; i < emprestimos.size(); i++) {
    System.out.println(i + emprestimos.get(i).getUsuario().getNome() + " pegou o livro '" +  emprestimos.get(i).getLivro().getTitulo() + "', na data:" + emprestimos.get(i).getData());
    }
     String escolhaEmprestimo = JOptionPane.showInputDialog("Qual desses é seu empréstimo?");
     int escolhaEmprestimoConvertido = Integer.parseInt(escolhaEmprestimo);
      
    Usuario usuario = emprestimos.get(escolhaEmprestimoConvertido).getUsuario();
    Livro livro = emprestimos.get(escolhaEmprestimoConvertido).getLivro();
    Emprestimo emprestimo = emprestimos.get(escolhaEmprestimoConvertido);
      emprestimo.devolver(usuario, livro);

    emprestimos.remove(escolhaEmprestimoConvertido);
    }

    if (opcaoParaEmprestimo.equals("0")){
      break;
    }
  }

    
    //sair
  else if (opcao.equals("0")){
    break;
  }
    }
    }
  }



// não testei.