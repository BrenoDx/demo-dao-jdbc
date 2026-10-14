# Demo DAO JDBC

Projeto desenvolvido em Java do curso Nélio Alves da Udemy para demonstrar o acesso a banco de dados relacional utilizando JDBC (Java Database Connectivity) e o padrão DAO (Data Access Object).

## Tecnologias utilizadas

- Java
- JDBC
- MySQL
- Padrão DAO

## Estrutura do projeto

```text
demo-dao-jdbc/
├── src/
├── db.properties
├── .gitignore
└── README.md
```

## Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/BrenoDx/demo-dao-jdbc.git
cd demo-dao-jdbc
```

### 2. Configure o banco de dados

Execute script .db do repositório no banco de dados no MySQL conforme.

### 3. Configure a conexão

Edite o arquivo `db.properties` com as credenciais do seu MySQL:

```properties
user=SEU_USUARIO
password=SUA_SENHA
dburl=jdbc:mysql://localhost:3306/demojdbc
useSSL=false
```

Substitua os valores de exemplo pelas configurações do seu ambiente.

## Conceitos abordados

- Conexão com banco de dados usando JDBC.
- Execução de comandos SQL.
- Separação da camada de acesso a dados.
- Organização do código com o padrão DAO.

## Objetivo

Projeto de estudo voltado à prática de Java, JDBC, MySQL e padrões de projeto para persistência de dados.
