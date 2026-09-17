# Service Reservas App

API de reservas desenvolvida com Kotlin e Spring Boot, estruturada em camadas e orientada a casos de uso.

O projeto concentra operações relacionadas a clientes, hotéis, quartos e reservas, utilizando Spring Data JPA para persistência e endpoints REST para exposição das funcionalidades.

## Sobre o projeto

O objetivo do projeto é praticar o desenvolvimento de uma aplicação backend moderna com Kotlin, Spring Boot e separação clara de responsabilidades.

A estrutura utiliza conceitos próximos de arquitetura hexagonal/clean architecture, separando transporte HTTP, casos de uso, entidades, gateways, repositórios e mapeadores.

## Funcionalidades identificadas

- Cadastro de clientes
- Consulta de cliente por CPF
- Criação de reservas
- Operações relacionadas a hotéis
- Operações relacionadas a quartos
- Persistência com JPA
- Integração HTTP via REST
- Estrutura preparada para integração externa por gateway
- Documentação de API com OpenAPI

## Tecnologias utilizadas

### Linguagem e runtime

- Kotlin 1.9.25
- Java 21

### Frameworks e bibliotecas

- Spring Boot 3.5
- Spring Web
- Spring Data JPA
- Spring Validation
- Spring AOP
- Spring Quartz
- Spring Cloud OpenFeign
- Jackson Kotlin
- Springdoc OpenAPI
- MapStruct
- Micrometer
- Prometheus
- Logbook

### Banco de dados

- MySQL
- H2

### Qualidade e testes

- JUnit 5
- Kotlin Test
- ArchUnit
- Sonar Maven Plugin

### Build

- Maven
- Maven Wrapper
- OpenAPI Generator Maven Plugin

## Estrutura da aplicação

A aplicação é organizada em responsabilidades como:

```text
src/main/kotlin/com/company/service/reservas/app/
├── config/
├── datasources/
│   ├── gateway/
│   ├── mappers/
│   └── repository/
├── entities/
│   └── dto/
├── interactors/
└── transportlayers/
    └── http/
```

## Arquitetura

O fluxo principal segue uma estrutura semelhante a:

```text
HTTP / REST
    │
    ▼
Transport Layer
    │
    ▼
Use Case / Interactor
    │
    ▼
Repository / Gateway
    │
    ▼
JPA / Integrações externas
    │
    ▼
Banco de Dados / Serviços externos
```

### Transport Layer

Contém os controladores HTTP responsáveis por receber requests e devolver responses.

Exemplos:

- `ClienteApiImpl`
- `ReservaApiImpl`
- `HotelApiImpl`
- `RoomsApiImpl`

### Interactors

Representam os casos de uso da aplicação e concentram a lógica de negócio.

### Datasources

Implementam persistência, integrações e conversões entre objetos de domínio e entidades.

### Entities e DTOs

Representam os dados utilizados entre as diferentes camadas da aplicação.

## Endpoints identificados

### Clientes

```text
POST /v1/clientes/create
GET  /v1/clientes/{cpf}
```

### Reservas

```text
POST /v1/reserva/create
```

O projeto também possui controladores específicos para hotéis e quartos.

## OpenAPI

A geração de código da API está configurada através do OpenAPI Generator.

O arquivo de especificação esperado pelo Maven está em:

```text
src/main/resources/openapi.yaml
```

O projeto utiliza geração de interfaces Kotlin/Spring baseada nessa especificação.

## Observabilidade

O projeto possui dependências para monitoramento e observabilidade, incluindo:

- Micrometer
- Prometheus
- Logbook

Isso permite evoluir a aplicação com métricas e monitoramento de requisições HTTP.

## Como executar

### Pré-requisitos

- Java 21
- Maven ou Maven Wrapper
- Banco de dados compatível com a configuração do projeto

### 1. Clone o repositório

```bash
git clone https://github.com/diegobluz/service--reservas-app-kotlin-.git
cd service--reservas-app-kotlin-
```

### 2. Compile o projeto

Linux/macOS:

```bash
./mvnw clean install
```

Windows:

```powershell
mvnw.cmd clean install
```

### 3. Execute

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```powershell
mvnw.cmd spring-boot:run
```

## Conceitos praticados

- Kotlin no backend
- Spring Boot
- APIs REST
- Arquitetura em camadas
- Casos de uso / Interactors
- Separação entre domínio e infraestrutura
- Spring Data JPA
- Mapeamento entre DTOs e entidades
- OpenAPI
- OpenFeign
- Observabilidade
- Testes arquiteturais com ArchUnit
- Maven
- Git e GitHub

## Possíveis melhorias

- Adicionar exemplos completos de requests e responses
- Documentar todos os endpoints existentes
- Adicionar Docker e Docker Compose
- Incluir diagrama da arquitetura
- Ampliar testes unitários e de integração
- Documentar configuração dos bancos de dados
- Padronizar respostas de erro
- Adicionar autenticação e autorização
- Criar pipeline de CI/CD

## Autor

**Diego Luz**

Projeto desenvolvido para estudo e prática de Kotlin, Spring Boot, arquitetura de aplicações e desenvolvimento de APIs.
