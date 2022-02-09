import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

class Main {

    public static void main(String[] args) {

        List<Livro> livros = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();
        List<Emprestimo> emprestimos = new ArrayList<>();

        // Opções da Interface
        while (true) {
            String opcao = JOptionPane.showInputDialog(
                    "Escolha uma das opções abaixo:\n 1 - Usuários\n 2 - Livros\n 3 - Empréstimos\n 0 - Sair");

            // Opcões do Usuário
            if (opcao.equals("1")) {
                String opcaoParaUsuario = JOptionPane.showInputDialog(
                        "Escolha uma das opções abaixo:\n 1 - Cadastrar Usuários\n 2 - Listar Usuários\n 3 - Alterar Usuários\n 4 - Remover Usuários\n 0 - Voltar");

                // Cadastrar usuários
                if (opcaoParaUsuario.equals("1")) {
                    String nome = JOptionPane.showInputDialog("Informe o nome do usuário:");
                    String email = JOptionPane.showInputDialog("Informe o e-mail do usuário:");

                    // Data de nascimento
                    String ano = JOptionPane.showInputDialog("Informe o ano de nascimento:");
                    int anoConvertido = Integer.parseInt(ano);
                    String mes = JOptionPane.showInputDialog("Informe o mês de nascimento:");
                    int mesConvertido = Integer.parseInt(mes);
                    String dia = JOptionPane.showInputDialog("Informe o dia de nascimento:");
                    int diaConvertido = Integer.parseInt(dia);

                    // Endereço
                    String logradouro = JOptionPane.showInputDialog("Informe o logradouro:");
                    String uf = JOptionPane.showInputDialog("Informe o Estado│UF:");
                    String cidade = JOptionPane.showInputDialog("Informe a cidade:");
                    String numeroCasa = JOptionPane.showInputDialog("Informe o número da casa:");
                    int numeroCasaConvertido = Integer.parseInt(numeroCasa);

                    Endereco endereco = new Endereco(logradouro, uf, cidade, numeroCasaConvertido);

                    Usuario usuario = new Usuario(nome, email,
                            LocalDate.of(anoConvertido, mesConvertido, diaConvertido), endereco);
                    usuarios.add(usuario);
                    usuario.setNaoTemLivroEmprestado(true);
                }

                // Listar Usuários
                else if (opcaoParaUsuario.equals("2")) {
                    for (Usuario usuario : usuarios) {
                        System.out.println("Nome: " + usuario.getNome() + "\nE-mail: " + usuario.getEmail()
                                + "\nData de nascimento: " + usuario.getDataDeNascimento() + "\n");
                    }
                }

                // Alterar Usuário
                else if (opcaoParaUsuario.equals("3")) {
                    String buscarNome = JOptionPane.showInputDialog("Digite o nome do usuário que deseja alterar:");

                    boolean naoAchouNome = true;

                    // Opções de alteração dos dados do usuário
                    for (Usuario usuario : usuarios) {
                        String nome = usuario.getNome();
                        if (nome.equals(buscarNome)) {
                            String escolhaObjetoParaAlterar = JOptionPane.showInputDialog(
                                    "Escolha o que você deseja alterar:\n 1 - Nome\n 2 - E-mail\n 3 - Data de Nascimento\n 4 - Endereço\n 0 - Voltar");

                            naoAchouNome = false;

                            // Alterar nome
                            if (escolhaObjetoParaAlterar.equals("1")) {
                                nome = JOptionPane.showInputDialog("Informe o novo nome:");
                                usuario.setNome(nome);

                            }

                            // Alterar email
                            else if (escolhaObjetoParaAlterar.equals("2")) {
                                String email = JOptionPane.showInputDialog("Informe o novo e-mail:");
                                usuario.setEmail(email);
                            }

                            // Alterar data de nascimento
                            else if (escolhaObjetoParaAlterar.equals("3")) {
                                String ano = JOptionPane.showInputDialog("Informe o ano de nascimento:");
                                int anoConvertido = Integer.parseInt(ano);
                                String mes = JOptionPane.showInputDialog("Informe o mês de nascimento:");
                                int mesConvertido = Integer.parseInt(mes);
                                String dia = JOptionPane.showInputDialog("Informe o dia de nascimento:");
                                int diaConvertido = Integer.parseInt(dia);

                                usuario.setDataDeNascimento(LocalDate.of(anoConvertido, mesConvertido, diaConvertido));
                            }

                            // Alterar endereço
                            else if (escolhaObjetoParaAlterar.equals("4")) {

                                String logradouro = JOptionPane.showInputDialog("Informe o logradouro:");

                                String uf = JOptionPane.showInputDialog("Informe o Estado│UF:");

                                String cidade = JOptionPane.showInputDialog("Informe a cidade:");

                                String numeroCasa = JOptionPane.showInputDialog("Informe o número da casa:");
                                int numeroCasaConvertido = Integer.parseInt(numeroCasa);

                                Endereco endereco = new Endereco(logradouro, uf, cidade, numeroCasaConvertido);
                                usuario.setEndereco(endereco);
                            }

                            // Voltar
                            else if (escolhaObjetoParaAlterar.equals("0")) {

                            }
                        }
                    }

                    // Nome não cadastrado
                    if (naoAchouNome) {
                        System.out.println("Usuário não encontrado! Verifique se digitou o nome corretamente!\n");
                    }
                }

                // Remover Usuários
                else if (opcaoParaUsuario.equals("4")) {
                    int cont = 0;
                    for (Usuario usuario : usuarios) {
                        System.out.println(cont + " Nome: " + usuario.getNome() + " │ E-mail: " + usuario.getEmail()
                                + " │ Data de nascimento: " + usuario.getDataDeNascimento());
                        cont += 1;
                    }
                    String escolhaUsuario = JOptionPane
                            .showInputDialog("Digite a posição (número na lista) do usuário que deseja remover:");
                    int escolhaUsuarioConvertido = Integer.parseInt(escolhaUsuario);
                    if (usuarios.get(escolhaUsuarioConvertido).getNaoTemLivroEmprestado()) {
                        usuarios.remove(escolhaUsuarioConvertido);
                        System.out.println("Usuário removido!" + "\n");
                    } else {
                        System.out.println("O usuário não pôde ser removido, pois está com um empréstimo em aberto!");
                    }
                }

                // Voltar
                else if (opcaoParaUsuario.equals("0")) {
                }
            }

            // Opções do Livro
            else if (opcao.equals("2")) {
                String opcaoParaLivro = JOptionPane.showInputDialog(
                        "Escolha uma das opções abaixo:\n 1 - Cadastrar Livros\n 2 - Listar Livros\n 3 - Alterar Livros\n 4 - Remover Livros\n 0 - Voltar");

                // Cadastrar Livros
                if (opcaoParaLivro.equals("1")) {
                    String titulo = JOptionPane.showInputDialog("Informe o título do livro:");
                    String autor = JOptionPane.showInputDialog("Informe o autor do livro:");
                    String tituloDaArea = JOptionPane.showInputDialog("Informe o título da área de conhecimento:");
                    String descricao = JOptionPane.showInputDialog("Informe a descrição da área de conhecimento:");
                    AreaConhecimento areaConhecimento = new AreaConhecimento(tituloDaArea, descricao);

                    // Data de Publicacão
                    String ano = JOptionPane.showInputDialog("Informe o ano de publicação do livro:");
                    int anoConvertido = Integer.parseInt(ano);
                    String mes = JOptionPane.showInputDialog("Informe o mês de publicação do livro:");
                    int mesConvertido = Integer.parseInt(mes);
                    String dia = JOptionPane.showInputDialog("Informe o dia de publicação do livro:");
                    int diaConvertido = Integer.parseInt(dia);
                    String qtdDeCopias = JOptionPane.showInputDialog("Informe a quantidade de cópias do livro:");
                    int qtdDeCopiasConvertido = Integer.parseInt(qtdDeCopias);

                    Livro livro = new Livro(titulo, autor, areaConhecimento, qtdDeCopiasConvertido,
                            LocalDate.of(anoConvertido, mesConvertido, diaConvertido));
                    livros.add(livro);
                }

                // Listar Livros
                else if (opcaoParaLivro.equals("2")) {
                    for (Livro livro : livros) {
                        System.out.println("Título: " + livro.getTitulo() + "\nAutor: " + livro.getAutor()
                                + "\nData de publicação: " + livro.getDataDePublicacao() + "\nQuantidade de acervos: "
                                + livro.getQtdDeCopias() + "\n");
                    }
                }

                // Alterar Livro
                else if (opcaoParaLivro.equals("3")) {
                    String buscarTitulo = JOptionPane.showInputDialog("Digite o título do livro que deseja alterar:");

                    boolean naoAchouTitulo = false;

                    for (Livro livro : livros) {
                        String titulo = livro.getTitulo();
                        if (titulo.equals(buscarTitulo)) {
                            String escolhaObjetoParaAlterar = JOptionPane.showInputDialog(
                                    "Escolha o que você deseja alterar:\n 1 - Título\n 2 - Autor\n 3 - Quantidade de cópias\n 4 - Área de conhecimento\n 5 - Data de publicação\n 0 - Voltar");

                            naoAchouTitulo = false;

                            // Alterar Título
                            if (escolhaObjetoParaAlterar.equals("1")) {
                                titulo = JOptionPane.showInputDialog("Informe o novo título:");
                                livro.setTitulo(titulo);

                            }

                            // Alterar Autor
                            if (escolhaObjetoParaAlterar.equals("2")) {
                                String autor = JOptionPane.showInputDialog("Informe o novo autor:");
                                livro.setAutor(autor);
                            }

                            // Alterar Quantidade de Cópias
                            if (escolhaObjetoParaAlterar.equals("3")) {
                                String qtdDeCopias = JOptionPane.showInputDialog("Informe quantidade atual de cópias:");
                                int qtdDeCopiasConvertido = Integer.parseInt(qtdDeCopias);
                                livro.setQtdDeCopias(qtdDeCopiasConvertido);
                            }

                            // Alterar Área de Conhecimento
                            if (escolhaObjetoParaAlterar.equals("4")) {

                                String escolhaTituloDescricao = JOptionPane.showInputDialog(
                                        "Escolha o que você deseja alterar:\n 1 - Título da área de conhecimento\n 2 - Descrição da área de conhecimento");

                                // Alterar Título da Área de Conhecimento
                                if (escolhaTituloDescricao.equals("1")) {
                                    String tituloDaArea = JOptionPane
                                            .showInputDialog("Informe o novo título da área de conhecimento:");
                                    livro.setTituloAreaConhecimento(tituloDaArea);
                                }

                                // Alterar Descrição da Área de Conhecimento
                                else if (escolhaTituloDescricao.equals("2")) {
                                    String descricaoDaArea = JOptionPane
                                            .showInputDialog("Informe a nova descrição da área de conhecimento:");
                                    livro.setDescricaoAreaConhecimento(descricaoDaArea);
                                }
                            }

                            // Alterar Data de Publicação
                            if (escolhaObjetoParaAlterar.equals("5")) {
                                String ano = JOptionPane.showInputDialog("Informe o ano de publicação do livro:");
                                int anoConvertido = Integer.parseInt(ano);
                                String mes = JOptionPane.showInputDialog("Informe o mês de publicação do livro:");
                                int mesConvertido = Integer.parseInt(mes);
                                String dia = JOptionPane.showInputDialog("Informe o dia de publicação do livro:");
                                int diaConvertido = Integer.parseInt(dia);
                                livro.setDataDePublicacao(LocalDate.of(anoConvertido, mesConvertido, diaConvertido));
                            }

                            // Voltar
                            if (escolhaObjetoParaAlterar.equals("0")) {
                            }

                        }

                    }

                    // Título não encontrado
                    if (naoAchouTitulo) {
                        System.out.println("Livro não encontrado!\nVerifique se digitou o título corretamente!\n");
                    }
                }

                // Remover Livros
                else if (opcaoParaLivro.equals("4")) {
                    int cont = 0;
                    for (Livro livro : livros) {
                        System.out.println(cont + "Título: " + livro.getTitulo() + "Autor: " + livro.getAutor()
                                + "Data de publicação: " + livro.getDataDePublicacao() + "Quantidade de acervos: "
                                + livro.getQtdDeCopias() + "\n");
                        cont += 1;
                    }
                    String escolhaLivro = JOptionPane
                            .showInputDialog("Informe a posição (número na lista) do livro que deseja remover:");
                    int escolhaLivroConvertido = Integer.parseInt(escolhaLivro);

                    List<String> nomesDosUsuariosQPegaramOLivro = new ArrayList<>();
                    boolean livroEmprestado = false;
                    for (Emprestimo emprestimo : emprestimos) {
                        if (livros.get(escolhaLivroConvertido).equals(emprestimo.getLivro())) {
                            nomesDosUsuariosQPegaramOLivro.add(emprestimo.getUsuario().getNome());
                            livroEmprestado = true;
                        }
                    }
                    if (livroEmprestado) {
                        System.out
                                .println(
                                        "Impossível remover Livro!\nExistem cópias emprestadas para o(s) usuário(s): \n"
                                                + nomesDosUsuariosQPegaramOLivro);
                    } else {
                        livros.remove(escolhaLivroConvertido);
                        System.out.println("Livro removido!");
                    }
                }

                else if (opcaoParaLivro.equals("0")) {
                }
            }

            // Opções do Empréstimo
            else if (opcao.equals("3")) {
                String opcaoParaEmprestimo = JOptionPane.showInputDialog(
                        "Escolha uma das opções abaixo:\n 1 - Fazer empréstimo de livros\n 2 - Listar empréstimos\n 3 - Devolver livros\n 0 - Voltar");

                // Fazer empréstimo de livro
                if (opcaoParaEmprestimo.equals("1")) {

                    // Usuário
                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println(i + usuarios.get(i).getNome());
                    }
                    String escolhaUsuario = JOptionPane
                            .showInputDialog("Informe a posição do usuário para qual deseja empréstimo:");
                    int escolhaUsuarioConvertido = Integer.parseInt(escolhaUsuario);
                    Usuario usuario = usuarios.get(escolhaUsuarioConvertido);

                    // Livro
                    for (int i = 0; i < livros.size(); i++) {
                        System.out.println(i + livros.get(i).getTitulo() + "Autor: " + livros.get(i).getAutor());
                    }
                    String escolhaLivro = JOptionPane
                            .showInputDialog("Informe a posição do livro deseja pegar emprestado:");
                    int escolhaLivroConvertido = Integer.parseInt(escolhaLivro);
                    Livro livro = livros.get(escolhaLivroConvertido);

                    // Data de nascimento
                    String ano = JOptionPane.showInputDialog("Informe o ano do empréstimo:");
                    int anoConvertido = Integer.parseInt(ano);
                    String mes = JOptionPane.showInputDialog("Informe o mês do empréstimo:");
                    int mesConvertido = Integer.parseInt(mes);
                    String dia = JOptionPane.showInputDialog("Informe o dia do empréstimo:");
                    int diaConvertido = Integer.parseInt(dia);

                    Emprestimo emprestimo = new Emprestimo(usuario, livro,
                            LocalDate.of(anoConvertido, mesConvertido, diaConvertido));
                    emprestimos.add(emprestimo);
                }

                // Listar Empréstimos
                else if (opcaoParaEmprestimo.equals("2")) {
                    for (int i = 0; i < emprestimos.size(); i++) {
                        System.out.println(i + emprestimos.get(i).getUsuario().getNome() + " pegou o livro "
                                + emprestimos.get(i).getLivro().getTitulo() + " na data: "
                                + emprestimos.get(i).getData());
                    }
                }

                // Devolver Livro
                else if (opcaoParaEmprestimo.equals("3")) {
                    for (int i = 0; i < emprestimos.size(); i++) {
                        System.out.println(i + emprestimos.get(i).getUsuario().getNome() + " pegou o livro "
                                + emprestimos.get(i).getLivro().getTitulo() + " na data: "
                                + emprestimos.get(i).getData());
                    }
                    String escolhaEmprestimo = JOptionPane.showInputDialog("Qual desses é seu empréstimo?");
                    int escolhaEmprestimoConvertido = Integer.parseInt(escolhaEmprestimo);

                    Usuario usuario = emprestimos.get(escolhaEmprestimoConvertido).getUsuario();
                    Livro livro = emprestimos.get(escolhaEmprestimoConvertido).getLivro();
                    Emprestimo emprestimo = emprestimos.get(escolhaEmprestimoConvertido);
                    emprestimo.devolver(usuario, livro);

                    emprestimos.remove(escolhaEmprestimoConvertido);
                }

                if (opcaoParaEmprestimo.equals("0")) {
                }
            }

            // Sair
            else if (opcao.equals("0")) {
                break;
            }
        }
    }
}
