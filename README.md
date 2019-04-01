# **Easy Estacionamentos**
**Aluno:** André Luiz de Oliveira Cezário

## **Projeto original**
### **Como executar**
- Clone o repositório
- Abra o Eclipse
- Importe o projeto
- Abra e execute-o

## **Projeto refatorado**
### **Como executar**
- Clone o repositório
- Abra o Eclipse
- Importe o projeto
- Abra e execute-o

## **Padrões**

**1 - Adapter:** Converter a interface de uma classe em outra interface, esperada pelo cliente. O Adapter permite que interfaces incompatíveis trabalhem em conjunto – o que, de outra forma, seria impossível.

**2 - Factory Method:** Definir uma interface para criar um objeto, mas deixar as subclasses decidirem que classe instanciar. O Factory Method permite adiar a instanciação para subclasses.


## **Classes e Métodos afetados**
Ao utilizar o padrão de projeto Adapter foram alteradas as classes Fachada e a interface IFachada para inserção de chamadas a algumas execeções do sistema original. Nesse caso, foi inserido uma interface cadastro, visto que o cadastro para funcionário, cliente e veículo tinha operações de CRUD com comportamento semelhantes, logo poderia ser criado um Adapter para facilitar as chamadas e instanciação na Fachada. Na figura abaixo podem ser vistas as classes de cadastro e métodos de *cadastrar*, *remover*, *atualizar*, *buscar* e *listar* no projeto original.

![Classes afetadas](https://i.ibb.co/bR76wsV/Apresenta-o-Refatoramento-P3.png)

Implementando o Adapter foram criadas a interface cadastro e as classe CadastroClienteAdapter, CadastroFuncionarioAdapter e CadastroVeiculoAdapter implementando os métodos *cadastrar*, *remover*, *atualizar*, *buscar* e *listar* da interface de acordo com os métodos de suas respectivas superclasses. Conforme o diagrama de classes abaixo:

![Classes refatoramento adapter](https://i.ibb.co/dKs9FDy/Untitled-Diagram-4.png)

Como agora o cadastro de veículo, funcionário e cliente compartilham a mesma interface de cadastro, então o padrão de projeto Factory Method pode ser aplicado para facilitar a criação de objetos dos três tipos de cadastro. Para tal, foi criada uma classe Fatory com o método *criarCadastro* que recebe uma String com tipo de cadastro "veiculo", "funcionario" ou "cliente" e instancia o objeto com o tipo de cadastro apropriado. As alterações podem ser vistas na classe fachada, onde a instanciação dos objetos referentes ao cadastro de cliente, veículo e funcionário foram facilitadas. Como pode ser visto abaixo:

![Classes refatoramento factory method](https://i.ibb.co/nR3zgBn/Apresenta-o-Refatoramento-P3-1.png)

Por fim, o diagrama de classes abaixo mostra as classes criadas e os relacionamento com as do projeto original implementando os padrões de projeto Method Factory e Adapter.

![Classes refatoramento completo](https://i.ibb.co/fqX3RQ6/Untitled-Diagram-5.png)

## **Funcionalidades afetadas**

Basicamente as operações de cadastro de clientes, funcionários e veículo do sistema de estacionamento, nos operaçes cadastro, remoção, atualização, busca e listagem.
