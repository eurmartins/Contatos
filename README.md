# API Rest para Controle de Contatos

## Descrição do Projeto(Teste Minsait)

Este projeto é uma API Rest desenvolvida em Java com Spring Boot para gerenciar um sistema de cadastro de Pessoas e seus respectivos Contatos. Cada Pessoa pode ter vários Contatos, e a API permite realizar operações CRUD para ambas as entidades.

## Tecnologias Utilizadas

- **Java** (21 JDK)
- **Spring Boot** (Framework Java)
- **JPA/Hibernate** (Persistência de Dados).
- **Mockito**(Testes Unitários).
- **Database H2** (Banco de Dados em Memória).
- **OpenAPI (Swagger)** (Documentação da API).
- **Postman** (Requisições usando JSON).

### 1. Executar a API

```sh
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`

### 2. Arquivo application.properties

Esse arquivo é responsável pela configuração do banco de dados em memória(h2) e a OpenAPI(Swagger).

```
spring.application.name=Contacts
spring.datasource.url=jdbc:h2:mem:banco
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.datasource.username=sa
spring.datasource.password=12345
spring.h2.console.path=/h2
spring.h2.console.enabled=true
spring.jpa.defer-datasource-initialization=true

springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true

management.endpoints.web.exposure.include=*
```

## 3. Documentação da API

A documentação gerada pelo Swagger pode ser acessada em:

```
http://localhost:8080/swagger-ui/index.html#/
```

## 4. Endpoints Disponíveis

### 4.1 Pessoa:

- **POST** `http://localhost:8080/api/pessoa/criar` - Criar uma nova Pessoa
- **GET** `http://localhost:8080/api/pessoa/procurarPorId/{id}` - Obter Pessoa por ID
- **GET** `http://localhost:8080/api/pessoa/malaDireta/{id}` - Obter Pessoa para mala direta
- **GET** `http://localhost:8080/api/pessoa/listar` - Listar todas as Pessoas
- **PUT** `http://localhost:8080/api/pessoa/atualizar/{id}` - Atualizar Pessoa
- **DELETE** `http://localhost:8080/api/pessoa/excluir/{id}` - Remover Pessoa

### 4.2 Contato:

- **POST** `http://localhost:8080/api/contatos/criar` - Adicionar um novo Contato a uma Pessoa
- **GET** `http://localhost:8080/api/contatos/obterContatoPorId/{id}` - Obter Contato por ID
- **GET** `http://localhost:8080/api/contatos/pessoa/{id}` - Listar todos os Contatos de uma Pessoa
- **PUT** `http://localhost:8080/api/contatos/atualizar/{id}` - Atualizar Contato
- **DELETE** `http://localhost:8080/api/contatos/excluir/{id}` - Remover Contato

## 5. Request Import

Link com todos os request dessa aplicação diretamente do Postman:

[Requests_Postman](https://drive.google.com/file/d/1pVsBepPiNBKYqun_gAcOBQUAwnd7f27k/view?usp=sharing)

## 6. Testes Unitários

Instruções para rodar os testes abaixo:

#### Entrar na pasta do projeto.

```
cd Contacts
```

#### Rodar todos os testes

```
mvn test
```

#### Rodar teste específico de um service.

```
mvn -Dtest=<Nome-da-classe-test> test
```

#### Rodar um método específico de um classe test.

```
mvn -Dtest=<Nome-da-classe-test>#<Nome-do-método-test> test
```

# contatos

Linkedin: [Victor Martins](https://www.linkedin.com/in/victormartinssantos/)

Email Profissional: victormartinssantos.work@gmail.com
