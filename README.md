
# 🛡️ Projeto Java com Spring Boot e JWT

## 📋 Descrição

Este projeto consiste em uma API RESTful desenvolvida com **Spring Boot**, que implementa **autenticação JWT** e **controle de acesso baseado em roles** (`admin` e `user`). A aplicação permite o cadastro e gerenciamento de usuários, com diferentes níveis de permissões conforme o tipo de usuário.

---

## 🚀 Funcionalidades

- ✅ Cadastro de usuários com nome, e-mail, senha e role
- ✅ Login com autenticação JWT
- ✅ Proteção de rotas com base em token JWT
- ✅ Controle de acesso baseado em role (`admin` e `user`)
- ✅ Usuário pode editar seu perfil
- ✅ Admin pode editar, visualizar e deletar qualquer usuário
- ✅ Documentação da API com Swagger

---

## 🔐 Regras de Acesso

| Role   | Acesso às funcionalidades                                           |
|--------|---------------------------------------------------------------------|
| `user` | Visualizar e editar seu próprio perfil                             |
| `admin`| Visualizar, editar e deletar qualquer usuário                      |
| Ambos  | Podem autenticar e acessar endpoints permitidos conforme seu papel |

---

## 🧰 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- Swagger (Springdoc OpenAPI)

---

## 🧪 Endpoints Principais

| Método | Rota                     | Acesso     | Descrição                                      |
|--------|--------------------------|------------|------------------------------------------------|
| POST   | `/auth/register`         | Público    | Registra um novo usuário                       |
| POST   | `/auth/login`            | Público    | Autentica usuário e retorna token JWT          |
| GET    | `/users/getCurrent`      | Autenticado| Retorna dados do usuário logado                |
| PUT    | `/users/edit`            | Autenticado| Atualiza os próprios dados                     |
| GET    | `/users`                 | Admin      | Lista todos os usuários                        |
| GET    | `/users/{id}`            | Admin      | Retorna um usuário por ID                      |
| PUT    | `/users/{id}`            | Admin      | Atualiza um usuário por ID                     |
| DELETE | `/users/{id}`            | Admin      | Deleta um usuário por ID                       |

---

## 📚 Documentação da API

Acesse a interface do Swagger para testar os endpoints:

```
http://localhost:8080/swagger-ui.html
```

---

## ⚙️ Como Executar o Projeto

### ✅ Pré-requisitos

- Java 17 ou superior
- Maven




## 📝 Exemplos de Request

### 🔐 Login

**POST /auth/login**

```json
{
  "login": "admin@email.com",
  "password": "123456"
}
```

Resposta:

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsIn..."
}
```

Use o token no header para endpoints protegidos:

```
Authorization: Bearer <token>
```

---

## 📁 Estrutura do Projeto

```
src
├── controller
│   └── AuthController.java, UserController.java
├── model
│   └── User.java, Role.java
├── repository
│   └── UserRepository.java
├── service
│   └── TokenService.java, UserService.java
├── config
│   └── SecurityConfig.java, SwaggerConfig.java
```

---

## 🧠 Boas Práticas

- Commits frequentes com mensagens claras
- Código limpo e organizado em camadas
- Validação com `@Validated` e tratamento de erros
- Uso de `@AuthenticationPrincipal` para capturar usuário logado

---

## 📌 Avaliação

| Critério        | Avaliado |
|-----------------|----------|
| Funcionalidades | ✅       |
| Qualidade do código | ✅  |
| Frequência dos commits | ✅ |
| README/documentação | ✅ |

---

## 📚 Referências

- [Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Security Docs](https://docs.spring.io/spring-security/reference/)
- [JWT - jsonwebtoken.io](https://jwt.io/)
- [Springdoc OpenAPI](https://springdoc.org/)

---

## 📎 Licença

Este projeto está sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

---

## 🙋‍♂️ Dúvidas?

Sinta-se à vontade para abrir uma *issue* ou enviar uma mensagem.
