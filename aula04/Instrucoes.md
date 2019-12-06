# Instruções



### Atividade 1



Desenvolver um programa que simula o sistema de Lista de Tarefas.

Esse programa **deve persistir os dados** em um Banco de Dados



1. Criar um projeto Java Padrão e dar o nome de `ListaDeTarefas`
2. Criar uma base de dados chamada `lista_de_tarefas` no MySQL.
3. Criar uma tabela com o nome `usuarios`, que terá as seguintes colunas:
   1. `id`: INT NOT NULL PRIMARY KEY AUTO_INCREMENT
   2. `email`: VARCHAR(45) NOT NULL
   3. `senha`: VARCHAR(15) NOT NULL
4. Criar uma tabela com o nome `tarefas`, que terá as seguintes colunas:
   1. `id`: INT NOT NULL PRIMARY KEY AUTO_INCREMENT
   2. `descricao`: VARCHAR(128) NOT NULL
   3. `finalizada`: BIT(1) NOT NULL (o tipo de dado BIT permite armazenar os valores `true` ou `false`)
   4. `id_usuario`: INT NOT NULL (essa coluna é uma chave estrangeira, utilizada para identificar de qual usuário é essa tarefa)
5. Criar uma classe `Usuario`, que terá `email`, `senha` e um `ArrayList<Tarefa>`, e seus respectivos métodos de atribuição e retorno.
6. Criar uma classe `Tarefa`, que terá `titulo` e `finalizada` (para indicar se a tarefa já foi feita ou não), e seus respectivos métodos de atribuição e retorno.
7. Usar laço de repetição e `ArrayList` para desenvolver o programa de Lista de Tarefas.
8. O programa terá **DOIS** menus:



#### Primeiro Menu (menu principal; Index)

O **primeiro menu** terá as seguintes opções:

1. Fazer cadastro: essa opção permitirá ao usuário realizar o cadastro no sistema; o programa exige o email e a senha do usuário para realizar o cadastro.
   - senha deve ter no mínimo 6 caracteres e no máximo 15
   - email deve ter um '@'
   
   O cadastro do usuário deve ser **persistido no banco de dados**.
2. Fazer login: essa opção permitirá um usuário já cadastrado logar no sistema, informando email e senha. 
   - Verificar se email e senha realmente conferem com algum usuário cadastrado
   - Se email/senha estiverem corretos, então o login foi feito com sucesso e, portanto, **o programa deve levar o usuário para o segundo menu**.
   - Se email/senha estiverem **incorretos**, então o login falhou e, portanto, o programa deve informar o usuário sobre o erro e levá-lo de volta ao menu principal.
   
   O processo de login deve **procurar o usuário no banco de dados**.
3. Encerrar o programa



#### Segundo Menu (Home Page)

O **segundo menu** é o menu em que o usuário já fez login. Terá as seguintes opções:

1. Mostrar todas as tarefas: essa opção apresentar a lista **completa** de tarefas para o usuário.

2. Mostrar tarefas finalizadas.

3. Mostrar tarefas **não** finalizadas.

4. Adicionar nova tarefa: **a nova tarefa deve ser persistida no banco de dados**.

5. Finalizar tarefa: essa opção vai apresentar um **menu auxiliar**, em que lista todas as tarefas que ainda **não foram finalizadas**.

   Ao listar essas tarefas, o **menu auxiliar** vai indicar um número sequencial para cada uma das tarefas e vai pedir para o usuário digitar o número referente à tarefa que ele deseja finalizar. (Veja o vídeo demonstrativo para ficar mais claro).

   Ao finalizar uma tarefa, o sistema **deve atualizar o banco de dados**.

6. Remover tarefa: para remover uma tarefa, seguir a mesma ideia de **menu auxiliar apresentando todas as tarefas e dando a cada uma delas um número de referência**. Depois, pedir para o usuário indicar qual tarefa ele quer remover através do número de referência. (Veja o vídeo demonstrativo para ficar mais claro).

   Ao remover uma tarefa, o sistema **deve atualizar o banco de dados**.

7. Fazer logout: essa opção simula um logout, levando o usuário de volta ao **menu principal**.



### Observações

- *Driver* de conexão com o *MySQL*, isto é, o arquivo .jar, está no repositório do *GitHub* dessa aula
- O código de explicação do vídeo de como acessar o *MySQL* com o Java também está no respositório do *GitHub*



---

### Vídeos de referência

1. Vídeo de explicação para a atividade: [https://youtu.be/xpD0d0Dfxp8](https://youtu.be/xpD0d0Dfxp8)
2. Demonstração do projeto: [https://youtu.be/S4JF52mXRpU](https://youtu.be/S4JF52mXRpU)
3. Vídeo de como usar o MySQL com o Java: [https://youtu.be/zdiiuLBDJPA](https://youtu.be/zdiiuLBDJPA)