# Correção

| Questão     | Legibilidade | Diagramas | P1 | P2 | P3 | Total |
|-------------|--------------|-----------|----|----|----|-------|
| Nota máxima | 10           | 10        | 20 | 25 | 35 | 100   |
| Nota        | 6            | 8         | 15 | 20 | 12 |       |

imagens quebradas. gitignore, talvez?

## Diagramas

- P1
  - GerenciadorLogin.Usuarios é mapa do quê, para quê?
  - dois pontos duplicados nos métodos
- P2
  - associações sem multiplicidade, métodos sem tipo de retorno
  - Queue, Map, List sem tipo
- P3
  - Por que agregação entre Biblioteca e Autor, e não composição? Também entre Biblioteca e Leitor? 
  - Métodos sem tipo de retorno
  - Leitor agrega Empréstimos, mas não tem um atributo que acessa esses objetos agregados?
  - Biblioteca tem um id? por quê?
  - Multiplicidades estranhas:
    - Leitor pode ter * empréstimos? Não no máximo 5?
    - Livro pode ter * autores? Não no mínimo 1?
    - Livro pode estar em * empréstimos? Não em exatamente 1?

## P1

- Apesar de funcional, o objetivo do exercício era treinar associação entre classes.
- SRP: A responsabilidade de representar um Usuário está misturada com a de gerenciar o sistema.

### Requisitos Funcionais
- [x] Cadastrar novos usuários
- [x] Remover usuários
- [x] Listar os logins
- [x] Autenticar usuários

## P2

- SoC: println dentro de FilaAtendimento, deveria estar em Main
- chave de FilaAtendimento.clientes é nome ou telefone? Pois:
  - FilaAtendimento.registrarSolicitação verifica se o conjunto de chaves de clientes contém o nome do cliente
  - mas depois insere o telefone como chave.
  - acho que seu sistema de registro está bugado.
- informação duplicada: chave de clientes (seja telefone ou nome) e Cliente.nome/telefone

### Requisitos Funcionais
- [ ] Registrar novas solicitações
- [x] Listar os telefones dos clientes registrados
- [x] Imprimir o nome do próximo cliente
- [x] Atender o próximo cliente
- [x] Listar os nomes dos clientes já atendidos
- [x] Listar os telefones dos clientes em espera
- [x] Gerar um relatório estatístico
- [x] ... total de solicitações registradas, atendidas, em espera
- [x] ... distribuição percentual das solicitações por categoria

## P3

- Uso abusivo de listas onde deveriam ser conjuntos
- SoC: Biblioteca usando println, o que deveria ser tarefa só do Main
- SRP: Biblioteca faz praticamente todas as tarefas, deverias delegar mais para as outras classes.
- Encapsulamento vazado:
  - Biblioteca.getAutores() retorna uma referência para o atributo autores.
  - Assim, qualquer outra classe pode alterar a coleção de autores.
- Requisitos com falhas:
  - Cadastros, por conta de ser em List
    - empréstimos, autores e leitores duplicados podem? a ordem deles, importa?
    - Sua solução: verificar se lista contém. não é uma boa solução:
    - if(!List.contains(obj)) só retorna false se o objeto com endereço de memória de obj estiver na lista
    - ou seja, dois objetos iguais podem ser inseridos na lista, desde que seu endereço de memória seja diferente
  - Registro de empréstimos
    - Sua solução busca o Leitor com base no nome. E se dois leitores tiverem o mesmo nome?
    - Mesma coisa com Livro. E se dois livros tiverem o mesmo nome?
    - Devias usar os identificadores (id, isbn)
  - Empréstimos do leitor
    - Mesmo problema de antes. Se dois leitores tem o mesmo nome, vai aparecer todos os empréstimos

### Requisitos Funcionais
- [ ] Cadastrar autores
- [ ] Cadastrar livros
- [ ] Cadastrar leitores
- [ ] Registrar empréstimos de livros para leitores
- [x] ... pelo menos uma cópia
- [ ] ... leitor não tenha esse livro
- [ ] ... leitor possua no máximo 5 livros emprestados
- [x] Listar autores em ordem alfabética
- [x] Listar leitores em ordem alfabética
- [x] Listar leitores por id
- [x] Listar livros por título
- [ ] Listar livros por autor
- [x] Listar livros por ISBN
- [x] Listar empréstimos por data
- [ ] Listar empréstimos de um leitor, por data