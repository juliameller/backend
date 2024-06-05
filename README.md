# Exercícios de Backend

Este repositório contém uma coleção de exercícios desenvolvidos em Java para a disciplina de backend do curso de Engenharia de Software - SATC.


# Lista de Exercícios


## Exercício 01

Implemente um programa em java que seja capaz de gerar aleatoriamente e retornar no console o seguinte modelo de mensagem:

````
Cássio Ramos é um futebolista brasileiro de 32 anos que atua como goleiro. Atualmente defende o Corinthians.
````

A mensagem de texto deverá conter os seguintes atributos aleatórios:
* [Nome](https://venson.net.br/resources/data/nomes.txt) e [sobrenome](https://venson.net.br/resources/data/sobrenomes.txt) aleatórios
* Idade (entre 17 e 40 anos)
* [Posição](https://venson.net.br/resources/data/posicoes.txt) (aleatória)
* [Clube](https://venson.net.br/resources/data/clubes.txt) (aleatório)

---

## Exercício 02

Utilizando como base o exercício anterior, crie uma classe chamada `JogadorGerador` contendo um método capaz de realizar as requisições HTTP apenas uma vez e construir múltiplos objetos do tipo `Jogador`.

Crie também uma classe chamada `Jogador` contendo métodos que permitam que cada dado do jogador seja acessado individualmente através de métodos (`getNome`, `getSobrenome`, `getPosicao`, `getIdade`, `getClube`) e um método que gere a mensagem do exercício anterior (`getDescricao`).

---

## Exercício 3

Crie um novo projeto usando o Spring Framework que implemente um **service** chamado `OscarService` que seja responsável por adicionar filmes e atores à uma lista de indicados (array do tipo `Indicacao`). O service também deverá retornar a lista com todos os indicados e suas categorias;

Um ator ou filme não poderá ser indicado um atributo `elegivel` for falso. Para cada nova indicação, um atributo `numeroDeIndicacoes` deve ser incrementado. Ambos os atributos devem ser manipulado por meio de uma interface chamada `Indicavel`.

---

![bg fit](assets/exercicio03_class.svg)

---

![bg fit](assets/exercicio03_activity.svg)

---

Todos os atributos devem ter sua visibilidade `private`. Crie getters e setters para os atributos que necessitem de acesso/modificação.

O projeto deverá seguir a estrutura dos diagramas UML, porém alterações que incluam funcionalidades ou alterem o nome das classes são permitidas desde que mantenham o formato da implementação.

O projeto deverá conter pelo menos:

* 1x Service
* 1x Interface
* 3x Components


---

## Exercício 04

Crie um web service capaz de prover através de requisição GET uma mensagem como a do exercício 01 / exercício 02. Novas mensagens/jogadores devem ser geradas à cada requisição. O web service deverá carregar uma lista de [nomes](https://venson.net.br/resources/data/nomes.txt), [sobrenomes](https://venson.net.br/resources/data/sobrenomes.txt), [posições](https://venson.net.br/resources/data/posicoes.txt) e [clubes](https://venson.net.br/resources/data/clubes.txt) apenas durante sua inicialização.


---

## Exercício 05

Crie um documento (formatos ODX, DOC, DOCX ou MD) contendo a modelagem proposta pela Fase 2 da [Atividade da Aula 13](../aulas/aula13/aula13-atividade01.pdf). Esse documento deverá conter uma descrição da modelagem realizada, bem como todas as rotas/endpoints definidos pelo grupo.Para cada um dos recursos, deve ser especificado um conjunto de métodos necessários para realizar **operações CRUD**. Cada método deverá incluir: **URI**, **Método HTTP**, **Requisição esperada**, **Erros esperados** e **Status Codes**.


---

## Exercício 06

Utilizando os modelos do exercício anterior e da Fase 3 da [Atividade da Aula 13](../aulas/aula13/aula13-atividade01.pdf). Implemente um controlador de uma aplicação Spring que faça o mapeamento dos recursos desenvolvidos.

* O desenvolvimento deverá ser feito utilizando Spring Boot.
* Apenas um controller é necessário
* Não é necessário implementar services ou modelos. Cada rota pode retornar null ou um dado mockup (de exemplo e estático).


---

## Exercício 07

Crie uma REST API usando Spring Boot e adicione os seguintes modelos:

````java
public class Cliente {
  private String nome;
  private Double saldo;
  private String senha;
}
````

````java
public class Transacao {
  private String recebedor;
  private String pagador;
  private Double quantidade;
}
````

---

Crie dois endpoints para a API:

* `GET /cliente/{nome}` - retorna um cliente pelo nome, mas não mostra sua senha;
* `POST /transacao` - insere uma nova transação. O corpo da mensagem de ida deve conter o nome do `pagador` e do `recebedor`, como também a `quantidade` de dinheiro a ser debitada e creditada. A resposta deverá ser as mesmas informações enviadas em caso de sucesso.

Implemente todas as respostas usando DTOs e seus respectivos mappers. Adicione alguma validação a todos os atributos especificados nos DTOs.

> Dica: Utilize uma estrutura de Hashmap para armazenar os clientes e inicie alguns clientes no construtor do service.

---

## Exercício 08

Usando Hibernate Validation, adicione validações ao exercício anterior de modo que o toda transação enviada tenha um pagador, um recebedor e uma quantia maior do que 0. Adicione também mensagens para cada um dos atributos usando o atributo `message`.

---

## Exercício 09

Usando Spring Boot, Spring Data e um banco de dados à sua escolha, implemente um CRUD completo (*GetOne*, *GetAll*, *Create*, *Update* e *Delete*) para uma entidade à sua escolha.

Não esqueça de incluir ao menos um DTO de resposta e um DTO de requisição para a sua entidade.

O repositório deve implementar a busca da entidade por nome;

Não é necessário realizar a validação em nível de controlador.

---

## Exercício 10


Crie também um arquivo `README.md` na raiz com a descrição do repositório e um arquivo chamado `gitlab-ci.yml`.

Crie duas variáveis de CI/CD no seu projeto chamadas `STUDENT_ID` e `STUDENT_NAME`, com os valores do seu código de estudante e seu nome, respectivamente.

