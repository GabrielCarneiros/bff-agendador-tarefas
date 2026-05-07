# BFF - Sistema de Gestão de Usuários e Agendamento de Tarefas

## Sobre o Projeto

Este projeto consiste em um Backend For Frontend (BFF) desenvolvido com Java e Spring Boot para gerenciamento de usuários, autenticação e agendamento de tarefas.

A aplicação foi construída utilizando arquitetura em camadas e integração entre serviços, simulando um ambiente backend utilizado em aplicações reais.

O sistema possui:

* Autenticação JWT
* Gerenciamento de usuários
* Gerenciamento de tarefas
* Comunicação entre serviços utilizando Feign Client
* Rotinas automatizadas com Cron Jobs
* Tratamento global de exceções
* Persistência de dados com PostgreSQL
* Segurança com Spring Security

---

# Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* PostgreSQL
* JWT
* Feign Client
* Maven
* Git/GitHub

---

# Arquitetura do Projeto

O projeto foi estruturado utilizando arquitetura em camadas:

```text
controller
business/service
repository
entity
DTO
security
client
config
infrastructure/exceptions
```

## Camadas

### Controller

Responsável por receber as requisições HTTP e retornar as respostas da API.

### Service / Business

Responsável pelas regras de negócio da aplicação.

### Repository

Responsável pela comunicação com o banco de dados utilizando JPA/Hibernate.

### DTO

Utilizado para transferência de dados entre as camadas.

### Security

Responsável pela autenticação e autorização utilizando JWT e Spring Security.

### Client

Responsável pela comunicação entre serviços utilizando Feign Client.

---

# Funcionalidades

## Autenticação

* Login com JWT
* Proteção de rotas
* Validação de token
* Criptografia de senha com BCrypt

## Usuários

* Cadastro de usuários
* Busca de usuários
* Atualização de usuários
* Remoção de usuários

## Tarefas

* Criação de tarefas
* Atualização de tarefas
* Gerenciamento de status
* Agendamento de tarefas

## Notificações

* Envio automatizado de notificações
* Processamento de tarefas agendadas

---

# Fluxo da Aplicação

## Login

```text
Usuário envia email e senha
↓
Spring Security valida credenciais
↓
JWT é gerado
↓
Token retorna ao usuário
```

## Requisições Protegidas

```text
Usuário envia token JWT
↓
Filtro de segurança intercepta requisição
↓
Token é validado
↓
Acesso liberado
```

## Comunicação Entre Serviços

```text
Serviço A
↓
Feign Client
↓
Serviço B
```

---

# Estrutura do Projeto

```text
src
 ┣ main
 ┃ ┣ java
 ┃ ┃ ┗ com
 ┃ ┃   ┗ ...
 ┃ ┗ resources
 ┣ test
pom.xml
```

---

# Configuração do Banco de Dados

Configure o arquivo:

```text
application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=postgres
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
```

---

# Como Executar o Projeto

## Pré-requisitos

* Java 17+
* Maven
* PostgreSQL

---

## Clonar Repositório

```bash
git clone https://github.com/seuusuario/seu-repositorio.git
```

---

## Entrar na Pasta

```bash
cd nome-do-projeto
```

---

## Instalar Dependências

```bash
mvn clean install
```

---

## Executar Projeto

```bash
mvn spring-boot:run
```

---

# Endpoints

## Autenticação

```http
POST /auth/login
```

## Usuários

```http
GET /usuarios
POST /usuarios
PUT /usuarios/{id}
DELETE /usuarios/{id}
```

## Tarefas

```http
GET /tarefas
POST /tarefas
PUT /tarefas/{id}
DELETE /tarefas/{id}
```

---

# Segurança

A aplicação utiliza:

* Spring Security
* JWT
* BCrypt Password Encoder
* Filtros de autenticação
* Proteção de rotas

---

# Objetivos do Projeto

Este projeto foi desenvolvido com o objetivo de:

* Praticar desenvolvimento backend com Java
* Aprender arquitetura em camadas
* Implementar autenticação JWT
* Trabalhar com integração entre serviços
* Utilizar banco de dados relacional
* Simular um ambiente backend corporativo

---

# Melhorias Futuras

* Testes unitários
* Documentação com Swagger/OpenAPI
* Deploy em nuvem
* Containerização com Docker
* CI/CD
* Observabilidade e logs

---

# Autor

Gabriel Carneiro

GitHub: https://github.com/GabrielCarneiros
LinkedIn: www.linkedin.com/in/gabriel-carneiro-ba1a05288
