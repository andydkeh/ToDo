<h1 align="center">
  TODO List
</h1>

API para gerenciar tarefas (CRUD)

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

- Criar Tarefa
```
[POST] :8080/create

[
    {
        "nome":"Projeto de toDo 1",
        "descricao": "Testando CRUD",
        "realizado": false,
        "prioridade": 5
    }
]
```

- Listar Tarefas
```
[GET] :8080/

[
	{
		"descricao": "Testando CRUD",
		"id": 1,
		"nome": "Projeto de toDo 1",
		"prioridade": 5,
		"realizado": false
	}
]
```

- Atualizar Tarefa
```
[PUT] :8080/update

[
	{
		"descricao": "Testando CRUD",
		"id": 1,
		"nome": "Projeto de toDo 1",
		"prioridade": 9,
		"realizado": false
	}
]
```

- Remover Tarefa
```
[DELETE] :8080/delete/1

[ ]
```