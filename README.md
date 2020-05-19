# API de Pagamento

Treinamento API - Serviço de Pagamento.

## Requisitos Necessários

* Docker
* Java 11
* Maven

O comando abaixo é utilizado para subir uma imagem do postgres.
```bash
cd DIRETORIO/pagamento
docker-compose up
```

Após o container subir, será necessário executar o comando abaixo para executar o código fonte:
```bash
mvn spring-boot:run
```

Documentação dos serviços disponíveis em http://localhost:8080/swagger-ui.html