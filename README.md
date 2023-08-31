# Projeto FullStack - Pontos Turísticos
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/LICENSE) 

# Sobre o projeto

API de Pontos Turísticos é uma aplicação full stack web criado com o objetivo de conseguir fazer CRUD - criar, ler, atualizar e apagar os seguintes objetos países, pontos turísticos e comentários.

## ⚙️ Funcionalidades

- [x] CRUD de países;
- [x] CRUD de pontos turísticos;
- [x] CRUD de comentários;

---

## 🎨 Layout página de países

#### ✅ CREATE - Cadastrar um país.
![Web 1](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Layout-POST-de-pa%C3%ADs.PNG)

#### 🔎 READ - Ler uma lista de países.
![Web 2](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Layout-GET-de-pais.PNG)

#### 🔄 UPDATE - Atualizar um país.
![Web 3](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Layout-PUT-de-pa%C3%ADs.PNG)

#### ❌ DELETE - Apagar um país.
![Web 3](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Layout-DELETE-de-pa%C3%ADs.PNG)

---

## 🎨 Layout página de pontos turísticos

#### ✅ CREATE - Cadastrar um ponto turístico.
![Web 1](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Layout-POST-ponto-tur%C3%ADstico.PNG)

#### 🔎 READ - Ler uma lista de pontos turísticos.
![Web 2](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Layout-GET-de-ponto-tur%C3%ADstico.PNG)

#### 🔄 UPDATE - Atualizar um ponto turístico.
![Web 3](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Layout-PUT-de-ponto-tur%C3%ADstico.PNG)

#### ❌ DELETE - Apagar um ponto turístico.
![Web 3](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Layout-DELETE-de-ponto-turistico.PNG)

---

## 📄 Documentação

Para acessar o Swagger UI click nesse link: 👉🏼 **[Swagger UI](http://localhost:8080/swagger-ui/index.html)**

---

## 🎨 Layout página do Swagger UI

![Web 1](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Tela-swagger-01.png)
![Web 2](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Tela-swagger-02.png)
![Web 3](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Tela-swagger-03.png)
![Web 4](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Tela-swagger-04.png)
![Web 5](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Tela-swagger-05.png)
![Web 6](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Tela-swagger-06.png)

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

#### 01. Passo abrir o intellij IDEA e clicar em File na aba superior a esquerda.
![Web 1](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Abrindo-o-projeto-no-intellij.png)
#### 02. Passo procurar aonde salvo o projeto que fez o clone no diretório do HD da sua máquina.
![Web 2](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Buscando-a-pasta-aonde-o-projeto-foi-alocado.png)
#### 03. Passo abrir a arvore de estrutura do projeto clicando na seta em cima da pasta Desafio-FullStack-Java para expandir para baixo 👇 e vai abrindo as pastas conforme mostra a imagem abaixo até chegar na pasta java e achar a classe principal chamada BackendApplication clicar com botao direito e apertar em Run 'BackendAplicca....(main)'.
![Web 2](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Rodando-aplicacao-do-back-end.png)

---

## Front end web
Pré-requisitos: npm / yarn

#### 01. Passo apertar na aba inferior a esquerda chamada terminal.
![Web 1](https://github.com/RobsonCoura/Desafio-FullStack-Java/blob/main/assets/Rodando-aplicacao-front-end.png)

```bash

# entrar na pasta do projeto front end web
cd frontend

# instalar dependências
npm install

# executar o projeto
npm run start
```

---
# Autor ©

Robson Coura

https://www.linkedin.com/in/robsoncoura/
