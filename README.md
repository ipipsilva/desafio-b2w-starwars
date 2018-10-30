# Desafio B2W

### Incluir planeta

Esse endpoint deverá receber as informações de nome, clima e terreno do planeta a ser adicionado.

* Endpoint: `localhost:8080/api/planetas/`
* HTTP Method: POST
* HTTP Success Response Code: CREATED (201)

### Listar todos os planetas

Esse endpoint deverá retornar todos os planetas presentes no banco de dados. Se não houver nenhum, deverá retornar HTTP NOT FOUND.

* Endpoint: `localhost:8080/api/planetas/`
* HTTP Method: GET
* HTTP Success Response Code: OK (200)
* HTTP Error Response Code: NOT FOUND (404)


### Obter um planeta por nome

Esse endpoint deverá retornar os planetas com o nome passado presentes no banco de dados. Se não houver nenhum, deverá retornar HTTP NOT FOUND.

* Endpoint: `localhost:8080/api/planetas/nome/{nome}`
* HTTP Method: GET
* HTTP Success Response Code: OK (200)
* HTTP Error Response Code: NOT FOUND (404)


### Obter um planeta por ID

Esse endpoint deverá retornar o planeta com o id passado presente no banco de dados. Se não houver nenhum, deverá retornar HTTP NOT FOUND.

* Endpoint: `localhost:8080/api/planetas/{id}`
* HTTP Method: GET
* HTTP Success Response Code: OK (200)
* HTTP Error Response Code: NOT FOUND (404)


### Remover um planeta

Esse endpoint deverá receber o id do planeta e removê-lo da base de dados. Se não houver nenhum, deverá retornar HTTP NOT FOUND.

* Endpoint: `localhost:8080/api/planetas/{id}`
* HTTP Method: DELETE
* HTTP Success Response Code: NO CONTENT (204)
* HTTP Error Response Code: NOT FOUND (404)