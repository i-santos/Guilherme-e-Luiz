# Instruções



### Atividade 1



Desenvolver um programa que simula o sistema de Lista de Tarefas.

Por enquanto, esse programa não envolve banco de dados.

Os usuários cadastrados, e suas respectivas listas de tarefas, vão existir apenas durante a execução do programa.



1. Criar um projeto Java Padrão e dar o nome de `ListaDeTarefas`
2. Criar uma classe `Usuario`, que terá `email`, `senha` e um `ArrayList<Tarefa>`, e seus respectivos métodos de atribuição e retorno.
3. Criar uma classe `Tarefa`, que terá `titulo` e `finalizada` (para indicar se a tarefa já foi feita ou não), e seus respectivos métodos de atribuição e retorno.
4. Usar laço de repetição e `ArrayList` para desenvolver o programa de Lista de Tarefas.
5. O programa terá **DOIS** menus:



#### Primeiro Menu (menu principal)

O **primeiro menu** terá as seguintes opções:

1. Fazer cadastro: essa opção permitirá ao usuário realizar o cadastro no sistema; o programa exige o email e a senha do usuário para realizar o cadastro.
   - senha deve ter no mínimo 6 caracteres e no máximo 15
   - email deve ter um '@'
2. Fazer login: essa opção permitirá um usuário já cadastrado logar no sistema, informando email e senha. 
   - Verificar se email e senha realmente conferem com algum usuário cadastrado
   - Se email/senha estiverem corretos, então o login foi feito com sucesso e, portanto, **o programa deve levar o usuário para o segundo menu**.
   - Se email/senha estiverem **incorretos**, então o login falhou e, portanto, o programa deve informar o usuário sobre o erro e levá-lo de volta ao menu principal.
3. Encerrar o programa



#### Segundo Menu

O **segundo menu** é o menu em que o usuário já fez login. Terá as seguintes opções:

1. Mostrar todas as tarefas: essa opção apresentar a lista **completa** de tarefas para o usuário.

2. Mostrar tarefas finalizadas.

3. Mostrar tarefas **não** finalizadas.

4. Adicionar nova tarefa

5. Finalizar tarefa: essa opção vai apresentar um **menu auxiliar**, em que lista todas as tarefas que ainda **não foram finalizadas**.

   Ao listar essas tarefas, o **menu auxiliar** vai indicar um número sequencial para cada uma das tarefas e vai pedir para o usuário digitar o número referente à tarefa que ele deseja finalizar. (Veja o vídeo demonstrativo para ficar mais claro).

6. Remover tarefa: para remover uma tarefa, seguir a mesma ideia de **menu auxiliar apresentando todas as tarefas e dando a cada uma delas um número de referência**. Depois, pedir para o usuário indicar qual tarefa ele quer remover através do número de referência. (Veja o vídeo demonstrativo para ficar mais claro).

7. Fazer logout: essa opção simula um logout, levando o usuário de volta ao **menu principal**.



---

### Vídeos de referência

1. Demonstração do projeto: [https://youtu.be/S4JF52mXRpU](https://youtu.be/S4JF52mXRpU)