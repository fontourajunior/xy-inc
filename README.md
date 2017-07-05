# xy-inc

Este projeto conta com uma aplicação REST com serviços de consulta e insert para uma entidade chamada **tb_points_interest**.

## 1. Requisitos e Configurações

Para executar o projeto é necessária a instalação das seguintes ferramentas:

    1. JDK 1.8
    3. Maven
    
O projeto utiliza um banco embarcado (H2) para desenvolvimento.
 
## 2. Executando o Projeto
 
Após baixar o projeto, para executá-lo é necessário rodar os seguintes comandos dentro da pasta raiz.

```sh
$ mvn clean install
$ mvn spring-boot:run
```

A aplicação conta com um servidor de aplicação embarcado.

## 3. Testando os serviços

Uma vez com a aplicação rodando é necessário apenas realizar a chamada dos serviços. A seguir são mostradas as chamadas e os respectivos resultados.

GET /points-interest - Lista todos os produtos

```sh
$ curl http://localhost:8080/api/points-interest
[
  {
    "id": 1,
    "name": "Lanchonete",
    "coordinatedX": 27,
    "coordinatedY": 12
  },
  {
    "id": 2,
    "name": "Posto",
    "coordinatedX": 31,
    "coordinatedY": 18
  },
  {
    "id": 3,
    "name": "Joalheria",
    "coordinatedX": 15,
    "coordinatedY": 12
  },
  {
    "id": 4,
    "name": "Floricultura",
    "coordinatedX": 19,
    "coordinatedY": 21
  },
  {
    "id": 5,
    "name": "Pub",
    "coordinatedX": 12,
    "coordinatedY": 8
  },
  {
    "id": 6,
    "name": "Supermercado",
    "coordinatedX": 23,
    "coordinatedY": 6
  },
  {
    "id": 7,
    "name": "Churrascaria",
    "coordinatedX": 28,
    "coordinatedY": 2
  }
]
```

GET api/points-interest/points-interest-proximity - Busca todos os pontos de interesse por proximidade

```sh
$ curl http://localhost:8080/api/points-interest/points-interest-proximity?coordinateReferenceX=20&coordinateReferenceY=10&distance=10
[
  "Lanchonete",
  "Joalheria",
  "Pub",
  "Supermercado"
]
```

POST api/points-interest/ - Cria um novo ponto de interesse

```sh
$ curl -H "Content-Type: application/json" -X POST -d '{"coordinatedX": 0, "coordinatedY": 0,"id": 0,"name": "string"}' http://localhost:8080/api/points-interest
  
```

## 4. Outros Recursos

Foi disponibilizada uma documentação dos serviços. Esta documentação é acessível na URL http://localhost:8080/swagger-ui.html

![Swagger](https://github.com/fontourajunior/xy-inc/readme_img.doc.img)

É possível acessar o banco embarcado pela a URL: http://localhost:8080/h2-console/

* JDBC URL: jdbc:h2:file:./target/h2db/xy-inc
* Username: root
* Password: 
