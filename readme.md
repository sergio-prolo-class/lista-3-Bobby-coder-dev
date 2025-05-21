[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/DaO0-MBc)

# Gerenciador de Login 
Este projeto é uma aplicação Java de linha de comando para gerenciamento simples de usuários, permitindo cadastrar,
remover, listar e autenticar logins. Tudo com o uso de estruturas

## Funcionalidades

- **Cadastrar usuário** Permite adicionar um novo usuário com login e senha (não permite logins duplicados).

- **Remover usuário** Remove um usuário existente pelo login.

- **Listar usuários** Mostra todos os logins cadastrados.

- **Autenticar usuário** Verifica se o login e senha informados estão corretos.

- **Sair** Encerra o programa.

## Esturturas de dados usadas

- Estruturas utilizadas: `Queue`, `HashMap`, `ArrayList`, `LinkedList`

## Como Executar

1. coloque no bloco application de build.gradle -> mainClass = 'ifsc.poo.atendimento.Main'
2. execute a build projeto com gradle
   ```bash
   ./gradlew build
3. rode o projeto com gradle
   ```bash
   ./gradlew run

### Diagrama em Mermaid (código)
```mermaid
    classDiagram
    class GerenciadorLogin {
	-Usuarios: Map
        +cadastrar(login, senha): boolean
        +remover(login): boolean
        +listar(): List~String~
        +autenticar(login, senha): boolean
    }
    class Main {    
    }

    Main ..> GerenciadorLogin
```
### Visualização
![Diagrama UML](docs/diagrama-uml.png)
---

# Fila de Atendimento

Este projeto simula um sistema de atendimento para uma empresa, organizando clientes conforme a ordem de chegada das solicitações.

## Funcionalidades

- **Registrar Solicitação**
 Registrar solicitações vinculadas a um cliente.
- **Listar Telefones**
Listar todos os telefones de clientes registrados.
- **Próximo Cliente**
 Ver o próximo cliente da fila.
- **Atender CLiente**
 Atender clientes (remover da fila).
- **Clientes Atendidos**
Listar nomes dos clientes atendidos.
- **Telefones em espera**
Listar telefones dos clientes ainda em espera.
- **Relatório**
Gerar um relatório estatístico completo.
- **Sair**
 Encerra o programa.

## Esturturas de dados usadas

- Estruturas utilizadas: `Queue`, `HashMap`, `ArrayList`, `LinkedList`, `Scanner`

## Como Executar

1. coloque no bloco application de build.gradle -> mainClass = 'ifsc.poo.atendimento.Main'
2. execute a build projeto com gradle
   ```bash
   ./gradlew build
3. rode o projeto com gradle
   ```bash
   ./gradlew run

### Diagrama em Mermaid (código)
```mermaid
classDiagram
direction LR
    class FilaAtendimento {
        - solicitacoes: Queue
        - clientes: Map
        - atendidas: List
        + registrarSolicitacao()
        + listarTelefones()
        + proximoCliente()
        + atenderSolicitacao()
        + listarAtendidos()
        + listarTelefonesEmEspera()
        + gerarRelatorio()
    }

    class Solicitacao {
        - cliente: Cliente
        - descricao: String
        - categoria: String
        + getCliente()
        + getDescricao()
        + getCategoria()
    }

    class Cliente {
        - nome: String
        - telefone: String
        + getNome()
        + getTelefone()
    }
    class Main {
    }

    FilaAtendimento o-- Solicitacao
    Solicitacao --> Cliente
    Main ..> FilaAtendimento 
```

### Visualização
![Diagrama UML](docs/diagrama-uml.png)

---

# Biblioteca

Este projeto é uma aplicação de linha de comando para gerenciamento de uma 
biblioteca, desenvolvida em Java. Permite cadastrar autores, leitores
(com ID único), livros (com múltiplos autores e cópias), e registrar empréstimos.
Também possibilita listar livro, autores e leitores por determinados critérios.

## Funcionalidades

- **Cadastrar Autor**  
  Armazena nome e idioma nativo do autor.
- **Cadastrar Leitor**  
  Armazena nome, endereço, telefone e gera um ID único automaticamente.
- **Cadastrar Livro**  
  Cada livro tem título, código ISBN, pode ter múltiplos autores e várias cópias disponíveis.
- **Registrar Empréstimo**  
  Associa um leitor e um livro a uma data de empréstimo, respeitando regras de disponibilidade de livros e limite de livros por leitor.
- **Listagens e Consultas**
    - Autores (ordenado por nome)
    - Leitores (por nome ou ID)
    - Livros (por título ou ISBN)
    - Empréstimos (por data ou por leitor)

## Como executar

1. Coloque todos os arquivos `.java` no diretório `ifsc/poo/biblioteca`.
2. execute a build projeto com gradle
   ```bash
   ./gradlew build
3. rode o projeto com gradle
   ```bash
   ./gradlew run

## Exemplo de uso

```
Escolha uma opção: 
1. Cadastrar Autor 
2. Cadastrar Leitor 
3. Cadastrar Livro 
4. Registrar Empréstimo 
...
```
```mermaid
    classDiagram
direction LR
    class Main {
    }

    class Biblioteca {
	    - emprestimos : List~Emprestimo~
	    - autores : List~Autor~
	    - leitores : List~Leitor~
	    - livros : Map~Livro, Integer~
	    - id : int
	    + cadastraAutor(nome, idioma)
	    + getAutores()
	    + cadastraLeitor(nome, endereco, telefone)
	    + cadastraLivro(titulo, codISBN, autores, quantidade)
	    + registrarEmprestimo(nomeLeitor, nomeLivro, data)
	    + listarAutores()
	    + listarLeitoresNome()
	    + listarLeitoresId()
	    + listarLivrosTitulo()
	    + listarLivrosIsbn()
	    + listarEmprestimosData()
	    + listarEmprestimosEspecifico(nome)
    }

    class Autor {
	    - nome : String
	    - idioma : String
	    + getNome()
	    + getIdioma()
    }

    class Leitor {
	    - nome : String
	    - endereco : String
	    - telefone : String
	    - id : int
	    - LivrosEmprestados : List~Livro~
	    + aquisitarLivro(livro)
	    + getNome()
	    + getEndereco()
	    + getTelefone()
	    + getId()
	    + getQuantidadeLivros()
	    + temLivro(livro)
    }

    class Livro {
	    - titulo : String
	    - codISBN : String
	    - autores : List~Autor~
	    + getTitulo()
	    + getCodISBN()
    }

    class Emprestimo {
	    - leitor : Leitor
	    - livro : Livro
	    - data : String
	    + getLeitor()
	    + getLivro()
	    + getData()
    }

    Main ..> Biblioteca
    Biblioteca "1" o-- "*" Autor
    Biblioteca "1" o-- "*" Leitor
    Biblioteca "1" *-- "*" Livro
    Biblioteca "1" *-- "*" Emprestimo
    Livro "*" o-- "*" Autor
    Leitor "1" o-- "*" Livro
    Leitor "1" o-- "*" Emprestimo
    Emprestimo "*" --> "1" Livro
```

### Visualização
![Diagrama UML](docs/diagrama-uml.png)
