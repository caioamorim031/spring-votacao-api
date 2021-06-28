# spring-votacao-api

Este projeto foi desenvolvido com o intuito de realizar cadastro de Sessões de votação, abertura das mesmas, assim como cadastro de associados e o ato de votação.
Os serviços atualmente estão funcionando normalmente, porém com algumas poucas funcionalidades em falta, como consultar a tabela relacional de votos após a inserção.

O projeto foi desenvolvido utilizando a Spring Framework, seus módulos utilizados foram o Spring Boot e Spring JPA para persistência das informações.

**Setup para rodar a API localmente**


1. MySQL

Para este projeto utilizei o banco MySQL.


2. Configurações do Banco

Alterar o arquivo de configuração *application.properties* e alterar os acessos do banco nas linhas:

```
spring.datasource.username=root
spring.datasource.password=admin
```

3. IDE


Após clonar o projeto no seu workspace, importar o mesmo no Spring Tool Suite como Spring Boot App
