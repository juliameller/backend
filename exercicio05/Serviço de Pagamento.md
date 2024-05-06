# Serviço: Sistema de Pagamento (ex.: Paypal)

Atividade desenvolvida para a disciplina de Back-End;

---

## Integrantes da Equipe:

- Bruno de Moraes Supriano;

- Julia Meller Mendes Silva;

- Gustavo Monteiro.

## Casos de Uso:

- Manipular dados de usuário;

- Manipular dados de pagamento.

## Recursos:

- Usuário;

- Pagamento.

---

## Endpoints: USUÁRIO

- ##### Criar usuário (POST)
  
  - URI: /usuarios
  
  - Método HTTP: `POST`
  
  - Requisição esperada: dados do usuário (nome, e-mail, senha, etc.)
    
    ```json5
    {
      "ID": "5572" 
      "nome": "fulano de tal"
      "email": "fulano@email.com"
      "login":  "Fulano de tal"
      "senha": "senha123"
      "contato": "+5548999543481"
      "CPF/CNPJ": "12743896415"
    }
    ```
  
  - Erros esperados:
    
    - 400 Bad Request: dados inválidos ou ausentes
    - 409 Conflict: usuário já existe
  
  - Status Codes:
    
    - 201 Created: usuário criado com sucesso
    - 400 Bad Request: solicitação inválida

- ##### Obter usuário (GET)
  
  - URI: /usuarios/{id}
  
  - Método HTTP: `GET`
  
  - Requisição esperada: Nome e e-mail do usuario
    
    ```json5
    {
      "ID": "5572" 
      "nome": "fulano de tal"
      "email": "fulano@email.com"
      "login":  "Fulano de tal"
      "senha": "senha123"
      "contato": "+5548999543481"
      "CPF/CNPJ": "12743896415"
    }
    ```
  
  - Erros esperados:
    
    - 404 Not Found: usuário não encontrado
  
  - Status Codes:
    
    - 200 OK: solicitação bem-sucedida
    - 404 Not Found: usuário não encontrado

- ##### Atualizar usuário (PUT ou PATCH)
  
  - URI: /usuarios/{id}
  
  - Método HTTP: `PUT ou PATCH`
  
  - Requisição esperada: Novos dados atualizados
    
    ```json5
    {
      "ID": "5572"
      "nome": "fulano de tal"
      "email": "novoemail@email.com"
      "login":  "Fulano de tal"
      "senha": "novasenha"
      "contato": "novotelefone"
      "CPF/CNPJ": "12743896415"
    }
    ```
  
  - Erros esperados:
    
    - 400 Bad Request: dados inválidos ou ausentes
    - 404 Not Found: usuário não encontrado
  
  - Status Codes:
    
    - 200 OK: usuário atualizado com sucesso
    - 400 Bad Request: solicitação inválida
    - 404 Not Found: usuário não encontrado

- ##### Excluir usuário (DELETE)
  
  - URI: /usuarios/{id}
  
  - Método HTTP: `DELETE`
  
  - Requisição esperada: Status do usuário deletado
    
    ```json5
     {
      "Id": 5572
       "usuario": "Deletado",
     }
    ```
  
  - Erros esperados:
    
    - 404 Not Found: usuário não encontrado
  
  - Status Codes:
    
    - 204 No Content: usuário excluído com sucesso
    - 404 Not Found: usuário não encontrado

---

### Endpoints: PAGAMENTO

- ##### Realizar pagamento (POST)
  
  - URI: /pagamentos
  
  - Método HTTP: `POST`
  
  - Requisição esperada: valor e método de pagamento
    
    ```json5
    {
      "valor": 50.0,
      "metodo_pagamento": "cartao_credito"
    }
    ```
  
  - Erros esperados:
  
  - - 400 Bad Request: dados inválidos ou ausentes
    - 402 Payment Required: pagamento não autorizado devido a saldo insuficiente
  
  - Status Codes:
    
    - 201 Created: pagamento realizado com sucesso
    - 400 Bad Request: solicitação inválida
    - 402 Payment Required: saldo insuficiente

- ##### Obter pagamento (GET)
  
  - URI: /pagamentos/{id}
  
  - Método HTTP: `GET`
  
  - Requisição esperada: Valor e método do pagamento
    
    ```json5
    {
      "ID": "5572",
      "valor": 50.0,
      "metodo_pagamento": "cartao_credito"
    }
    ```
  
  - Erros esperados:
    
    - 404 Not Found: pagamento não encontrado
  
  - Status Codes:
    
    - 200 OK: solicitação bem-sucedida
    - 404 Not Found: pagamento não encontrado

- ##### Cancelar pagamento (DELETE)
  
  - URI: /pagamentos/{id}
  
  - Método HTTP: `DELETE`
  
  - Requisição esperada: Status do pagamento, valor e metodo
    
    ```json5
    {
      "ID": "5572"
      "status": "Pagamento Cancelado"
      "valor": 80.0,
      "metodo_pagamento": "cartao_debito"
    }
    ```
  
  - Erros esperados:
    
    - 404 Not Found: pagamento não encontrado
  
  - Status Codes:
    
    - 204 No Content: pagamento cancelado com sucesso
    - 404 Not Found: pagamento não encontrado
