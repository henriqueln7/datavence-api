Para clonar o projeto:
```shell script
git clone https://github.com/henriqueln7/datavence-api.git
```

Após baixar o projeto, descompate na IDE de sua preferência e configure o arquivo application.properties da seguinte maneira:

```markdown
spring.datasource.url=jdbc:{link_para_o_seu_banco_de_dados}
spring.datasource.username={username}
spring.datasource.password={password}
spring.jpa.hibernate.ddl-auto=update (essa propriedade é para o próprio Hibernate atualizar o banco de dados)
```

Para iniciar o projeto na linha de comando: 
```shell script
mvn spring-boot:run
```
