# Projeto FullStack - Pontos Turísticos
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/LICENSE) 

# Sobre o projeto

API de Pontos Turísticos é uma aplicação full stack web criado com o objetivo de conseguir fazer CRUD - criar, ler, atualizar e apagar os seguintes objetos países, pontos turísticos e comentários.

## ⚙️ Funcionalidades

- [x] CRUD de países;
- [x] CRUD de pontos turísticos;
- [x] CRUD de comentários;

---

## 🎨 Layout CRUD de países

![Web 1](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/media/Teste-API-CRUD-Pais.gif)

---

## 🎨 Layout CRUD de pontos turísticos e comentários

![Web 1](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/media/Teste-API-CRUD-Ponto-Turistico-Comentarios.gif)

---

## 📄 Documentação

Para acessar o Swagger UI click nesse link: 👉🏼 **[Swagger UI](http://localhost:8080/swagger-ui/index.html)**

---

## 🎨 Layout da interface do Swagger UI

![Web 1](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/media/Interface-swagger-teste-documentacao.gif)

---

## 🛠 Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:

### Back-End
- **[Java 11](https://www.oracle.com/java)**
- **[Spring Boot](https://spring.io/projects/spring-boot)**
- **[Intellij IDEA](https://www.jetbrains.com/idea/)**
- **[Gradle](https://gradle.org/install/)**
- **[Apache Tomcat](https://tomcat.apache.org/)**

### Front end
- **[HTML / CSS / JavaScript](https://www.w3schools.com/w3css/w3css_downloads.asp)**
- **[TypeScript](https://www.typescriptlang.org/download)**
- **[PO-UI](https://po-ui.io/)**
- **[Angular](https://angular.io/)**

---

### 🎯 Regras de negócio:

Dentro dessas funcionalidades temos as seguintes necessidades:

1. Ao cadastrar o Ponto turistico desejo informar alem do País, a cidade, o nome do ponto turístico, qual a melhor estação para visita-la e desejo ver um resumo do Ponto turístico.

2. Cada ponto turistico poderá ter vários comentários. Cada comentário deverá mostrar o Nome do autor, o comentário e a data em que foi criado.

3. Se possível gostaria de visualizar a lista de comentários sempre que entrar em um ponto turístico e se não houver um comentário, que a pagina me convide a ser o primeiro a comentar sobre o lugar.

## ▶ Como executar o projeto

### Back end
Pré-requisitos: Java 11 / Intellij ou Eclipse

```bash
# clonar repositório
git clone [https://github.com/devsuperior/sds1-wmazoni](https://github.com/RobsonCoura/Desafio-FullStack-Java.git)

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw spring-boot:run
```
---
#### Rodando a aplicação no back-end.
![Web 1](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/media/Rodando-aplicacao-no-back-end.gif)

---

## Front end web
Pré-requisitos: npm / yarn

```bash

# entrar na pasta do projeto front end web
cd frontend

# instalar dependências
npm install

# executar o projeto
npm run start
```

#### Rodando a aplicação no front-end.
![Web 1](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/media/Rodando-aplicacao-no-front-end.gif)

---
# Autor ©

Robson Coura

https://www.linkedin.com/in/robsoncoura/
