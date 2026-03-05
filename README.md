### Forum Hub

API REST desenvolvida em Java com Spring Boot para gerenciamento de um fórum de perguntas e respostas.

Este projeto foi desenvolvido como parte do desafio Forum Hub da formação Back-End Java do programa Oracle Next Education (ONE) em parceria com a Alura, com o objetivo de aplicar conceitos de desenvolvimento backend, arquitetura de APIs e boas práticas de software.

### Objetivo do Projeto

O Forum Hub simula o funcionamento de um fórum de discussão, permitindo que usuários criem tópicos, respondam perguntas e interajam com conteúdos dentro da plataforma.

A aplicação expõe uma API RESTful que pode ser consumida por aplicações web ou mobile.

### Arquitetura
A aplicação segue uma arquitetura típica de APIs Java modernas utilizando:
- Controller → camada de exposição da API
- Service → regras de negócio
- Repository → acesso ao banco de dados
- Model / Entity → entidades persistidas
- DTOs → transferência de dados
- Security → autenticação e autorização

### Estrutura do Projeto
```
├── src/main/java
│   ├── controller
│   ├── service
│   ├── repository
│   ├── model
│   ├── dto
│   └── security
│
├── src/main/resources
│   ├── application.properties
│
└── pom.xml
```