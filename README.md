# ToDo List API - Spring Boot

API REST para gerenciamento de tarefas, com autenticação via JWT. Desenvolvido em Java com Spring Boot.

## 🚀 Tecnologias

- Java 17
- Spring Boot
- Spring Security
- PostgreSQL
- JWT
- Maven

## 📚 Funcionalidades

- Registro e login de usuários
- CRUD de tarefas
- Filtro por prioridade e status
- Autenticação e autorização com JWT
- Validações e tratamento de erros

## 🔧 Como rodar o projeto

1. Clone o repositório:
```bash
git clone https://github.com/seuuser/todo-list-api-springboot.git
```

2. Crie um banco PostgreSQL e configure o `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/todolist
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
jwt.secret=sua_chave_secreta
```

3. Rode a aplicação:

```bash
./mvnw spring-boot:run
```

## 📬 Contato

Gabriel Soarde  
[LinkedIn](https://www.linkedin.com/in/gabriel-soarde-722172185/) • [Email](soarde96@gmail.com)
