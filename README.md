
# Loja do Seu Manoel

### Descrição do Projeto
Este projeto é uma API Web desenvolvida em Java com Spring Boot para automatizar o processo de embalagem de pedidos em uma loja de jogos online. A API recebe uma lista de pedidos com produtos e suas dimensões, e retorna a melhor forma de embalar os produtos em caixas de papelão disponíveis.

Funcionalidades
- Recebe uma lista de pedidos com produtos e suas dimensões
- Calcula a melhor forma de embalar os produtos em caixas de papelão disponíveis
- Retorna uma lista de caixas usadas e quais produtos foram colocados em cada caixa

Requisitos
- Java 17
- Spring Boot 3.x
- Docker

Como Executar o Projeto
1. Clone o repositório: git clone https://github.com/seu-usuario/LojaDoSeuManoel.git
2. Execute o comando abaixo para criar a imagem Docker
```bash
    docker build -t lojadosuemanuel .
```
3. Execute o comando abaixo para executar o aplicativo
```bash
    docker run -p 8080:8080 lojadosuemanuel
```

4. Acesse a API em http://localhost:8080/swagger-ui/index.html0

5. Exemplo de cUrl:
```bash
     curl -X POST   http://localhost:8080/api/loja/empacotar   -H 'Content-Type: application/json'   -d '{"pedidos": [{"pedidoId": 1, "produtos": [{"produtoId": "PS5", "dimensoes": {"altura": 40, "largura": 10, "comprimento": 25}}, {"produtoId": "Volante", "dimensoes": {"altura": 40, "largura": 30, "comprimento": 30}}]}]}'

```